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

} // Code3aGenerator ***
