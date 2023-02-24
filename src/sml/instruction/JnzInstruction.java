package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * A subclass for Instruction class, specialized for jump operation
 * In addition, this subclass has result and source variables
 * @param JnzInstruction() takes label, result, and source
 * 			returns instantiated variables
 * @param execute() abstract method inherited from Parent class (Instruction class)
 * 			takes both result and source, execute a program
 * 			where if the result register content is not zero,
 * 			return the String jump as next statement to be executed
 * @param toString() another abstract method inherited from Parent class
 * 			returns "" or : based on getLabel + opcode + result + source
 * @author Harris
 */

public class JnzInstruction extends Instruction {
	private final RegisterName result;
	private final String labelAddress;

	public static final String OP_CODE = "jnz";

	public JnzInstruction(String label, RegisterName result, String labelAddress) {
		super(label, OP_CODE);
		this.result = result;
		this.labelAddress = labelAddress;
	}

	@Override
	public int execute(Machine m) {
		int value1 = m.getRegisters().get(result);
		if (value1 != 0){
			labels.getAddress(labelAddress);
		}
		m.getRegisters().set(result, label);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + ;
	}
}
