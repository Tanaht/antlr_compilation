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
@init{ $code = new Code3a(); symTab.enterScope(); }
@after{ symTab.leaveScope(); }
    : ^(FUNC_KW t=type IDENT pl=param_list  ^(BODY s1=statement[symTab]))
	{
		LabelSymbol deb = new LabelSymbol($IDENT.text);

		Operand3a op = symTab.lookup($IDENT.text);
		FunctionSymbol f = null;
    List<Type> argList = ((FunctionType) f.type).getArguments();
    ArrayList<Type> paramList = $pl.types;
    System.err.print("Nombre de params: ");
    System.err.println(paramList.size());

		if(op != null && op instanceof FunctionSymbol) {
		  f = (FunctionSymbol) op;
		  if(((FunctionType) f.type).prototype == false)
			Errors.redefinedIdentifier($IDENT, $IDENT.text,"");



		if(argList.size() != paramList.size())
			Errors.miscError($IDENT, "Definition differente du prototype");

		for(int i=0; i < argList.size(); i++){

					if(argList.get(i) != paramList.get(i))
						Errors.incompatibleTypes($IDENT, argList.get(i), paramList.get(i), "Pour le " + i + " arguments de la fonction");

		}

		  ((FunctionType) f.type).prototype = false;
		}
		else {
		  FunctionType ft = new FunctionType($t.type, false);
		  for(Type type : $pl.types) {
			  ft.extend(type);
		  }
		  f = new FunctionSymbol(deb, ft);
		  symTab.insert($IDENT.text, f);
		}

		$code.append(new Inst3a(Inst3a.TAC.LABEL, deb, null, null));
		$code.append(new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null));
    //déclaration des variables
    System.err.print("Nombre de params: ");
    System.err.println(paramList.size());

    symTab.print();
		$code.append($s1.code);
		$code.append(new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null));
	}
    ;

proto [SymbolTable symTab]returns [Code3a code]
@init{ $code = new Code3a(); }
    : ^(PROTO_KW t=type IDENT pl=param_list)
	{
		if(symTab.lookup($IDENT.text)!= null){
			Errors.redefinedIdentifier($IDENT, $IDENT.text,"");
		}
		LabelSymbol deb = new LabelSymbol($IDENT.text);
		FunctionType ft = new FunctionType($t.type, true);
		for(Type type : $pl.types) {
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

param_list returns [ArrayList<Type> types]
@init { $types = new ArrayList<Type>(); }//TODO: Changer les variables synthétisé par la suite
    : ^(PARAM (param { $types.add($param.type); System.out.println("Taille: " + $types.size()); })*)
    ;

param returns [Type type]
    : IDENT {$type = Type.INT ; }
    | ^(ARRAY IDENT) {$type = Type.POINTER; }
    ;


decl_item [SymbolTable symTab] returns [Code3a code]
    : IDENT//Variable Declaration
      {
		if(symTab.lookup($IDENT.text)!= null){
			Errors.redefinedIdentifier($IDENT, $IDENT.text,"");
		}
        Operand3a var = new VarSymbol(Type.INT, $IDENT.text, $symTab.getScope());
        symTab.insert($IDENT.text, var);
        $code = Code3aGenerator.genVar(var);
      }
    | ^(ARDECL IDENT INTEGER)//Array Declaration
      {
		if(symTab.lookup($IDENT.text)!= null){
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


	if(args.get(numArg) == Type.POINTER){
		if(!($arg.expAtt.type instanceof ArrayType))
			Errors.incompatibleTypes($IDENT, args.get(numArg), $arg.expAtt.type, "Pour le " + numArg + " arguments de la fonction");
	}else{
		if(args.get(numArg) != $arg.expAtt.type)
			Errors.incompatibleTypes($IDENT, args.get(numArg), $arg.expAtt.type, "Pour le " + numArg + " arguments de la fonction");
	}
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

        Code3a code = Code3aGenerator.genVar(temp);
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
        symTab.print();
        Errors.unknownIdentifier($IDENT, $IDENT.text, null);
      }
      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
  | a=array_elem_value[symTab]
    {
      $expAtt = $a.expAtt;
    }
  |^(FCALL IDENT {
    int numArg = 0;
    Operand3a op = symTab.lookup($IDENT.text);
    Type typeFun = TypeCheck.checkFunc(op);
    FunctionSymbol f = null;
    if(typeFun == Type.ERROR)
      Errors.unknownIdentifier($IDENT, $IDENT.text, null);

    if(typeFun != Type.INT)
      Errors.incompatibleTypes($IDENT, Type.INT, typeFun, "");

    VarSymbol temp = SymbDistrib.newTemp();
    f = (FunctionSymbol) op;

    List<Type> args = ((FunctionType) f.type).getArguments();

    Code3a code = Code3aGenerator.genVar(temp);

    } (arg=argument_item[symTab] {
      //System.err.println("La taille des arguments: " + args.size() + " pour la fonction: " + $IDENT.text);

      if(args.get(numArg) != $arg.expAtt.type)
        Errors.incompatibleTypes($IDENT, args.get(numArg), $arg.expAtt.type, "Pour le " + numArg + " arguments de la fonction");

      /*if(args.get(numArg) == Type.POINTER) {
          VarSymbol temp2 = SymbDistrib.newTemp();
          code.append(Code3aGenerator.genVar(temp2));
          code.append(new Inst3a(Inst3a.TAC.TABVAR, temp2, $arg.expAtt.place, new ConstSymbol(0)));
          code.append(new Inst3a(Inst3a.TAC.ARG, temp2, null, null));
      }
      else {*/
          code.append(new Inst3a(Inst3a.TAC.ARG, $arg.expAtt.place, null, null));
      //}

      numArg++;

    })*)
	{
		if (typeFun == Type.INT){
			code.append(new Inst3a(Inst3a.TAC.CALL,temp,op,null));
			$expAtt = new ExpAttribute(Type.INT, code, temp);
		}

	}
  ;


argument_item [SymbolTable symTab] returns [ExpAttribute expAtt]
    : a=expression[symTab] { $expAtt = $a.expAtt; }
    ;
