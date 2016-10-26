// $ANTLR 3.5.2 VSLTreeParser.g 2016-10-26 13:25:43

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
	// VSLTreeParser.g:9:1: s[SymbolTable symTab] returns [Code3a code] : e= statement[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a e =null;

		try {
			// VSLTreeParser.g:10:3: (e= statement[symTab] )
			// VSLTreeParser.g:10:5: e= statement[symTab]
			{
			pushFollow(FOLLOW_statement_in_s60);
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
	// VSLTreeParser.g:13:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT1=null;
		CommonTree INTEGER2=null;
		CommonTree IDENT3=null;

		try {
			// VSLTreeParser.g:14:5: ( IDENT | ^( ARDECL IDENT INTEGER ) )
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
					// VSLTreeParser.g:14:7: IDENT
					{
					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item84); 

					        Operand3a var = new VarSymbol(Type.INT, (IDENT1!=null?IDENT1.getText():null), symTab.getScope());
					        symTab.insert((IDENT1!=null?IDENT1.getText():null), var);
					        VarSymbol temp = SymbDistrib.newTemp();
					        code = Code3aGenerator.genVar(var);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:21:7: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item101); 
					match(input, Token.DOWN, null); 
					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item103); 
					INTEGER2=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item105); 
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
	// VSLTreeParser.g:30:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (a= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;

		try {
			// VSLTreeParser.g:31:5: ( ^( DECL (a= decl_item[symTab] )+ ) )
			// VSLTreeParser.g:31:7: ^( DECL (a= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration138); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:31:14: (a= decl_item[symTab] )+
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
					// VSLTreeParser.g:31:15: a= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration143);
					a=decl_item(symTab);
					state._fsp--;


					        if(code == null)
					          code = a;
					        else
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
	// VSLTreeParser.g:39:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (a= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;

		try {
			// VSLTreeParser.g:40:5: ( ^( INST (a= statement[symTab] )+ ) )
			// VSLTreeParser.g:40:7: ^( INST (a= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list173); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:40:15: (a= statement[symTab] )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ASSIGN_KW||LA3_0==BLOCK) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// VSLTreeParser.g:40:15: a= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list177);
					a=statement(symTab);
					state._fsp--;

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


			        if(code == null)
			          code = a;
			        else
			          code.append(a);
			      
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
	// VSLTreeParser.g:49:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK a= declaration[symTab] b= inst_list[symTab] ) | ^( BLOCK c= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;
		Code3a b =null;
		Code3a c =null;

		try {
			// VSLTreeParser.g:50:5: ( ^( BLOCK a= declaration[symTab] b= inst_list[symTab] ) | ^( BLOCK c= inst_list[symTab] ) )
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
					// VSLTreeParser.g:50:7: ^( BLOCK a= declaration[symTab] b= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block212); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block216);
					a=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block221);
					b=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = a;
					        code.append(b);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:55:7: ^( BLOCK c= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block240); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block244);
					c=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = c;
					      
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
	// $ANTLR end "block"



	// $ANTLR start "statement"
	// VSLTreeParser.g:61:1: statement[SymbolTable symTab] returns [Code3a code] : ( ^( ASSIGN_KW a= expression[symTab] IDENT ) |b= block[symTab] );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT4=null;
		ExpAttribute a =null;
		Code3a b =null;

		try {
			// VSLTreeParser.g:62:3: ( ^( ASSIGN_KW a= expression[symTab] IDENT ) |b= block[symTab] )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ASSIGN_KW) ) {
				alt5=1;
			}
			else if ( (LA5_0==BLOCK) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// VSLTreeParser.g:62:5: ^( ASSIGN_KW a= expression[symTab] IDENT )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement276); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement280);
					a=expression(symTab);
					state._fsp--;

					IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement283); 
					match(input, Token.UP, null); 


					      Operand3a var2 = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
					      code = Code3aGenerator.assignVar(var2, a);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:67:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement298);
					b=block(symTab);
					state._fsp--;


					      if(code == null)
					        code = b;
					      else
					        code.append(b);
					    
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



	// $ANTLR start "expression"
	// VSLTreeParser.g:84:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e1= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:85:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e1= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt6=6;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt6=1;
				}
				break;
			case MINUS:
				{
				alt6=2;
				}
				break;
			case MUL:
				{
				alt6=3;
				}
				break;
			case DIV:
				{
				alt6=4;
				}
				break;
			case NEGAT:
				{
				alt6=5;
				}
				break;
			case IDENT:
			case INTEGER:
				{
				alt6=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// VSLTreeParser.g:85:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression329); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression333);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression338);
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
					// VSLTreeParser.g:92:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression353); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression357);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression362);
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
					// VSLTreeParser.g:99:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression377); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression381);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression386);
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
					// VSLTreeParser.g:106:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression401); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression405);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression410);
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
					// VSLTreeParser.g:113:5: ^( NEGAT e1= expression[symTab] )
					{
					match(input,NEGAT,FOLLOW_NEGAT_in_expression425); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression429);
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
					// VSLTreeParser.g:120:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression444);
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
	// VSLTreeParser.g:124:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER5=null;
		CommonTree IDENT6=null;

		try {
			// VSLTreeParser.g:125:3: ( INTEGER | IDENT )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==INTEGER) ) {
				alt7=1;
			}
			else if ( (LA7_0==IDENT) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// VSLTreeParser.g:125:5: INTEGER
					{
					INTEGER5=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp470); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER5!=null?INTEGER5.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:130:5: IDENT
					{
					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp482); 

					      Operand3a id = symTab.lookup((IDENT6!=null?IDENT6.getText():null));
					      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT6!=null?IDENT6.getText():null)));
					    
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



	public static final BitSet FOLLOW_statement_in_s60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item101 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item103 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item105 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_declaration138 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration143 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_INST_in_inst_list173 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list177 = new BitSet(new long[]{0x0000020000000028L});
	public static final BitSet FOLLOW_BLOCK_in_block212 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block216 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block221 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block240 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block244 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement276 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement280 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement283 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression329 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression333 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression338 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression353 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression357 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression362 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression377 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression381 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression386 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression401 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression405 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression410 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGAT_in_expression425 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression429 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp482 = new BitSet(new long[]{0x0000000000000002L});
}
