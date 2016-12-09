// $ANTLR 3.5.2 VSLTreeParser.g 2016-12-09 15:02:47

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
	// VSLTreeParser.g:15:1: s[SymbolTable symTab] returns [Code3a code] : p= program[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a p =null;

		try {
			// VSLTreeParser.g:16:3: (p= program[symTab] )
			// VSLTreeParser.g:16:5: p= program[symTab]
			{
			pushFollow(FOLLOW_program_in_s63);
			p=program(symTab);
			state._fsp--;

			code = p;
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



	// $ANTLR start "program"
	// VSLTreeParser.g:20:1: program[SymbolTable symTab] returns [Code3a code] : ^( PROG (u= unit[symTab] )+ ) ;
	public final Code3a program(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a u =null;

		 code = new Code3a(); 
		try {
			// VSLTreeParser.g:22:5: ( ^( PROG (u= unit[symTab] )+ ) )
			// VSLTreeParser.g:22:7: ^( PROG (u= unit[symTab] )+ )
			{
			match(input,PROG,FOLLOW_PROG_in_program92); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:22:14: (u= unit[symTab] )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FUNC_KW||LA1_0==PROTO_KW) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// VSLTreeParser.g:22:15: u= unit[symTab]
					{
					pushFollow(FOLLOW_unit_in_program97);
					u=unit(symTab);
					state._fsp--;

					code.append(u); 
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
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
	// $ANTLR end "program"



	// $ANTLR start "unit"
	// VSLTreeParser.g:26:1: unit[SymbolTable symTab] returns [Code3a code] : (f= function[symTab] |p= proto[symTab] );
	public final Code3a unit(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a f =null;
		Code3a p =null;

		 code = new Code3a(); 
		try {
			// VSLTreeParser.g:28:5: (f= function[symTab] |p= proto[symTab] )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==FUNC_KW) ) {
				alt2=1;
			}
			else if ( (LA2_0==PROTO_KW) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// VSLTreeParser.g:28:7: f= function[symTab]
					{
					pushFollow(FOLLOW_function_in_unit134);
					f=function(symTab);
					state._fsp--;

					code = f; 
					}
					break;
				case 2 :
					// VSLTreeParser.g:29:7: p= proto[symTab]
					{
					pushFollow(FOLLOW_proto_in_unit147);
					p=proto(symTab);
					state._fsp--;

					code = p; 
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
	// $ANTLR end "unit"



	// $ANTLR start "function"
	// VSLTreeParser.g:32:1: function[SymbolTable symTab] returns [Code3a code] : ^( FUNC_KW t= type IDENT ^( PARAM (pa= param )* ) ^( BODY s1= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT1=null;
		CommonTree FUNC_KW2=null;
		Type t =null;
		TreeRuleReturnScope pa =null;
		Code3a s1 =null;


		  code = new Code3a();
		  ArrayList<Type> paramsType = new ArrayList<Type>();
		  ArrayList<String> paramsNom = new ArrayList<String>();

		try {
			// VSLTreeParser.g:39:5: ( ^( FUNC_KW t= type IDENT ^( PARAM (pa= param )* ) ^( BODY s1= statement[symTab] ) ) )
			// VSLTreeParser.g:39:7: ^( FUNC_KW t= type IDENT ^( PARAM (pa= param )* ) ^( BODY s1= statement[symTab] ) )
			{
			FUNC_KW2=(CommonTree)match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function181); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function185);
			t=type();
			state._fsp--;

			IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function187); 
			match(input,PARAM,FOLLOW_PARAM_in_function190); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// VSLTreeParser.g:39:38: (pa= param )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==IDENT||LA3_0==ARRAY) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// VSLTreeParser.g:39:39: pa= param
						{
						pushFollow(FOLLOW_param_in_function195);
						pa=param();
						state._fsp--;

						 paramsType.add((pa!=null?((VSLTreeParser.param_return)pa).type:null)); paramsNom.add((pa!=null?((VSLTreeParser.param_return)pa).nom:null)); 
						}
						break;

					default :
						break loop3;
					}
				}

				match(input, Token.UP, null); 
			}



			      LabelSymbol deb = new LabelSymbol((IDENT1!=null?IDENT1.getText():null));
			      Operand3a storedFunction = symTab.lookup((IDENT1!=null?IDENT1.getText():null));
			      FunctionSymbol f = null;

			      //Si Fonction auparavant défini comme prototype
			      if(storedFunction != null && storedFunction instanceof FunctionSymbol) {
			        f = (FunctionSymbol) storedFunction;
			        List<Type> argList = ((FunctionType) f.type).getArguments();

			        if(((FunctionType) f.type).prototype == false)
			           Errors.redefinedIdentifier(IDENT1, (IDENT1!=null?IDENT1.getText():null),"");


					if(((FunctionType) f.type).getReturnType() != t)
						Errors.incompatibleTypes(FUNC_KW2, ((FunctionType) f.type).getReturnType(), t, "Le type de retour du prototype est différent de celui de la fonction");
						
			        if(argList.size() != paramsType.size())
			          Errors.miscError(FUNC_KW2, "Definition differente du prototype [Nombre arguments ou type de retour différents]");

			        for(int i=0; i < argList.size(); i++) {
			          if(argList.get(i) != paramsType.get(i))
			            Errors.incompatibleTypes(FUNC_KW2, argList.get(i), paramsType.get(i), "Pour le " + i + " arguments de la fonction "+(IDENT1!=null?IDENT1.getText():null));
			        }


			        ((FunctionType) f.type).prototype = false;
			      }
			      else {//Si aucun prototype
			        FunctionType ft = new FunctionType(t, false);
			        for(Type type : paramsType) {
			          ft.extend(type);
			        }
			        f = new FunctionSymbol(deb, ft);
			        symTab.insert((IDENT1!=null?IDENT1.getText():null), f);
			      }
			      code.append(new Inst3a(Inst3a.TAC.LABEL, deb, null, null));
			      code.append(new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null));
			      //déclaration des variables
			      symTab.enterScope();
			      for(int i=0; i < paramsType.size(); i++) {
			        VarSymbol var = new VarSymbol(paramsType.get(i), paramsNom.get(i), symTab.getScope());
			        var.setParam();
			        symTab.insert(paramsNom.get(i), var);
			        code.append(Code3aGenerator.genVar(var));
			      }

			      
			match(input,BODY,FOLLOW_BODY_in_function207); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function211);
			s1=statement(symTab);
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 


					code.append(s1);
					code.append(new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null));
				
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
	// $ANTLR end "function"


	public static class param_return extends TreeRuleReturnScope {
		public Type type;
		public String nom;
	};


	// $ANTLR start "param"
	// VSLTreeParser.g:94:1: param returns [Type type, String nom] : ( IDENT | ^( ARRAY IDENT ) );
	public final VSLTreeParser.param_return param() throws RecognitionException {
		VSLTreeParser.param_return retval = new VSLTreeParser.param_return();
		retval.start = input.LT(1);

		CommonTree IDENT3=null;
		CommonTree IDENT4=null;

		try {
			// VSLTreeParser.g:95:5: ( IDENT | ^( ARRAY IDENT ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==IDENT) ) {
				alt4=1;
			}
			else if ( (LA4_0==ARRAY) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// VSLTreeParser.g:95:7: IDENT
					{
					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param238); 
					retval.type = Type.INT; retval.nom = (IDENT3!=null?IDENT3.getText():null); 
					}
					break;
				case 2 :
					// VSLTreeParser.g:96:7: ^( ARRAY IDENT )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_param249); 
					match(input, Token.DOWN, null); 
					IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param251); 
					match(input, Token.UP, null); 

					retval.type = Type.POINTER; retval.nom = (IDENT4!=null?IDENT4.getText():null); 
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
		return retval;
	}
	// $ANTLR end "param"



	// $ANTLR start "proto"
	// VSLTreeParser.g:100:1: proto[SymbolTable symTab] returns [Code3a code] : ^( PROTO_KW t= type IDENT ^( PARAM (pa= param )* ) ) ;
	public final Code3a proto(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT5=null;
		Type t =null;
		TreeRuleReturnScope pa =null;

		 code = new Code3a(); ArrayList<Type> paramsType = new ArrayList<Type>(); 
		try {
			// VSLTreeParser.g:102:5: ( ^( PROTO_KW t= type IDENT ^( PARAM (pa= param )* ) ) )
			// VSLTreeParser.g:102:7: ^( PROTO_KW t= type IDENT ^( PARAM (pa= param )* ) )
			{
			match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto282); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto286);
			t=type();
			state._fsp--;

			IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto288); 
			match(input,PARAM,FOLLOW_PARAM_in_proto291); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// VSLTreeParser.g:102:39: (pa= param )*
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==IDENT||LA5_0==ARRAY) ) {
						alt5=1;
					}

					switch (alt5) {
					case 1 :
						// VSLTreeParser.g:102:40: pa= param
						{
						pushFollow(FOLLOW_param_in_proto296);
						pa=param();
						state._fsp--;

						 paramsType.add((pa!=null?((VSLTreeParser.param_return)pa).type:null)); 
						}
						break;

					default :
						break loop5;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input, Token.UP, null); 


			    Operand3a v = symTab.lookup((IDENT5!=null?IDENT5.getText():null));
					if(v!= null && v.getScope() == symTab.getScope()){
						Errors.redefinedIdentifier(IDENT5, (IDENT5!=null?IDENT5.getText():null),"");
					}
					LabelSymbol deb = new LabelSymbol((IDENT5!=null?IDENT5.getText():null));
					FunctionType ft = new FunctionType(t, true);
					for(Type type : paramsType) {
						ft.extend(type);
					}

					FunctionSymbol f = new FunctionSymbol(deb, ft);
					symTab.insert((IDENT5!=null?IDENT5.getText():null), f);
				
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
	// $ANTLR end "proto"



	// $ANTLR start "type"
	// VSLTreeParser.g:119:1: type returns [Type type] : ( INT_KW | VOID_KW );
	public final Type type() throws RecognitionException {
		Type type = null;


		try {
			// VSLTreeParser.g:120:5: ( INT_KW | VOID_KW )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==INT_KW) ) {
				alt6=1;
			}
			else if ( (LA6_0==VOID_KW) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// VSLTreeParser.g:120:7: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type326); 
					type = Type.INT;
					}
					break;
				case 2 :
					// VSLTreeParser.g:121:7: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type336); 
					type = Type.VOID;
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
		return type;
	}
	// $ANTLR end "type"



	// $ANTLR start "decl_item"
	// VSLTreeParser.g:124:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT6=null;
		CommonTree IDENT7=null;
		CommonTree INTEGER8=null;

		try {
			// VSLTreeParser.g:125:5: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==IDENT) ) {
				alt7=1;
			}
			else if ( (LA7_0==ARDECL) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// VSLTreeParser.g:125:7: IDENT
					{
					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item361); 

					        Operand3a v = symTab.lookup((IDENT6!=null?IDENT6.getText():null));
					    		if(v!= null && v.getScope() == symTab.getScope()){
								       Errors.redefinedIdentifier(IDENT6, (IDENT6!=null?IDENT6.getText():null),"");
							}
					        Operand3a var = new VarSymbol(Type.INT, (IDENT6!=null?IDENT6.getText():null), symTab.getScope());
					        symTab.insert((IDENT6!=null?IDENT6.getText():null), var);
					        code = Code3aGenerator.genVar(var);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:135:7: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item378); 
					match(input, Token.DOWN, null); 
					IDENT7=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item380); 
					INTEGER8=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item382); 
					match(input, Token.UP, null); 


					        Operand3a v = symTab.lookup((IDENT7!=null?IDENT7.getText():null));
					    		if(v!= null && v.getScope() == symTab.getScope()){
								       Errors.redefinedIdentifier(IDENT7, (IDENT7!=null?IDENT7.getText():null),"");
							}
					        Operand3a var = new VarSymbol(new ArrayType(Type.INT, Integer.parseInt((INTEGER8!=null?INTEGER8.getText():null))), (IDENT7!=null?IDENT7.getText():null), symTab.getScope());
					        symTab.insert((IDENT7!=null?IDENT7.getText():null), var);
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
	// VSLTreeParser.g:147:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (a= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;

		 code = new Code3a(); 
		try {
			// VSLTreeParser.g:149:5: ( ^( DECL (a= decl_item[symTab] )+ ) )
			// VSLTreeParser.g:149:7: ^( DECL (a= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration419); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:149:14: (a= decl_item[symTab] )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==IDENT||LA8_0==ARDECL) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// VSLTreeParser.g:149:15: a= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration424);
					a=decl_item(symTab);
					state._fsp--;


					        code.append(a);
					      
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
	// VSLTreeParser.g:154:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (a= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;

		 code = new Code3a(); 
		try {
			// VSLTreeParser.g:156:5: ( ^( INST (a= statement[symTab] )+ ) )
			// VSLTreeParser.g:156:7: ^( INST (a= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list458); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:156:14: (a= statement[symTab] )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==ASSIGN_KW||LA9_0==IF_KW||LA9_0==PRINT_KW||(LA9_0 >= READ_KW && LA9_0 <= RETURN_KW)||LA9_0==WHILE_KW||LA9_0==BLOCK||LA9_0==FCALL_S) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// VSLTreeParser.g:156:15: a= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list463);
					a=statement(symTab);
					state._fsp--;


					        code.append(a);
					      
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
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
	// VSLTreeParser.g:161:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK a= declaration[symTab] b= inst_list[symTab] ) | ^( BLOCK c= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a a =null;
		Code3a b =null;
		Code3a c =null;

		 symTab.enterScope(); 
		try {
			// VSLTreeParser.g:164:5: ( ^( BLOCK a= declaration[symTab] b= inst_list[symTab] ) | ^( BLOCK c= inst_list[symTab] ) )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==BLOCK) ) {
				int LA10_1 = input.LA(2);
				if ( (LA10_1==DOWN) ) {
					int LA10_2 = input.LA(3);
					if ( (LA10_2==DECL) ) {
						alt10=1;
					}
					else if ( (LA10_2==INST) ) {
						alt10=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 10, 2, input);
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
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// VSLTreeParser.g:164:7: ^( BLOCK a= declaration[symTab] b= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block501); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block505);
					a=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block510);
					b=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = a;
					        code.append(b);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:169:7: ^( BLOCK c= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block529); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block533);
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
	// VSLTreeParser.g:175:1: statement[SymbolTable symTab] returns [Code3a code] : ( ^( ASSIGN_KW a= expression[symTab] ( IDENT |c= array_elem_assign[symTab, $a.expAtt] ) ) |b= block[symTab] | ^( PRINT_KW (z= print_item[symTab] )+ ) | ^( READ_KW (j= read_item[symTab] )+ ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) | ^( FCALL_S IDENT (arg= argument_item[symTab] )* ) | ^( RETURN_KW exp= expression[symTab] ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT9=null;
		CommonTree ASSIGN_KW10=null;
		CommonTree IDENT11=null;
		CommonTree FCALL_S12=null;
		CommonTree RETURN_KW13=null;
		ExpAttribute a =null;
		Code3a c =null;
		Code3a b =null;
		Code3a z =null;
		Code3a j =null;
		ExpAttribute e =null;
		Code3a s1 =null;
		Code3a s2 =null;
		ExpAttribute arg =null;
		ExpAttribute exp =null;

		 code = new Code3a(); 
		try {
			// VSLTreeParser.g:177:3: ( ^( ASSIGN_KW a= expression[symTab] ( IDENT |c= array_elem_assign[symTab, $a.expAtt] ) ) |b= block[symTab] | ^( PRINT_KW (z= print_item[symTab] )+ ) | ^( READ_KW (j= read_item[symTab] )+ ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) | ^( FCALL_S IDENT (arg= argument_item[symTab] )* ) | ^( RETURN_KW exp= expression[symTab] ) )
			int alt16=8;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt16=1;
				}
				break;
			case BLOCK:
				{
				alt16=2;
				}
				break;
			case PRINT_KW:
				{
				alt16=3;
				}
				break;
			case READ_KW:
				{
				alt16=4;
				}
				break;
			case IF_KW:
				{
				alt16=5;
				}
				break;
			case WHILE_KW:
				{
				alt16=6;
				}
				break;
			case FCALL_S:
				{
				alt16=7;
				}
				break;
			case RETURN_KW:
				{
				alt16=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// VSLTreeParser.g:177:5: ^( ASSIGN_KW a= expression[symTab] ( IDENT |c= array_elem_assign[symTab, $a.expAtt] ) )
					{
					ASSIGN_KW10=(CommonTree)match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement569); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement573);
					a=expression(symTab);
					state._fsp--;

					// VSLTreeParser.g:177:38: ( IDENT |c= array_elem_assign[symTab, $a.expAtt] )
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
							// VSLTreeParser.g:177:40: IDENT
							{
							IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement578); 

							      //Assign Var
							      Operand3a variable = symTab.lookup((IDENT9!=null?IDENT9.getText():null));
							      if(variable == null) {
							        Errors.unknownIdentifier(ASSIGN_KW10, (IDENT9!=null?IDENT9.getText():null), null);
							      }

							      if(!TypeCheck.checkType(variable.type, a.type))
							        Errors.incompatibleTypes(ASSIGN_KW10, variable.type, a.type, "Mauvaise Assignation");

							      code = Code3aGenerator.assignVar(variable, a);
							    
							}
							break;
						case 2 :
							// VSLTreeParser.g:188:9: c= array_elem_assign[symTab, $a.expAtt]
							{
							pushFollow(FOLLOW_array_elem_assign_in_statement586);
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
					// VSLTreeParser.g:192:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement599);
					b=block(symTab);
					state._fsp--;


					      code.append(b);
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:196:6: ^( PRINT_KW (z= print_item[symTab] )+ )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement614); 
					match(input, Token.DOWN, null); 
					// VSLTreeParser.g:196:17: (z= print_item[symTab] )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==DIV||LA12_0==IDENT||LA12_0==INTEGER||(LA12_0 >= MINUS && LA12_0 <= MUL)||LA12_0==PLUS||LA12_0==TEXT||LA12_0==ARELEM||LA12_0==FCALL||LA12_0==NEGAT) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// VSLTreeParser.g:196:18: z= print_item[symTab]
							{
							pushFollow(FOLLOW_print_item_in_statement619);
							z=print_item(symTab);
							state._fsp--;


							      code.append(z);
							    
							}
							break;

						default :
							if ( cnt12 >= 1 ) break loop12;
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// VSLTreeParser.g:200:5: ^( READ_KW (j= read_item[symTab] )+ )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement636); 
					match(input, Token.DOWN, null); 
					// VSLTreeParser.g:200:15: (j= read_item[symTab] )+
					int cnt13=0;
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==IDENT||LA13_0==ARELEM) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// VSLTreeParser.g:200:16: j= read_item[symTab]
							{
							pushFollow(FOLLOW_read_item_in_statement641);
							j=read_item(symTab);
							state._fsp--;


							      code.append(j);
							    
							}
							break;

						default :
							if ( cnt13 >= 1 ) break loop13;
							EarlyExitException eee = new EarlyExitException(13, input);
							throw eee;
						}
						cnt13++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// VSLTreeParser.g:204:5: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement658); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement662);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement668);
					s1=statement(symTab);
					state._fsp--;


					      	LabelSymbol fin = SymbDistrib.newLabel();
					  		code = Code3aGenerator.genIf(e, s1, fin);

					  	
					// VSLTreeParser.g:210:4: (s2= statement[symTab] )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==ASSIGN_KW||LA14_0==IF_KW||LA14_0==PRINT_KW||(LA14_0 >= READ_KW && LA14_0 <= RETURN_KW)||LA14_0==WHILE_KW||LA14_0==BLOCK||LA14_0==FCALL_S) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// VSLTreeParser.g:210:5: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement682);
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
					// VSLTreeParser.g:219:5: ^( WHILE_KW e= expression[symTab] s1= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement705); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement709);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement714);
					s1=statement(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					  		code = Code3aGenerator.genWhile(e, s1);

					  	
					}
					break;
				case 7 :
					// VSLTreeParser.g:224:3: ^( FCALL_S IDENT (arg= argument_item[symTab] )* )
					{
					FCALL_S12=(CommonTree)match(input,FCALL_S,FOLLOW_FCALL_S_in_statement726); 
					match(input, Token.DOWN, null); 
					IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement728); 

					  int numArg = 0;
					  Operand3a op = symTab.lookup((IDENT11!=null?IDENT11.getText():null));
					  Type typeFun = TypeCheck.checkFunc(op);
					  FunctionSymbol f = null;
					  if(typeFun != Type.ERROR)
					    f = (FunctionSymbol) op;
					  else
					    Errors.unknownIdentifier(IDENT11, (IDENT11!=null?IDENT11.getText():null), null);

					  List<Type> args = ((FunctionType) f.type).getArguments();

					  
					// VSLTreeParser.g:236:5: (arg= argument_item[symTab] )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( (LA15_0==DIV||LA15_0==IDENT||LA15_0==INTEGER||(LA15_0 >= MINUS && LA15_0 <= MUL)||LA15_0==PLUS||LA15_0==ARELEM||LA15_0==FCALL||LA15_0==NEGAT) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// VSLTreeParser.g:236:6: arg= argument_item[symTab]
							{
							pushFollow(FOLLOW_argument_item_in_statement735);
							arg=argument_item(symTab);
							state._fsp--;


							    if(!TypeCheck.checkType(args.get(numArg), arg.type))
							      Errors.incompatibleTypes(FCALL_S12, args.get(numArg), arg.type , "Appelle de la fonction "+(IDENT11!=null?IDENT11.getText():null));

							    code.append(arg.code);
							    code.append(new Inst3a(Inst3a.TAC.ARG, arg.place, null, null));
							    numArg++;
							  
							}
							break;

						default :
							break loop15;
						}
					}

					match(input, Token.UP, null); 


							if(args.size() != numArg){
								Errors.miscError(IDENT11, "Arguments attendus"+args);
							}
							code.append(new Inst3a(Inst3a.TAC.CALL, null, op, null));

						
					}
					break;
				case 8 :
					// VSLTreeParser.g:251:3: ^( RETURN_KW exp= expression[symTab] )
					{
					RETURN_KW13=(CommonTree)match(input,RETURN_KW,FOLLOW_RETURN_KW_in_statement749); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement753);
					exp=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      if(exp.type != Type.INT)
					        Errors.incompatibleTypes(RETURN_KW13, Type.INT, exp.type, "Mauvais type de retour, seul les entiers sont supportés");

								code.append(exp.code);
								code.append(new Inst3a(Inst3a.TAC.RETURN,exp.place,null,null));
							
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
	// VSLTreeParser.g:261:3: print_item[SymbolTable symTab] returns [Code3a code] : ( TEXT |a= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree TEXT14=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:262:5: ( TEXT |a= expression[symTab] )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==TEXT) ) {
				alt17=1;
			}
			else if ( (LA17_0==DIV||LA17_0==IDENT||LA17_0==INTEGER||(LA17_0 >= MINUS && LA17_0 <= MUL)||LA17_0==PLUS||LA17_0==ARELEM||LA17_0==FCALL||LA17_0==NEGAT) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// VSLTreeParser.g:262:7: TEXT
					{
					TEXT14=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item784); 


					        Data3a data = new Data3a((TEXT14!=null?TEXT14.getText():null));

					        code = Code3aGenerator.callPrintS(data);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:269:7: a= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item802);
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
	// VSLTreeParser.g:276:1: read_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARELEM IDENT a= expression[symTab] ) );
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT15=null;
		CommonTree IDENT16=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:277:5: ( IDENT | ^( ARELEM IDENT a= expression[symTab] ) )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==IDENT) ) {
				alt18=1;
			}
			else if ( (LA18_0==ARELEM) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// VSLTreeParser.g:277:6: IDENT
					{
					IDENT15=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item833); 

					        Operand3a variable = symTab.lookup((IDENT15!=null?IDENT15.getText():null));
					        code = Code3aGenerator.callRead(variable);
					      
					}
					break;
				case 2 :
					// VSLTreeParser.g:282:7: ^( ARELEM IDENT a= expression[symTab] )
					{
					match(input,ARELEM,FOLLOW_ARELEM_in_read_item850); 
					match(input, Token.DOWN, null); 
					IDENT16=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item853); 
					pushFollow(FOLLOW_expression_in_read_item857);
					a=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        VarSymbol temp = SymbDistrib.newTemp();
					        code = Code3aGenerator.genVar(temp);
					        code.append(Code3aGenerator.callRead(temp));

					        Operand3a tab = symTab.lookup((IDENT16!=null?IDENT16.getText():null));

					        if(tab == null)
					          Errors.unknownIdentifier(IDENT16, (IDENT16!=null?IDENT16.getText():null), null);

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
	// VSLTreeParser.g:300:1: array_elem_assign[SymbolTable symTab, ExpAttribute valueToAssign] returns [Code3a code] : ^( ARELEM IDENT a= expression[symTab] ) ;
	public final Code3a array_elem_assign(SymbolTable symTab, ExpAttribute valueToAssign) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT17=null;
		CommonTree ARELEM18=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:301:5: ( ^( ARELEM IDENT a= expression[symTab] ) )
			// VSLTreeParser.g:301:7: ^( ARELEM IDENT a= expression[symTab] )
			{
			ARELEM18=(CommonTree)match(input,ARELEM,FOLLOW_ARELEM_in_array_elem_assign893); 
			match(input, Token.DOWN, null); 
			IDENT17=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem_assign896); 
			pushFollow(FOLLOW_expression_in_array_elem_assign900);
			a=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			        Operand3a variable = symTab.lookup((IDENT17!=null?IDENT17.getText():null));

			        if(variable == null)
			          Errors.unknownIdentifier(IDENT17, (IDENT17!=null?IDENT17.getText():null), null);

			        //Test que l'index du tableau est un entier.
			        if(Type.INT != a.type)
			          Errors.incompatibleTypes(ARELEM18, Type.INT, a.type, "");

			        if(Type.INT != valueToAssign.type && Type.POINTER != valueToAssign.type)
			          Errors.incompatibleTypes(ARELEM18, Type.INT, valueToAssign.type, "Mauvaise assignation");

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
	// VSLTreeParser.g:319:1: array_elem_value[SymbolTable symTab] returns [ExpAttribute expAtt] : ^( ARELEM IDENT a= expression[symTab] ) ;
	public final ExpAttribute array_elem_value(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree IDENT19=null;
		CommonTree ARELEM20=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:320:5: ( ^( ARELEM IDENT a= expression[symTab] ) )
			// VSLTreeParser.g:320:7: ^( ARELEM IDENT a= expression[symTab] )
			{
			ARELEM20=(CommonTree)match(input,ARELEM,FOLLOW_ARELEM_in_array_elem_value934); 
			match(input, Token.DOWN, null); 
			IDENT19=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem_value937); 
			pushFollow(FOLLOW_expression_in_array_elem_value941);
			a=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			        VarSymbol temp = SymbDistrib.newTemp();
			        Operand3a variable = symTab.lookup((IDENT19!=null?IDENT19.getText():null));

			        if(variable == null)
			          Errors.unknownIdentifier(IDENT19, (IDENT19!=null?IDENT19.getText():null), null);

			        //Test que l'index du tableau est un entier.
			        if(Type.INT != a.type)
			          Errors.incompatibleTypes(ARELEM20, Type.INT, a.type, "");

			        Code3a code = Code3aGenerator.genVar(temp);
			        code.append(a.code);
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
	// VSLTreeParser.g:339:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e1= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:340:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( NEGAT e1= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt19=6;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt19=1;
				}
				break;
			case MINUS:
				{
				alt19=2;
				}
				break;
			case MUL:
				{
				alt19=3;
				}
				break;
			case DIV:
				{
				alt19=4;
				}
				break;
			case NEGAT:
				{
				alt19=5;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
			case FCALL:
				{
				alt19=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// VSLTreeParser.g:340:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression973); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression977);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression982);
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
					// VSLTreeParser.g:347:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression997); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1001);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1006);
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
					// VSLTreeParser.g:354:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression1021); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1025);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1030);
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
					// VSLTreeParser.g:361:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression1045); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1049);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1054);
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
					// VSLTreeParser.g:368:5: ^( NEGAT e1= expression[symTab] )
					{
					match(input,NEGAT,FOLLOW_NEGAT_in_expression1069); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1073);
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
					// VSLTreeParser.g:375:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression1088);
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
	// VSLTreeParser.g:379:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT |a= array_elem_value[symTab] | ^( FCALL IDENT (arg= argument_item[symTab] )* ) );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER21=null;
		CommonTree IDENT22=null;
		CommonTree IDENT23=null;
		CommonTree FCALL24=null;
		ExpAttribute a =null;
		ExpAttribute arg =null;

		try {
			// VSLTreeParser.g:380:3: ( INTEGER | IDENT |a= array_elem_value[symTab] | ^( FCALL IDENT (arg= argument_item[symTab] )* ) )
			int alt21=4;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt21=1;
				}
				break;
			case IDENT:
				{
				alt21=2;
				}
				break;
			case ARELEM:
				{
				alt21=3;
				}
				break;
			case FCALL:
				{
				alt21=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// VSLTreeParser.g:380:5: INTEGER
					{
					INTEGER21=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp1114); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER21!=null?INTEGER21.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:385:5: IDENT
					{
					IDENT22=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1126); 

					      Operand3a id = symTab.lookup((IDENT22!=null?IDENT22.getText():null));

					      if(id == null) {
					        Errors.unknownIdentifier(IDENT22, (IDENT22!=null?IDENT22.getText():null), null);
					      }
					      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT22!=null?IDENT22.getText():null)));
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:394:5: a= array_elem_value[symTab]
					{
					pushFollow(FOLLOW_array_elem_value_in_primary_exp1140);
					a=array_elem_value(symTab);
					state._fsp--;


					      expAtt = a;
					    
					}
					break;
				case 4 :
					// VSLTreeParser.g:398:4: ^( FCALL IDENT (arg= argument_item[symTab] )* )
					{
					FCALL24=(CommonTree)match(input,FCALL,FOLLOW_FCALL_in_primary_exp1153); 
					match(input, Token.DOWN, null); 
					IDENT23=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1155); 

					      int numArg = 0;
					      Operand3a op = symTab.lookup((IDENT23!=null?IDENT23.getText():null));
					      Type typeFun = TypeCheck.checkFunc(op);
					      FunctionSymbol f = null;

					      if(typeFun == Type.ERROR)
					        Errors.unknownIdentifier(IDENT23, (IDENT23!=null?IDENT23.getText():null), null);

					      if(typeFun != Type.INT)
					        Errors.incompatibleTypes(IDENT23, Type.INT, typeFun, "fonction "+(IDENT23!=null?IDENT23.getText():null));

					      VarSymbol temp = SymbDistrib.newTemp();
					      f = (FunctionSymbol) op;
					      List<Type> args = ((FunctionType) f.type).getArguments();
					      Code3a code = Code3aGenerator.genVar(temp);
					    
					// VSLTreeParser.g:416:5: (arg= argument_item[symTab] )*
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( (LA20_0==DIV||LA20_0==IDENT||LA20_0==INTEGER||(LA20_0 >= MINUS && LA20_0 <= MUL)||LA20_0==PLUS||LA20_0==ARELEM||LA20_0==FCALL||LA20_0==NEGAT) ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// VSLTreeParser.g:416:6: arg= argument_item[symTab]
							{
							pushFollow(FOLLOW_argument_item_in_primary_exp1170);
							arg=argument_item(symTab);
							state._fsp--;



							      if(!TypeCheck.checkType(args.get(numArg), arg.type))
							        Errors.incompatibleTypes(FCALL24, args.get(numArg), arg.type , "Appelle de la fonction "+(IDENT23!=null?IDENT23.getText():null));
							      code.append(arg.code);
							      code.append(new Inst3a(Inst3a.TAC.ARG, arg.place, null, null));
							      numArg++;
							    
							}
							break;

						default :
							break loop20;
						}
					}

					match(input, Token.UP, null); 


							if (typeFun == Type.INT)
					    {
								code.append(new Inst3a(Inst3a.TAC.CALL,temp,op,null));
								expAtt = new ExpAttribute(Type.INT, code, temp);
							}
						
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



	// $ANTLR start "argument_item"
	// VSLTreeParser.g:435:1: argument_item[SymbolTable symTab] returns [ExpAttribute expAtt] : a= expression[symTab] ;
	public final ExpAttribute argument_item(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:436:5: (a= expression[symTab] )
			// VSLTreeParser.g:436:7: a= expression[symTab]
			{
			pushFollow(FOLLOW_expression_in_argument_item1207);
			a=expression(symTab);
			state._fsp--;

			 expAtt = a; 
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
	// $ANTLR end "argument_item"

	// Delegated rules



	public static final BitSet FOLLOW_program_in_s63 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROG_in_program92 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_unit_in_program97 = new BitSet(new long[]{0x0000000008002008L});
	public static final BitSet FOLLOW_function_in_unit134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proto_in_unit147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNC_KW_in_function181 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function185 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function187 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_PARAM_in_function190 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_function195 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_BODY_in_function207 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function211 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENT_in_param238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param249 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param251 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto282 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto286 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto288 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_PARAM_in_proto291 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_proto296 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_INT_KW_in_type326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item378 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item380 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item382 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_declaration419 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration424 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_INST_in_inst_list458 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list463 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_BLOCK_in_block501 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block505 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block510 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block529 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block533 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement569 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement573 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement578 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_assign_in_statement586 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement614 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_item_in_statement619 = new BitSet(new long[]{0x0000908202C14208L});
	public static final BitSet FOLLOW_READ_KW_in_statement636 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_item_in_statement641 = new BitSet(new long[]{0x0000008000004008L});
	public static final BitSet FOLLOW_IF_KW_in_statement658 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement662 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement668 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_statement_in_statement682 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement705 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement709 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement714 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FCALL_S_in_statement726 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_statement728 = new BitSet(new long[]{0x0000908002C14208L});
	public static final BitSet FOLLOW_argument_item_in_statement735 = new BitSet(new long[]{0x0000908002C14208L});
	public static final BitSet FOLLOW_RETURN_KW_in_statement749 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement753 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TEXT_in_print_item784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_read_item833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARELEM_in_read_item850 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_read_item853 = new BitSet(new long[]{0x0000908002C14200L});
	public static final BitSet FOLLOW_expression_in_read_item857 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem_assign893 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem_assign896 = new BitSet(new long[]{0x0000908002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem_assign900 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem_value934 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem_value937 = new BitSet(new long[]{0x0000908002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem_value941 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression973 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression977 = new BitSet(new long[]{0x0000908002C14200L});
	public static final BitSet FOLLOW_expression_in_expression982 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression997 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1001 = new BitSet(new long[]{0x0000908002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1006 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression1021 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1025 = new BitSet(new long[]{0x0000908002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1030 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression1045 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1049 = new BitSet(new long[]{0x0000908002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1054 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGAT_in_expression1069 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1073 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression1088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_value_in_primary_exp1140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FCALL_in_primary_exp1153 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1155 = new BitSet(new long[]{0x0000908002C14208L});
	public static final BitSet FOLLOW_argument_item_in_primary_exp1170 = new BitSet(new long[]{0x0000908002C14208L});
	public static final BitSet FOLLOW_expression_in_argument_item1207 = new BitSet(new long[]{0x0000000000000002L});
}
