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
    : ^(PROG (u=unit[symTab] {$code = $u.code ;} )+) 
    ;


unit [SymbolTable symTab] returns [Code3a code]
@init{ $code = new Code3a(); }
    : f=function[symTab] {$code = $f.code; }
    | p=proto[symTab]{$code = $p.code; }
    ;

function [SymbolTable symTab] returns [Code3a code]
@init{ $code = new Code3a(); }
    : ^(FUNC_KW t=type IDENT pl=param_list  ^(BODY s1=statement[symTab]))
	{
		LabelSymbol deb = new LabelSymbol($IDENT.text);
		FunctionType ft = new FunctionType($t.type, false);
		FunctionSymbol f = new FunctionSymbol(deb, ft);
		symTab.insert($IDENT.text, f);
		
  		code.append(new Inst3a(Inst3a.TAC.LABEL, deb, null, null));
		$code.append(new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null));		
		$code.append($s1.code);
		$code.append(new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null));
	}
    ;

proto [SymbolTable symTab]returns [Code3a code]
@init{ $code = new Code3a(); }
    : ^(PROTO_KW t=type IDENT pl=param_list)
	{
		LabelSymbol deb = new LabelSymbol($IDENT.text);
		FunctionType ft = new FunctionType($t.type, true);
		

		FunctionSymbol f = new FunctionSymbol(deb, ft);
		symTab.insert($IDENT.text, f);
	}
    ;

type returns [Type type]
    : INT_KW {$type = Type.INT;}
    | VOID_KW {$type = Type.VOID;}
    ;

param_list
    : ^(PARAM param*)
    | PARAM
    ;

param
    : IDENT
    | ^(ARRAY IDENT)
    ;


decl_item [SymbolTable symTab] returns [Code3a code]
    : IDENT//Variable Declaration
      {
        Operand3a var = new VarSymbol(Type.INT, $IDENT.text, $symTab.getScope());
        symTab.insert($IDENT.text, var);
        VarSymbol temp = SymbDistrib.newTemp();
        $code = Code3aGenerator.genVar(var);
      }
    | ^(ARDECL IDENT INTEGER)//Array Declaration
      {
        Operand3a var = new VarSymbol(new ArrayType(Type.INT, Integer.parseInt($INTEGER.text)), $IDENT.text, $symTab.getScope());
        symTab.insert($IDENT.text, var);
        VarSymbol temp = SymbDistrib.newTemp();
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
| ^(FCALL_S IDENT (argument_list[symTab])?)
	{
		Operand3a op = symTab.lookup($IDENT.text);
		
		if (TypeCheck.checkFunc(op) != Type.ERROR){
			LabelSymbol l = ((FunctionSymbol) op).label;
			$code.append(new Inst3a(Inst3a.TAC.CALL, null, l, null));
		}else {
			Errors.unknownIdentifier($IDENT, $IDENT.text, null);
		}	
		
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
  /*
  | RETURN_KW^ expression
  | PRINT_KW^ print_list
  | READ_KW^ read_list
  | 
  | block*/


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

      if(id == null)
        Errors.unknownIdentifier($IDENT, $IDENT.text, null);

      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
  | a=array_elem_value[symTab]
    {
      $expAtt = $a.expAtt;
    }
  |^(FCALL IDENT (argument_list[symTab])?)
	{
		Operand3a op = symTab.lookup($IDENT.text);
		Type t = TypeCheck.checkFunc(op);
		if (t == Type.INT){
			VarSymbol temp = SymbDistrib.newTemp();
        		Code3a code = Code3aGenerator.genVar(temp);
			code.append(new Inst3a(Inst3a.TAC.CALL,temp,op,null));
			$expAtt = new ExpAttribute(t, code, temp);
		}
			
	}
  ;


argument_list [SymbolTable symTab]
    : expression[symTab] (expression[symTab])*
    ;


