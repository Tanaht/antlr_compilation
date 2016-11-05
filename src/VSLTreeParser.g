tree grammar VSLTreeParser;

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

s [SymbolTable symTab] returns [Code3a code]
  : e=statement[symTab] { code = $e.code; }
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
    : ^(DECL (a=decl_item[symTab] {
        if($code == null)//decl_item peut-être présente 1 ou n fois, le if correspond au 1
          $code = $a.code;
        else//le else correspond au n
          $code.append($a.code);
      })+)
    ;

inst_list [SymbolTable symTab] returns [Code3a code]
    : ^(INST (a=statement[symTab] {
        if($code == null)//statement peut-être présente 1 ou n fois, le if correspond au 1
          $code = $a.code;
        else//le else correspond au n
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
  : ^(ASSIGN_KW a=expression[symTab] ( IDENT {
      //Assign Var
      Operand3a variable = symTab.lookup($IDENT.text);
      $code = Code3aGenerator.assignVar(variable, $a.expAtt);
    } | c=array_elem[symTab, $a.expAtt] {
      //Assign Var Tab
      $code = $c.code;
    }))
  | b=block[symTab]
    {
      if($code == null)
        $code = $b.code;
      else
        $code.append($b.code);
    }
  | ^(IF_KW e=expression[symTab]  s1=statement[symTab] 
	{
		LabelSymbol vrai = SymbDistrib.newLabel();
		LabelSymbol faux = SymbDistrib.newLabel();
		LabelSymbol fin = SymbDistrib.newLabel();

		VarSymbol t1 = SymbDistrib.newTemp();

		$code = Code3aGenerator.assignVar(t1, $e.expAtt);

		$code.append(new Inst3a(Inst3a.TAC.IFZ, t1, faux, null));

		$code.append($s1.code);
		$code.append(new Inst3a(Inst3a.TAC.GOTO, fin, null, null));

		$code.append(new Inst3a(Inst3a.TAC.LABEL, faux, null, null));
			
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
		LabelSymbol debut = SymbDistrib.newLabel();
		LabelSymbol fin = SymbDistrib.newLabel();
		$code = new Code3a();		

		$code.append(new Inst3a(Inst3a.TAC.LABEL, debut, null, null));
		
		VarSymbol t1 = SymbDistrib.newTemp();
		$code.append(Code3aGenerator.assignVar(t1, $e.expAtt));
		
		$code.append(new Inst3a(Inst3a.TAC.IFZ, t1, fin, null));

		$code.append($s1.code);

		$code.append(new Inst3a(Inst3a.TAC.LABEL, fin, null, null));
		
	}
  ;

  /*
  | RETURN_KW^ expression
  | PRINT_KW^ print_list
  | READ_KW^ read_list
  | WHILE_KW^ expression DO_KW! statement OD_KW!
  | ^(FCALL_S IDENT argument_list?)
  | block*/

/*
En attendant de trouver une meilleure solution, je passe la valeur à assigner dans le tableau par héritage
*/
array_elem [SymbolTable symTab, ExpAttribute valueToAssign] returns [Code3a code]
    : ^(ARELEM  IDENT a=expression[symTab])
      {
        Operand3a variable = symTab.lookup($IDENT.text);
        $code = Code3aGenerator.assignVarTab(variable, $a.expAtt, valueToAssign);
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
      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
  ;
