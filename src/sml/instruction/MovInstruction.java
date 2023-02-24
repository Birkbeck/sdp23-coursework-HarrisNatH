package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * MovInstruction is a subclass for Instruction class, specialized for move/load operation.
 * In addition, this subclass has result and value variables
 * 
 * @param label is the line for other instructions to jump.
 * @param result is the leftmost RegisterName that contains one of 8 registers
 * @param value is the Integer
 * @return the Integer set as {@code result} value
 * 
 * @author Harris
 */

public class MovInstruction extends Instruction {
	private final RegisterName result;
	private final Integer value;

	public static final String OP_CODE = "mov";

	public MovInstruction(String label, RegisterName result, Integer value) {
		super(label, OP_CODE);
		this.result = result;
		this.value = value;
	}

	@Override
	public int execute(Machine m) {
		m.getRegisters().set(result, value);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + value;
	}
}
