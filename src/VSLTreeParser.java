// $ANTLR 3.5.2 VSLTreeParser.g 2016-11-08 09:54:41

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class VSLTreeParser extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASCII", "ASSIGN_KW", "COM", "COMMENT", 
		"DIGIT", "DIV", "DO_KW", "ELSE_KW", "FI_KW", "FUNC_KW", "IDENT", "IF_KW", 
		"INTEGER", "INT_KW", "LB", "LC", "LETTER", "LP", "MINUS", "MUL", "OD_KW", 
		"PLUS", "PRINT_KW", "PROTO_KW", "RB", "RC", "READ_KW", "RETURN_KW", "RP", 
		"TEXT", "THEN_KW", "VOID_KW", "WHILE_KW", "WS", "ARDECL", "ARELEM", "ARRAY", 
		"BLOCK", "BODY", "DECL", "FCALL", "FCALL_S", "INST", "NEGAT", "PARAM", 
		"PROG"
	};
	public static final int EOF=-1;
	public static final int ASCII=4;
	public static final int ASSIGN_KW=5;
	public static final int COM=6;
	public static final int COMMENT=7;
	public static final int DIGIT=8;
	public static final int DIV=9;
	public static final int DO_KW=10;
	public static final int ELSE_KW=11;
	public static final int FI_KW=12;
	public static final int FUNC_KW=13;
	public static final int IDENT=14;
	public static final int IF_KW=15;
	public static final int INTEGER=16;
	public static final int INT_KW=17;
	public static final int LB=18;
	public static final int LC=19;
	public static final int LETTER=20;
	public static final int LP=21;
	public static final int MINUS=22;
	public static final int MUL=23;
	public static final int OD_KW=24;
	public static final int PLUS=25;
	public static final int PRINT_KW=26;
	public static final int PROTO_KW=27;
	public static final int RB=28;
	public static final int RC=29;
	public static final int READ_KW=30;
	public static final int RETURN_KW=31;
	public static final int RP=32;
	public static final int TEXT=33;
	public static final int THEN_KW=34;
	public static final int VOID_KW=35;
	public static final int WHILE_KW=36;
	public static final int WS=37;
	public static final int ARDECL=38;
	public static final int ARELEM=39;
	public static final int ARRAY=40;
	public static final int BLOCK=41;
	public static final int BODY=42;
	public static final int DECL=43;
	public static final int FCALL=44;
	public static final int FCALL_S=45;
	public static final int INST=46;
	public static final int NEGAT=47;
	public static final int PARAM=48;
	public static final int PROG=49;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public VSLTreeParser(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public VSLTreeParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return VSLTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "VSLTreeParser.g"; }



	// $ANTLR start "s"
	// VSLTreeParser.g:15:1: s[SymbolTable symTab] returns [Code3a code] : e= statement[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a e =null;

		try {
			// VSLTreeParser.g:16:3: (e= statement[symTab] )
			// VSLTreeParser.g:16:5: e= statement[symTab]
			{
			pushFollow(FOLLOW_statement_in_s63);
			e=statement(symTab);
			state._fsp--;

			 code = e; 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "s"



	// $ANTLR start "decl_item"
	// VSLTreeParser.g:19:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT1=null;
		CommonTree INTEGER2=null;
		CommonTree IDENT3=null;

		try {
			// VSLTreeParser.g:20:5: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==IDENT) ) {
				alt1=1;
			}
			else if ( (LA1_0==ARDECL) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// VSLTreeParser.g:20:7: IDENT
					{
					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item87); 

					        Operand3a var = new VarSymbol(Type.INT, (IDENT1!=null?IDENT1.getText():null), symTab.getScope());
					        symTab.insert((IDENT1!=null?IDENT1.getText():null), var);
					        VarSymbol temp = SymbDistrib.newTemp();
					        code = Code3aGenerator.genVar(var);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:27:7: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item104); 
					match(input, Token.DOWN, null); 
					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item106); 
					INTEGER2=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item108); 
					match(input, Token.UP, null); 


					        Operand3a var = new VarSymbol(new ArrayType(Type.INT, Integer.parseInt((INTEGER2!=null?INTEGER2.getText():null))), (IDENT3!=null?IDENT3.getText():null), symTab.getScope());
					        symTab.insert((IDENT3!=null?IDENT3.getText():null), var);
					        VarSymbol temp = SymbDistrib.newTemp();
					        code = Code3aGenerator.genVar(var);
					      
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "decl_item"



	// $ANTLR start "declaration"
	// VSLTreeParser.g:36:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (a= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;

		try {
			// VSLTreeParser.g:37:5: ( ^( DECL (a= decl_item[symTab] )+ ) )
			// VSLTreeParser.g:37:7: ^( DECL (a= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration141); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:37:14: (a= decl_item[symTab] )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==IDENT||LA2_0==ARDECL) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// VSLTreeParser.g:37:15: a= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration146);
					a=decl_item(symTab);
					state._fsp--;


					        if(code == null)//decl_item peut-être présente 1 ou n fois, le if correspond au 1
					          code = a;
					        else//le else correspond au n
					          code.append(a);
					      
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "inst_list"
	// VSLTreeParser.g:45:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (a= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;

		try {
			// VSLTreeParser.g:46:5: ( ^( INST (a= statement[symTab] )+ ) )
			// VSLTreeParser.g:46:7: ^( INST (a= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list176); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:46:14: (a= statement[symTab] )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ASSIGN_KW||LA3_0==IF_KW||LA3_0==PRINT_KW||LA3_0==WHILE_KW||LA3_0==BLOCK) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// VSLTreeParser.g:46:15: a= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list181);
					a=statement(symTab);
					state._fsp--;


					        if(code == null)//statement peut-être présente 1 ou n fois, le if correspond au 1
					          code = a;
					        else//le else correspond au n
					          code.append(a);
					      
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "inst_list"



	// $ANTLR start "block"
	// VSLTreeParser.g:54:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK a= declaration[symTab] b= inst_list[symTab] ) | ^( BLOCK c= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;
		Code3a b =null;
		Code3a c =null;

		 symTab.enterScope(); 
		try {
			// VSLTreeParser.g:57:5: ( ^( BLOCK a= declaration[symTab] b= inst_list[symTab] ) | ^( BLOCK c= inst_list[symTab] ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==BLOCK) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==DOWN) ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2==DECL) ) {
						alt4=1;
					}
					else if ( (LA4_2==INST) ) {
						alt4=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// VSLTreeParser.g:57:7: ^( BLOCK a= declaration[symTab] b= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block219); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block223);
					a=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block228);
					b=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = a;
					        code.append(b);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:62:7: ^( BLOCK c= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block247); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block251);
					c=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = c;
					      
					}
					break;

			}
			 symTab.leaveScope(); 
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "block"



	// $ANTLR start "statement"
	// VSLTreeParser.g:68:1: statement[SymbolTable symTab] returns [Code3a code] : ( ^( ASSIGN_KW a= expression[symTab] ( IDENT |c= array_elem_assign[symTab, $a.expAtt] ) ) |b= block[symTab] | ^( PRINT_KW (z= print_item[symTab] )+ ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT4=null;
		ExpAttribute a =null;
		Code3a c =null;
		Code3a b =null;
		Code3a z =null;
		ExpAttribute e =null;
		Code3a s1 =null;
		Code3a s2 =null;

		try {
			// VSLTreeParser.g:69:3: ( ^( ASSIGN_KW a= expression[symTab] ( IDENT |c= array_elem_assign[symTab, $a.expAtt] ) ) |b= block[symTab] | ^( PRINT_KW (z= print_item[symTab] )+ ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) )
			int alt8=5;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt8=1;
				}
				break;
			case BLOCK:
				{
				alt8=2;
				}
				break;
			case PRINT_KW:
				{
				alt8=3;
				}
				break;
			case IF_KW:
				{
				alt8=4;
				}
				break;
			case WHILE_KW:
				{
				alt8=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// VSLTreeParser.g:69:5: ^( ASSIGN_KW a= expression[symTab] ( IDENT |c= array_elem_assign[symTab, $a.expAtt] ) )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement283); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement287);
					a=expression(symTab);
					state._fsp--;

					// VSLTreeParser.g:69:38: ( IDENT |c= array_elem_assign[symTab, $a.expAtt] )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==IDENT) ) {
						alt5=1;
					}
					else if ( (LA5_0==ARELEM) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// VSLTreeParser.g:69:40: IDENT
							{
							IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement292); 

							      //Assign Var
							      Operand3a variable = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
							      code = Code3aGenerator.assignVar(variable, a);
							    
							}
							break;
						case 2 :
							// VSLTreeParser.g:73:9: c= array_elem_assign[symTab, $a.expAtt]
							{
							pushFollow(FOLLOW_array_elem_assign_in_statement300);
							c=array_elem_assign(symTab, a);
							state._fsp--;


							      //Assign Var Tab
							      code = c;
							    
							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// VSLTreeParser.g:77:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement313);
					b=block(symTab);
					state._fsp--;


					      if(code == null)
					        code = b;
					      else
					        code.append(b);
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:84:6: ^( PRINT_KW (z= print_item[symTab] )+ )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement328); 
					match(input, Token.DOWN, null); 
					// VSLTreeParser.g:84:17: (z= print_item[symTab] )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==DIV||LA6_0==IDENT||LA6_0==INTEGER||(LA6_0 >= MINUS && LA6_0 <= MUL)||LA6_0==PLUS||LA6_0==TEXT||LA6_0==ARELEM||LA6_0==NEGAT) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// VSLTreeParser.g:84:18: z= print_item[symTab]
							{
							pushFollow(FOLLOW_print_item_in_statement333);
							z=print_item(symTab);
							state._fsp--;


							      if(code == null)
							        code = z;
							      else
							        code.append(z);
							    
							}
							break;

						default :
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							throw eee;
						}
						cnt6++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// VSLTreeParser.g:91:5: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement350); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement354);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement360);
					s1=statement(symTab);
					state._fsp--;


					    LabelSymbol fin = SymbDistrib.newLabel();
							code = Code3aGenerator.genIf(e, s1, fin);

						
					// VSLTreeParser.g:97:2: (s2= statement[symTab] )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==ASSIGN_KW||LA7_0==IF_KW||LA7_0==PRINT_KW||LA7_0==WHILE_KW||LA7_0==BLOCK) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// VSLTreeParser.g:97:3: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement370);
							s2=statement(symTab);
							state._fsp--;


									code.append(s2);
								
							}
							break;

					}



							code.append(new Inst3a(Inst3a.TAC.LABEL, fin, null, null));
						
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// VSLTreeParser.g:106:5: ^( WHILE_KW e= expression[symTab] s1= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement389); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement393);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement398);
					s1=statement(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							code = Code3aGenerator.genWhile(e, s1);

						
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "statement"



	// $ANTLR start "print_item"
	// VSLTreeParser.g:113:3: print_item[SymbolTable symTab] returns [Code3a code] : ( TEXT |a= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree TEXT5=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:114:5: ( TEXT |a= expression[symTab] )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==TEXT) ) {
				alt9=1;
			}
			else if ( (LA9_0==DIV||LA9_0==IDENT||LA9_0==INTEGER||(LA9_0 >= MINUS && LA9_0 <= MUL)||LA9_0==PLUS||LA9_0==ARELEM||LA9_0==NEGAT) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// VSLTreeParser.g:114:7: TEXT
					{
					TEXT5=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item426); 

					        LabelSymbol label = new LabelSymbol((TEXT5!=null?TEXT5.getText():null));
					        code = Code3aGenerator.callPrintS(label);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:119:7: a= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item444);
					a=expression(symTab);
					state._fsp--;


					        code = Code3aGenerator.callPrintN(a.place);
					      
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "print_item"



	// $ANTLR start "array_elem_assign"
	// VSLTreeParser.g:134:1: array_elem_assign[SymbolTable symTab, ExpAttribute valueToAssign] returns [Code3a code] : ^( ARELEM IDENT a= expression[symTab] ) ;
	public final Code3a array_elem_assign(SymbolTable symTab, ExpAttribute valueToAssign) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT6=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:135:5: ( ^( ARELEM IDENT a= expression[symTab] ) )
			// VSLTreeParser.g:135:7: ^( ARELEM IDENT a= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem_assign483); 
			match(input, Token.DOWN, null); 
			IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem_assign486); 
			pushFollow(FOLLOW_expression_in_array_elem_assign490);
			a=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			        Operand3a variable = symTab.lookup((IDENT6!=null?IDENT6.getText():null));
			        code = Code3aGenerator.assignVarTab(variable, a, valueToAssign);
			      
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "array_elem_assign"



	// $ANTLR start "array_elem_value"
	// VSLTreeParser.g:142:1: array_elem_value[SymbolTable symTab] returns [ExpAttribute expAtt] : ^( ARELEM IDENT a= expression[symTab] ) ;
	public final ExpAttribute array_elem_value(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree IDENT7=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:143:5: ( ^( ARELEM IDENT a= expression[symTab] ) )
			// VSLTreeParser.g:143:7: ^( ARELEM IDENT a= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem_value524); 
			match(input, Token.DOWN, null); 
			IDENT7=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem_value527); 
			pushFollow(FOLLOW_expression_in_array_elem_value531);
			a=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			        VarSymbol temp = SymbDistrib.newTemp();
			        Operand3a variable = symTab.lookup((IDENT7!=null?IDENT7.getText():null));

			        Code3a code = new Code3a(new Inst3a(Inst3a.TAC.TABVAR, temp, variable, a.place));
			        expAtt = new ExpAttribute(variable.type, code, temp);
			      
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "array_elem_value"



	// $ANTLR start "expression"
	// VSLTreeParser.g:153:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e1= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:154:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e1= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt10=6;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt10=1;
				}
				break;
			case MINUS:
				{
				alt10=2;
				}
				break;
			case MUL:
				{
				alt10=3;
				}
				break;
			case DIV:
				{
				alt10=4;
				}
				break;
			case NEGAT:
				{
				alt10=5;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
				{
				alt10=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// VSLTreeParser.g:154:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression563); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression567);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression572);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:161:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression587); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression591);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression596);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:168:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression611); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression615);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression620);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 4 :
					// VSLTreeParser.g:175:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression635); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression639);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression644);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 5 :
					// VSLTreeParser.g:182:5: ^( NEGAT e1= expression[symTab] )
					{
					match(input,NEGAT,FOLLOW_NEGAT_in_expression659); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression663);
					e1=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					  		Type ty = e1.type;
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genUnOp(Inst3a.TAC.NEG, temp, e1);
					      expAtt = new ExpAttribute(ty, cod, temp);
					  	
					}
					break;
				case 6 :
					// VSLTreeParser.g:189:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression678);
					pe=primary_exp(symTab);
					state._fsp--;

					 expAtt = pe; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary_exp"
	// VSLTreeParser.g:193:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT |a= array_elem_value[symTab] );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER8=null;
		CommonTree IDENT9=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:194:3: ( INTEGER | IDENT |a= array_elem_value[symTab] )
			int alt11=3;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt11=1;
				}
				break;
			case IDENT:
				{
				alt11=2;
				}
				break;
			case ARELEM:
				{
				alt11=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// VSLTreeParser.g:194:5: INTEGER
					{
					INTEGER8=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp704); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER8!=null?INTEGER8.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:199:5: IDENT
					{
					IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp716); 

					      Operand3a id = symTab.lookup((IDENT9!=null?IDENT9.getText():null));
					      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT9!=null?IDENT9.getText():null)));
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:204:5: a= array_elem_value[symTab]
					{
					pushFollow(FOLLOW_array_elem_value_in_primary_exp730);
					a=array_elem_value(symTab);
					state._fsp--;


					      expAtt = a;
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "primary_exp"

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_s63 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item104 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item106 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item108 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_declaration141 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration146 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_INST_in_inst_list176 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list181 = new BitSet(new long[]{0x0000021004008028L});
	public static final BitSet FOLLOW_BLOCK_in_block219 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block223 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block228 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block247 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block251 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement283 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement287 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement292 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_assign_in_statement300 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement328 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_item_in_statement333 = new BitSet(new long[]{0x0000808202C14208L});
	public static final BitSet FOLLOW_IF_KW_in_statement350 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement354 = new BitSet(new long[]{0x0000021004008020L});
	public static final BitSet FOLLOW_statement_in_statement360 = new BitSet(new long[]{0x0000021004008028L});
	public static final BitSet FOLLOW_statement_in_statement370 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement389 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement393 = new BitSet(new long[]{0x0000021004008020L});
	public static final BitSet FOLLOW_statement_in_statement398 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TEXT_in_print_item426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem_assign483 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem_assign486 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem_assign490 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem_value524 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem_value527 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem_value531 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression563 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression567 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_expression572 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression587 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression591 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_expression596 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression611 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression615 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_expression620 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression635 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression639 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_expression644 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGAT_in_expression659 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression663 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp704 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_value_in_primary_exp730 = new BitSet(new long[]{0x0000000000000002L});
}
