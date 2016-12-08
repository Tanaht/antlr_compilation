/**
 * Type checking operations (NOTE: this class must be implemented by the
 * student; the methods indicated here can be seen as suggestions; note that
 * some minor checks can still be performed directly in VSLTreeParser.g).
 *
 */
public class TypeCheck {

	// an Example
	/**
	 * Type checking for a binary operation - in VSL+: integer operations only!
	 */
	public static Type checkBinOp(Type t1, Type t2) {
		if (t1 == Type.INT && t2 == Type.INT)
			return Type.INT;
		else {
			return Type.ERROR;
		}
	}

	public static Type checkFunc(Operand3a op){
		if(op instanceof FunctionSymbol){
			return ((FunctionType) op.type).getReturnType();
		}
		return Type.ERROR;
	}

	/**
	* return vrai, si op convient à expected, faux sinon
	*/
	public static boolean checkType(Type expected, Type type) {
		if (expected == Type.INT)
				return type == Type.INT || type == Type.POINTER;

 		return type == Type.POINTER || type instanceof ArrayType;
	}
}
