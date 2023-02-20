package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * A subclass for Instruction class, specialized for substraction operation
 * In addition, this subclass only has result variable
 * @param OutInstruction() takes label, result
 * 			returns instantiated variables
 * @param execute() abstract method inherited from Parent class (Instruction class)
 * 			takes result variable, execute a program
 * 			returns result value on the console
 * @param toString() another abstract method inherited from Parent class
 * 			returns "" or : based on getLabel + opcode + result
 * @author Harris
 */

public class OutInstruction extends Instruction {
	private final RegisterName result;

	public static final String OP_CODE = "out";

	public OutInstruction(String label, RegisterName result) {
		super(label, OP_CODE);
		this.result = result;
	}

	@Override
	public int execute(Machine m) {
		int value1 = m.getRegisters().get(result);
		m.getRegisters().set(result, value1);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result;
	}
}
