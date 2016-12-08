tree grammar VSLTreeParser;

/*
SymbDistrib.builtinPrintN
SymbDistrib.builtinPrintS
SymbDistrib.builtinRead
*/

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

s [SymbolTable symTab] returns [Code3a code]
  : p=program[symTab]{$code = $p.code;}
  ;


program [SymbolTable symTab] returns [Code3a code]
@init{ $code = new Code3a(); }
    : ^(PROG (u=unit[symTab] {$code.append($u.code); } )+)
    ;


unit [SymbolTable symTab] returns [Code3a code]
@init{ $code = new Code3a(); }
    : f=function[symTab] {$code = $f.code; }
    | p=proto[symTab]{$code = $p.code; }
    ;

function [SymbolTable symTab] returns [Code3a code]
@init{
  $code = new Code3a();
  ArrayList<Type> paramsType = new ArrayList<Type>();
  ArrayList<String> paramsNom = new ArrayList<String>();
}
@after{ symTab.leaveScope(); }
    : ^(FUNC_KW t=type IDENT ^(PARAM (pa=param { paramsType.add($pa.type); paramsNom.add($pa.nom); } )*) {

      LabelSymbol deb = new LabelSymbol($IDENT.text);
      Operand3a storedFunction = symTab.lookup($IDENT.text);
      FunctionSymbol f = null;

      //Si Fonction auparavant défini comme prototype
      if(storedFunction != null && storedFunction instanceof FunctionSymbol) {
        f = (FunctionSymbol) storedFunction;
        List<Type> argList = ((FunctionType) f.type).getArguments();

        if(((FunctionType) f.type).prototype == false)
           Errors.redefinedIdentifier($IDENT, $IDENT.text,"");


        if(argList.size() != paramsType.size() || ((FunctionType) f.type).getReturnType() != $t.type)
          Errors.miscError($FUNC_KW, "Definition differente du prototype [Nombre arguments ou type de retour différents]");

        for(int i=0; i < argList.size(); i++) {
          if(argList.get(i) != paramsType.get(i))
            Errors.incompatibleTypes($IDENT, argList.get(i), paramsType.get(i), "Pour le " + i + " arguments de la fonction "+$IDENT.text);
        }


        ((FunctionType) f.type).prototype = false;
      }
      else {//Si aucun prototype
        FunctionType ft = new FunctionType($t.type, false);
        for(Type type : paramsType) {
          ft.extend(type);
        }
        f = new FunctionSymbol(deb, ft);
        symTab.insert($IDENT.text, f);
      }
      $code.append(new Inst3a(Inst3a.TAC.LABEL, deb, null, null));
      $code.append(new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null));
      //déclaration des variables
      symTab.enterScope();
      for(int i=0; i < paramsType.size(); i++) {
        VarSymbol var = new VarSymbol(paramsType.get(i), paramsNom.get(i), symTab.getScope());
        var.setParam();
        symTab.insert(paramsNom.get(i), var);
        $code.append(Code3aGenerator.genVar(var));
      }

      }  ^(BODY s1=statement[symTab]))
	{
		$code.append($s1.code);
		$code.append(new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null));
	}
    ;

param returns [Type type, String nom]
    : IDENT {$type = Type.INT; $nom = $IDENT.text; }
    | ^(ARRAY IDENT) {$type = Type.POINTER; $nom = $IDENT.text; }
    ;


proto [SymbolTable symTab]returns [Code3a code]
@init{ $code = new Code3a(); ArrayList<Type> paramsType = new ArrayList<Type>(); }
    : ^(PROTO_KW t=type IDENT ^(PARAM (pa=param { paramsType.add($pa.type); })*))
	{
    Operand3a v = symTab.lookup($IDENT.text);
		if(v!= null && v.getScope() == symTab.getScope()){
			Errors.redefinedIdentifier($IDENT, $IDENT.text,"");
		}
		LabelSymbol deb = new LabelSymbol($IDENT.text);
		FunctionType ft = new FunctionType($t.type, true);
		for(Type type : paramsType) {
			ft.extend(type);
		}

		FunctionSymbol f = new FunctionSymbol(deb, ft);
		symTab.insert($IDENT.text, f);
	}
    ;

type returns [Type type]
    : INT_KW {$type = Type.INT;}
    | VOID_KW {$type = Type.VOID;}
    ;

decl_item [SymbolTable symTab] returns [Code3a code]
    : IDENT//Variable Declaration
      {
        Operand3a v = symTab.lookup($IDENT.text);
    		if(v!= null && v.getScope() == symTab.getScope()){
			       Errors.redefinedIdentifier($IDENT, $IDENT.text,"");
		}
        Operand3a var = new VarSymbol(Type.INT, $IDENT.text, $symTab.getScope());
        symTab.insert($IDENT.text, var);
        $code = Code3aGenerator.genVar(var);
      }
    | ^(ARDECL IDENT INTEGER)//Array Declaration
      {
        Operand3a v = symTab.lookup($IDENT.text);
    		if(v!= null && v.getScope() == symTab.getScope()){
			       Errors.redefinedIdentifier($IDENT, $IDENT.text,"");
		}
        Operand3a var = new VarSymbol(new ArrayType(Type.INT, Integer.parseInt($INTEGER.text)), $IDENT.text, $symTab.getScope());
        symTab.insert($IDENT.text, var);
        $code = Code3aGenerator.genVar(var);
      }
    ;

