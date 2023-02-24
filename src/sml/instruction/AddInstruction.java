package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * AddInstruction is a subclass for Instruction class, specialized for addition operation.
 * <p>
 * Moreover, this subclass uses label, result and source variables
 * 
 * @param label is the line for other instructions to jump.
 * @param result is the leftmost RegisterName that contains one of 8 registers, contains an int number
 * @param source is the rightmost RegisterName that contains one of 8 registers, contains an int number
 * @return the sum of both int values and set as {@code result} int value
 * 
 * @author Harris
 */

public class AddInstruction extends Instruction {
	private final RegisterName result;
	private final RegisterName source;

	public static final String OP_CODE = "add";

	public AddInstruction(String label, RegisterName result, RegisterName source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	@Override
	public int execute(Machine m) {
		int value1 = m.getRegisters().get(result);
		int value2 = m.getRegisters().get(source);
		m.getRegisters().set(result, value1 + value2);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + source;
	}
}