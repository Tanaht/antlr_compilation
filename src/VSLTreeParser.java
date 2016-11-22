// $ANTLR 3.5.2 VSLTreeParser.g 2016-11-22 09:56:51

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

		 code = new Code3a(); 
		try {
			// VSLTreeParser.g:38:5: ( ^( DECL (a= decl_item[symTab] )+ ) )
			// VSLTreeParser.g:38:7: ^( DECL (a= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration145); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:38:14: (a= decl_item[symTab] )+
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
					// VSLTreeParser.g:38:15: a= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration150);
					a=decl_item(symTab);
					state._fsp--;


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
	// VSLTreeParser.g:43:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (a= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;

		 code = new Code3a(); 
		try {
			// VSLTreeParser.g:45:5: ( ^( INST (a= statement[symTab] )+ ) )
			// VSLTreeParser.g:45:7: ^( INST (a= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list184); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:45:14: (a= statement[symTab] )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ASSIGN_KW||LA3_0==IF_KW||LA3_0==PRINT_KW||LA3_0==READ_KW||LA3_0==WHILE_KW||LA3_0==BLOCK) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// VSLTreeParser.g:45:15: a= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list189);
					a=statement(symTab);
					state._fsp--;


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
	// VSLTreeParser.g:50:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK a= declaration[symTab] b= inst_list[symTab] ) | ^( BLOCK c= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;
		Code3a b =null;
		Code3a c =null;

		 symTab.enterScope(); 
		try {
			// VSLTreeParser.g:53:5: ( ^( BLOCK a= declaration[symTab] b= inst_list[symTab] ) | ^( BLOCK c= inst_list[symTab] ) )
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
					// VSLTreeParser.g:53:7: ^( BLOCK a= declaration[symTab] b= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block227); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block231);
					a=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block236);
					b=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = a;
					        code.append(b);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:58:7: ^( BLOCK c= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block255); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block259);
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
	// VSLTreeParser.g:64:1: statement[SymbolTable symTab] returns [Code3a code] : ( ^( ASSIGN_KW a= expression[symTab] ( IDENT |c= array_elem_assign[symTab, $a.expAtt] ) ) |b= block[symTab] | ^( PRINT_KW (z= print_item[symTab] )+ ) | ^( READ_KW (j= read_item[symTab] )+ ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT4=null;
		ExpAttribute a =null;
		Code3a c =null;
		Code3a b =null;
		Code3a z =null;
		Code3a j =null;
		ExpAttribute e =null;
		Code3a s1 =null;
		Code3a s2 =null;

		 code = new Code3a(); 
		try {
			// VSLTreeParser.g:66:3: ( ^( ASSIGN_KW a= expression[symTab] ( IDENT |c= array_elem_assign[symTab, $a.expAtt] ) ) |b= block[symTab] | ^( PRINT_KW (z= print_item[symTab] )+ ) | ^( READ_KW (j= read_item[symTab] )+ ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) )
			int alt9=6;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt9=1;
				}
				break;
			case BLOCK:
				{
				alt9=2;
				}
				break;
			case PRINT_KW:
				{
				alt9=3;
				}
				break;
			case READ_KW:
				{
				alt9=4;
				}
				break;
			case IF_KW:
				{
				alt9=5;
				}
				break;
			case WHILE_KW:
				{
				alt9=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// VSLTreeParser.g:66:5: ^( ASSIGN_KW a= expression[symTab] ( IDENT |c= array_elem_assign[symTab, $a.expAtt] ) )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement295); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement299);
					a=expression(symTab);
					state._fsp--;

					// VSLTreeParser.g:66:38: ( IDENT |c= array_elem_assign[symTab, $a.expAtt] )
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
							// VSLTreeParser.g:66:40: IDENT
							{
							IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement304); 

							      //Assign Var
							      Operand3a variable = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
							      code = Code3aGenerator.assignVar(variable, a);
							    
							}
							break;
						case 2 :
							// VSLTreeParser.g:70:9: c= array_elem_assign[symTab, $a.expAtt]
							{
							pushFollow(FOLLOW_array_elem_assign_in_statement312);
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
					// VSLTreeParser.g:74:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement325);
					b=block(symTab);
					state._fsp--;


					      code.append(b);
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:78:6: ^( PRINT_KW (z= print_item[symTab] )+ )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement340); 
					match(input, Token.DOWN, null); 
					// VSLTreeParser.g:78:17: (z= print_item[symTab] )+
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
							// VSLTreeParser.g:78:18: z= print_item[symTab]
							{
							pushFollow(FOLLOW_print_item_in_statement345);
							z=print_item(symTab);
							state._fsp--;


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
					// VSLTreeParser.g:82:5: ^( READ_KW (j= read_item[symTab] )+ )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement362); 
					match(input, Token.DOWN, null); 
					// VSLTreeParser.g:82:15: (j= read_item[symTab] )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==IDENT||LA7_0==ARELEM) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// VSLTreeParser.g:82:16: j= read_item[symTab]
							{
							pushFollow(FOLLOW_read_item_in_statement367);
							j=read_item(symTab);
							state._fsp--;


							      code.append(j);
							    
							}
							break;

						default :
							if ( cnt7 >= 1 ) break loop7;
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// VSLTreeParser.g:86:5: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement384); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement388);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement394);
					s1=statement(symTab);
					state._fsp--;


					      LabelSymbol fin = SymbDistrib.newLabel();
					  		code = Code3aGenerator.genIf(e, s1, fin);

					  	
					// VSLTreeParser.g:92:4: (s2= statement[symTab] )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==ASSIGN_KW||LA8_0==IF_KW||LA8_0==PRINT_KW||LA8_0==READ_KW||LA8_0==WHILE_KW||LA8_0==BLOCK) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// VSLTreeParser.g:92:5: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement408);
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
				case 6 :
					// VSLTreeParser.g:101:5: ^( WHILE_KW e= expression[symTab] s1= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement431); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement435);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement440);
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
	// VSLTreeParser.g:108:3: print_item[SymbolTable symTab] returns [Code3a code] : ( TEXT |a= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree TEXT5=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:109:5: ( TEXT |a= expression[symTab] )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==TEXT) ) {
				alt10=1;
			}
			else if ( (LA10_0==DIV||LA10_0==IDENT||LA10_0==INTEGER||(LA10_0 >= MINUS && LA10_0 <= MUL)||LA10_0==PLUS||LA10_0==ARELEM||LA10_0==NEGAT) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// VSLTreeParser.g:109:7: TEXT
					{
					TEXT5=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item470); 


					        Data3a data = new Data3a((TEXT5!=null?TEXT5.getText():null));

					        code = Code3aGenerator.callPrintS(data);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:116:7: a= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item488);
					a=expression(symTab);
					state._fsp--;


					        code = a.code;
					        code.append(Code3aGenerator.callPrintN(a.place));
					      
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



	// $ANTLR start "read_item"
	// VSLTreeParser.g:123:3: read_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARELEM IDENT a= expression[symTab] ) );
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT6=null;
		CommonTree IDENT7=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:124:5: ( IDENT | ^( ARELEM IDENT a= expression[symTab] ) )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==IDENT) ) {
				alt11=1;
			}
			else if ( (LA11_0==ARELEM) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// VSLTreeParser.g:124:6: IDENT
					{
					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item521); 

					        Operand3a variable = symTab.lookup((IDENT6!=null?IDENT6.getText():null));
					        code = Code3aGenerator.callRead(variable);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:129:7: ^( ARELEM IDENT a= expression[symTab] )
					{
					match(input,ARELEM,FOLLOW_ARELEM_in_read_item538); 
					match(input, Token.DOWN, null); 
					IDENT7=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item541); 
					pushFollow(FOLLOW_expression_in_read_item545);
					a=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        VarSymbol temp = SymbDistrib.newTemp();
					        code = Code3aGenerator.genVar(temp);
					        code.append(Code3aGenerator.callRead(temp));

					        Operand3a tab = symTab.lookup((IDENT7!=null?IDENT7.getText():null));

					        if(tab == null)
					          Errors.unknownIdentifier(IDENT7, (IDENT7!=null?IDENT7.getText():null), null);

					        code.append(a.code);
					        code.append(new Inst3a(Inst3a.TAC.VARTAB, tab, a.place, temp));
					      
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
	// $ANTLR end "read_item"



	// $ANTLR start "array_elem_assign"
	// VSLTreeParser.g:153:1: array_elem_assign[SymbolTable symTab, ExpAttribute valueToAssign] returns [Code3a code] : ^( ARELEM IDENT a= expression[symTab] ) ;
	public final Code3a array_elem_assign(SymbolTable symTab, ExpAttribute valueToAssign) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT8=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:154:5: ( ^( ARELEM IDENT a= expression[symTab] ) )
			// VSLTreeParser.g:154:7: ^( ARELEM IDENT a= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem_assign584); 
			match(input, Token.DOWN, null); 
			IDENT8=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem_assign587); 
			pushFollow(FOLLOW_expression_in_array_elem_assign591);
			a=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			        Operand3a variable = symTab.lookup((IDENT8!=null?IDENT8.getText():null));

			        if(variable == null)
			          Errors.unknownIdentifier(IDENT8, (IDENT8!=null?IDENT8.getText():null), null);

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
	// VSLTreeParser.g:165:1: array_elem_value[SymbolTable symTab] returns [ExpAttribute expAtt] : ^( ARELEM IDENT a= expression[symTab] ) ;
	public final ExpAttribute array_elem_value(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree IDENT9=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:166:5: ( ^( ARELEM IDENT a= expression[symTab] ) )
			// VSLTreeParser.g:166:7: ^( ARELEM IDENT a= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem_value625); 
			match(input, Token.DOWN, null); 
			IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem_value628); 
			pushFollow(FOLLOW_expression_in_array_elem_value632);
			a=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			        VarSymbol temp = SymbDistrib.newTemp();
			        Operand3a variable = symTab.lookup((IDENT9!=null?IDENT9.getText():null));

			        if(variable == null)
			          Errors.unknownIdentifier(IDENT9, (IDENT9!=null?IDENT9.getText():null), null);

			        Code3a code = Code3aGenerator.genVar(temp);
			        code.append(new Inst3a(Inst3a.TAC.TABVAR, temp, variable, a.place));
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
	// VSLTreeParser.g:180:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e1= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:181:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e1= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt12=6;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt12=1;
				}
				break;
			case MINUS:
				{
				alt12=2;
				}
				break;
			case MUL:
				{
				alt12=3;
				}
				break;
			case DIV:
				{
				alt12=4;
				}
				break;
			case NEGAT:
				{
				alt12=5;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
				{
				alt12=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// VSLTreeParser.g:181:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression664); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression668);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression673);
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
					// VSLTreeParser.g:188:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression688); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression692);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression697);
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
					// VSLTreeParser.g:195:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression712); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression716);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression721);
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
					// VSLTreeParser.g:202:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression736); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression740);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression745);
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
					// VSLTreeParser.g:209:5: ^( NEGAT e1= expression[symTab] )
					{
					match(input,NEGAT,FOLLOW_NEGAT_in_expression760); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression764);
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
					// VSLTreeParser.g:216:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression779);
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
	// VSLTreeParser.g:220:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT |a= array_elem_value[symTab] );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER10=null;
		CommonTree IDENT11=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:221:3: ( INTEGER | IDENT |a= array_elem_value[symTab] )
			int alt13=3;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt13=1;
				}
				break;
			case IDENT:
				{
				alt13=2;
				}
				break;
			case ARELEM:
				{
				alt13=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// VSLTreeParser.g:221:5: INTEGER
					{
					INTEGER10=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp805); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER10!=null?INTEGER10.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:226:5: IDENT
					{
					IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp817); 

					      Operand3a id = symTab.lookup((IDENT11!=null?IDENT11.getText():null));

					      if(id == null)
					        Errors.unknownIdentifier(IDENT11, (IDENT11!=null?IDENT11.getText():null), null);

					      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT11!=null?IDENT11.getText():null)));
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:235:5: a= array_elem_value[symTab]
					{
					pushFollow(FOLLOW_array_elem_value_in_primary_exp831);
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
	public static final BitSet FOLLOW_DECL_in_declaration145 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration150 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_INST_in_inst_list184 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list189 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_BLOCK_in_block227 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block231 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block236 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block255 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block259 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement295 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement299 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement304 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_assign_in_statement312 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement340 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_item_in_statement345 = new BitSet(new long[]{0x0000808202C14208L});
	public static final BitSet FOLLOW_READ_KW_in_statement362 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_item_in_statement367 = new BitSet(new long[]{0x0000008000004008L});
	public static final BitSet FOLLOW_IF_KW_in_statement384 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement388 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement394 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_statement_in_statement408 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement431 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement435 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement440 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TEXT_in_print_item470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_read_item521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARELEM_in_read_item538 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_read_item541 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_read_item545 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem_assign584 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem_assign587 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem_assign591 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem_value625 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem_value628 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem_value632 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression664 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression668 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_expression673 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression688 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression692 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_expression697 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression712 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression716 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_expression721 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression736 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression740 = new BitSet(new long[]{0x0000808002C14200L});
	public static final BitSet FOLLOW_expression_in_expression745 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGAT_in_expression760 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression764 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression779 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp805 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_value_in_primary_exp831 = new BitSet(new long[]{0x0000000000000002L});
}
