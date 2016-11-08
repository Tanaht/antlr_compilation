/**
 * This class implements all the methods for 3a code generation (NOTE: this
 * class must be coded by the student; the methods indicated here can be seen as
 * a suggestion, but are not actually necessary).
 *
 * @author MLB
 *
 */
public class Code3aGenerator {

	// Constructor not needed
	private Code3aGenerator() {
	}

	/**
	 * Generates the 3a statement: VAR t
	 **/
	public static Code3a genVar(Operand3a t) {
		Inst3a i = new Inst3a(Inst3a.TAC.VAR, t, null, null);
		return new Code3a(i);
	}


	public static Code3a assignVar(Operand3a varPlace, ExpAttribute exp) {
		Code3a code = exp.code;
		code.append(new Inst3a(Inst3a.TAC.COPY, varPlace, exp.place, null));
		return code;
	}

	public static Code3a assignVarTab(Operand3a varPlace, ExpAttribute index, ExpAttribute value) {
		Code3a code = index.code;
		code.append(value.code);
		code.append(new Inst3a(Inst3a.TAC.VARTAB, varPlace, index.place, value.place));
		return code;
	}

	public static Code3a genWhile(ExpAttribute cond, Code3a inst) {
		LabelSymbol debut = SymbDistrib.newLabel();
		LabelSymbol fin = SymbDistrib.newLabel();
		Code3a code = new Code3a();

		code.append(new Inst3a(Inst3a.TAC.LABEL, debut, null, null));

		VarSymbol temp = SymbDistrib.newTemp();
		code.append(Code3aGenerator.assignVar(temp, cond));

		code.append(new Inst3a(Inst3a.TAC.IFZ, temp, fin, null));

		code.append(inst);
    code.append(new Inst3a(Inst3a.TAC.GOTO, debut, null, null));
		code.append(new Inst3a(Inst3a.TAC.LABEL, fin, null, null));
		return code;
	}

	public static Code3a genIf(ExpAttribute cond, Code3a then, LabelSymbol fin) {
		LabelSymbol vrai = SymbDistrib.newLabel();
		LabelSymbol faux = SymbDistrib.newLabel();

		VarSymbol t1 = SymbDistrib.newTemp();

		Code3a code = Code3aGenerator.assignVar(t1, cond);

		code.append(new Inst3a(Inst3a.TAC.IFZ, t1, faux, null));

		code.append(then);
		code.append(new Inst3a(Inst3a.TAC.GOTO, fin, null, null));

		code.append(new Inst3a(Inst3a.TAC.LABEL, faux, null, null));
		return code;
	}

	/**
	 * Generate code for a binary operation
	 *
	 * @param op
	 *            must be a code op: Inst3a.TAC.XXX
	 */
	public static Code3a genBinOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp1,
			ExpAttribute exp2) {
		Code3a cod = exp1.code;
		cod.append(exp2.code);
		cod.append(genVar(temp));
		cod.append(new Inst3a(op, temp, exp1.place, exp2.place));
		return cod;
	}


	/**
	 * Generate code for a binary operation
	 *
	 * @param op
	 *            must be a code op: Inst3a.TAC.XXX
	 */
	public static Code3a genUnOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp1) {
		Code3a cod = exp1.code;
		cod.append(genVar(temp));
		cod.append(new Inst3a(op, temp, exp1.place, null));//op == TAC.NEG
		return cod;
	}


/*
ARG arg a
CALL a = call b ou call b
*/
	public static Code3a callPrintS(LabelSymbol label) {
		Code3a code = new Code3a(new Inst3a(Inst3a.TAC.LABEL, label, null, null));
		code.append(new Code3a(new Inst3a(Inst3a.TAC.ARG, label, null, null)));
		code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintS, null)));
		return code;
	}

	public static Code3a callPrintN(Operand3a place) {
		Code3a code = new Code3a(new Inst3a(Inst3a.TAC.ARG, place, null, null));
		code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintN, null)));
		return code;
	}

} // Code3aGenerator ***
