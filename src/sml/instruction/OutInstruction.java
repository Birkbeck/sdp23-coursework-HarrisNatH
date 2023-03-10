package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;
import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * OutInstruction is a subclass for Instruction class, specialized for Output operation.
 * <p>
 * Moreover, this subclass uses label, and result variables
 * 
 * @param label is the line for other instructions to jump.
 * @param result is the leftmost RegisterName that contains one of 8 registers, contains an int number
 * @return the integer assigned on {@code result}
 * 
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
		int value = m.getRegisters().get(result);
		System.out.println(value);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result;
	}

	@Override
	public boolean equals(Object o){
		if (o instanceof OutInstruction other) {
			return Objects.equals(this.label, other.label)
					&& Objects.equals(this.result, other.result);
		}
		return false;
	}

	@Override
	public int hashCode(){
		return Objects.hash(label, result);
	}
}
