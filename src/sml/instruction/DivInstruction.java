package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * A subclass for Instruction class, specialized for divide operation
 * In addition, this subclass has result and source variables
 * @param DivInstruction() takes label, result, and source
 * 			returns instantiated variables
 * @param execute() abstract method inherited from Parent class (Instruction class)
 * 			takes both result and source, execute a program
 * 			returns result and dividend values (result / source)
 * @param toString() another abstract method inherited from Parent class
 * 			returns "" or : based on getLabel + opcode + result + source
 * @author Harris
 */

public class DivInstruction extends Instruction {
	private final RegisterName result;
	private final RegisterName source;

	public static final String OP_CODE = "div";

	public DivInstruction(String label, RegisterName result, RegisterName source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	@Override
	public int execute(Machine m) {
		int value1 = m.getRegisters().get(result);
		int value2 = m.getRegisters().get(source);
		m.getRegisters().set(result, value1 / value2);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + source;
	}
}
