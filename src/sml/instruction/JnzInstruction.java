package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * JnzInstruction is a subclass for Instruction class, specialized for address jump operation.
 * Moreover, this subclass has result and 
 * 
 * @param label is the line for other instructions to jump.
 * @param result is the leftmost RegisterName that contains one of 8 registers, contains an int number
 * @return 
 * @author Harris
 */

public class JnzInstruction extends Instruction {
	private final RegisterName result;
	private final String labelJump;

	public static final String OP_CODE = "jnz";

	public JnzInstruction(String label, RegisterName result, String labelJump) {
		super(label, OP_CODE);
		this.result = result;
		this.labelJump = labelJump;
	}

	@Override
	public int execute(Machine m) {
		int value = m.getRegisters().get(result);
		if (value != 0){
			m.getLabels();
		}
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + labelJump;
	}
}