declaration [SymbolTable symTab] returns [Code3a code]
@init{ $code = new Code3a(); }
    : ^(DECL (a=decl_item[symTab] {
        $code.append($a.code);
      })+)
    ;

inst_list [SymbolTable symTab] returns [Code3a code]
@init{ $code = new Code3a(); }
    : ^(INST (a=statement[symTab] {
        $code.append($a.code);
      })+)
    ;

block [SymbolTable symTab] returns [Code3a code]
@init{ symTab.enterScope(); }
@after{ symTab.leaveScope(); }
    : ^(BLOCK a=declaration[symTab] b=inst_list[symTab])
      {
        $code = $a.code;
        $code.append($b.code);
      }
    | ^(BLOCK c=inst_list[symTab])
      {
        $code = $c.code;
      }
    ;

statement [SymbolTable symTab] returns [Code3a code]
@init{ $code = new Code3a(); }
  : ^(ASSIGN_KW a=expression[symTab] ( IDENT {
      //Assign Var
      Operand3a variable = symTab.lookup($IDENT.text);
      if(variable == null) {
        Errors.unknownIdentifier($ASSIGN_KW, $IDENT.text, null);
      }

      if(variable.type != $a.expAtt.type && $a.expAtt.type != Type.POINTER)
        Errors.incompatibleTypes($ASSIGN_KW, variable.type, $a.expAtt.type, "Mauvaise Assignation");

      $code = Code3aGenerator.assignVar(variable, $a.expAtt);
    } | c=array_elem_assign[symTab, $a.expAtt] {
      //Assign Var Tab
      $code = $c.code;
    }))
  | b=block[symTab]
    {
      $code.append($b.code);
    }
  |  ^(PRINT_KW (z=print_item[symTab]
    {
      $code.append($z.code);
    })+)
  | ^(READ_KW (j=read_item[symTab]
    {
      $code.append($j.code);
    })+)
  | ^(IF_KW e=expression[symTab]  s1=statement[symTab]
  	{
      	LabelSymbol fin = SymbDistrib.newLabel();
  		$code = Code3aGenerator.genIf($e.expAtt, $s1.code, fin);

  	}
  	(s2=statement[symTab]
  	{
  		$code.append($s2.code);
  	})?
  	{

  		$code.append(new Inst3a(Inst3a.TAC.LABEL, fin, null, null));
  	}
	)
  | ^(WHILE_KW e=expression[symTab] s1=statement[symTab])
  	{
  		$code = Code3aGenerator.genWhile($e.expAtt, $s1.code);

  	}
| ^(FCALL_S IDENT {
  int numArg = 0;
  Operand3a op = symTab.lookup($IDENT.text);
  Type typeFun = TypeCheck.checkFunc(op);
  FunctionSymbol f = null;
  if(typeFun != Type.ERROR)
    f = (FunctionSymbol) op;
  else
    Errors.unknownIdentifier($IDENT, $IDENT.text, null);

  List<Type> args = ((FunctionType) f.type).getArguments();

  } (arg=argument_item[symTab] {
    if(!TypeCheck.checkType(args.get(numArg), $arg.expAtt.type))
      Errors.incompatibleTypes($FCALL_S, args.get(numArg), $arg.expAtt.type , "Appelle de la fonction "+$IDENT.text);

    $code.append($arg.expAtt.code);
    $code.append(new Inst3a(Inst3a.TAC.ARG, $arg.expAtt.place, null, null));
    numArg++;
  })*)
	{
		if(args.size() != numArg){
			Errors.miscError($IDENT, "Arguments attendus"+args);
		}
		$code.append(new Inst3a(Inst3a.TAC.CALL, null, op, null));

	}
	|^(RETURN_KW exp=expression[symTab])
		{
      if(exp.type != Type.INT)
        Errors.incompatibleTypes($RETURN_KW, Type.INT, exp.type, "Mauvais type de retour, seul les entiers sont supportés");

			$code.append(exp.code);
			$code.append(new Inst3a(Inst3a.TAC.RETURN,exp.place,null,null));
		}
    ;

  print_item [SymbolTable symTab] returns [Code3a code]
    : TEXT
      {

        Data3a data = new Data3a($TEXT.text);

        $code = Code3aGenerator.callPrintS(data);
      }
    | a=expression[symTab]
      {
        $code = $a.expAtt.code;
        $code.append(Code3aGenerator.callPrintN($a.expAtt.place));
      }
    ;

