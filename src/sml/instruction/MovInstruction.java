package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * A subclass for Instruction class, specialized for add operation
 * In addition, this subclass has result and source variables
 * @param MovInstruction() takes label, result, and value
 * 			returns instantiated variables
 * @param execute() abstract method inherited from Parent class (Instruction class)
 * 			takes both result and value, execute a program
 * 			returns the integer x (value) set as result registerName 
 * @param toString() another abstract method inherited from Parent class
 * 			returns "" or : based on getLabel + opcode + result + value
 * @author Harris
 */

public class MovInstruction extends Instruction {
	private final RegisterName result;
	private final int value;

	public static final String OP_CODE = "mov";

	public MovInstruction(String label, RegisterName result, int value) {
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
