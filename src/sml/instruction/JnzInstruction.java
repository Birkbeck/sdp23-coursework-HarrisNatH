package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * JnzInstruction is a subclass for Instruction class, specialized for address jump operation.
 * Moreover, this subclass has result 
 * 
 * @param label is the line for other instructions to jump.
 * @param result is the leftmost RegisterName that contains one of 8 registers, contains an int number
 * @return 
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
			if(label == labelAddress){
				label.getAddress(labelAddress);
			}
		}
		m.getRegisters().set(result, label);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " ";
	}
}