read_item [SymbolTable symTab] returns [Code3a code]
    :IDENT
      {
        Operand3a variable = symTab.lookup($IDENT.text);
        $code = Code3aGenerator.callRead(variable);
      }
    | ^(ARELEM  IDENT a=expression[symTab])
      {
        VarSymbol temp = SymbDistrib.newTemp();
        $code = Code3aGenerator.genVar(temp);
        $code.append(Code3aGenerator.callRead(temp));

        Operand3a tab = symTab.lookup($IDENT.text);

        if(tab == null)
          Errors.unknownIdentifier($IDENT, $IDENT.text, null);

        $code.append($a.expAtt.code);
        $code.append(new Inst3a(Inst3a.TAC.VARTAB, tab, $a.expAtt.place, temp));
      }

    ;


array_elem_assign [SymbolTable symTab, ExpAttribute valueToAssign] returns [Code3a code]
    : ^(ARELEM  IDENT a=expression[symTab])
      {
        Operand3a variable = symTab.lookup($IDENT.text);

        if(variable == null)
          Errors.unknownIdentifier($IDENT, $IDENT.text, null);

        //Test que l'index du tableau est un entier.
        if(Type.INT != $a.expAtt.type)
          Errors.incompatibleTypes($ARELEM, Type.INT, $a.expAtt.type, "");

        if(Type.INT != valueToAssign.type && Type.POINTER != valueToAssign.type)
          Errors.incompatibleTypes($ARELEM, Type.INT, valueToAssign.type, "Mauvaise assignation");

        $code = Code3aGenerator.assignVarTab(variable, $a.expAtt, valueToAssign);
      }
    ;

array_elem_value [SymbolTable symTab] returns [ExpAttribute expAtt]
    : ^(ARELEM  IDENT a=expression[symTab])
      {
        VarSymbol temp = SymbDistrib.newTemp();
        Operand3a variable = symTab.lookup($IDENT.text);

        if(variable == null)
          Errors.unknownIdentifier($IDENT, $IDENT.text, null);

        //Test que l'index du tableau est un entier.
        if(Type.INT != $a.expAtt.type)
          Errors.incompatibleTypes($ARELEM, Type.INT, $a.expAtt.type, "");

        Code3a code = Code3aGenerator.genVar(temp);
        code.append($a.expAtt.code);
        code.append(new Inst3a(Inst3a.TAC.TABVAR, temp, variable, $a.expAtt.place));
        $expAtt = new ExpAttribute(variable.type, code, temp);
      }
    ;

expression [SymbolTable symTab] returns [ExpAttribute expAtt]
  : ^(PLUS e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
      $expAtt = new ExpAttribute(ty, cod, temp);
    }
  | ^(MINUS e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | ^(MUL e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | ^(DIV e1=expression[symTab] e2=expression[symTab])
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | ^(NEGAT e1=expression[symTab])
  	{
  		Type ty = e1.type;
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genUnOp(Inst3a.TAC.NEG, temp, e1);
      expAtt = new ExpAttribute(ty, cod, temp);
  	}
  | pe=primary_exp[symTab]
    { expAtt = pe; }
  ;

primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);

      if(id == null) {
        Errors.unknownIdentifier($IDENT, $IDENT.text, null);
      }
      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
  | a=array_elem_value[symTab]
    {
      $expAtt = $a.expAtt;
    }
  |^(FCALL IDENT
    {
      int numArg = 0;
      Operand3a op = symTab.lookup($IDENT.text);
      Type typeFun = TypeCheck.checkFunc(op);
      FunctionSymbol f = null;

      if(typeFun == Type.ERROR)
        Errors.unknownIdentifier($IDENT, $IDENT.text, null);

      if(typeFun != Type.INT)
        Errors.incompatibleTypes($IDENT, Type.INT, typeFun, "fonction "+$IDENT.text);

      VarSymbol temp = SymbDistrib.newTemp();
      f = (FunctionSymbol) op;
      List<Type> args = ((FunctionType) f.type).getArguments();
      Code3a code = Code3aGenerator.genVar(temp);
    }
    (arg=argument_item[symTab]
    {

      if(!TypeCheck.checkType(args.get(numArg), $arg.expAtt.type))
        Errors.incompatibleTypes($FCALL, args.get(numArg), $arg.expAtt.type , "Appelle de la fonction "+$IDENT.text);
      code.append($arg.expAtt.code);
      code.append(new Inst3a(Inst3a.TAC.ARG, $arg.expAtt.place, null, null));
      numArg++;
    })*)
	{
		if (typeFun == Type.INT)
    {
			code.append(new Inst3a(Inst3a.TAC.CALL,temp,op,null));
			$expAtt = new ExpAttribute(Type.INT, code, temp);
		}
	}
  ;


argument_item [SymbolTable symTab] returns [ExpAttribute expAtt]
    : a=expression[symTab] { $expAtt = $a.expAtt; }
    ;
