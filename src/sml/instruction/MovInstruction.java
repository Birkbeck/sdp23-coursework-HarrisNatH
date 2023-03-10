package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;
import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * MovInstruction implements the load r1 Integer operation.
 * 
 * @author Harris
 */

public class MovInstruction extends Instruction {
	private final RegisterName result;
	private final Integer value;

	public static final String OP_CODE = "mov";

	/**
	 * @param label is the line for other instructions to jump.
	 * @param result register which Integer to be loaded/moved into. 
	 * 					The result of the loading is written here.
	 * @param value Integer to load into result register.
	 * @return new MovInstruction instance.
	 **/
	public MovInstruction(String label, RegisterName result, Integer value) {
		super(label, OP_CODE);
		this.result = result;
		this.value = value;
	}

	/**
	 * Execute the load operation by moving the Integer value into the result register.
	 * 
	 * @param m Machine object containing the current state of the registers.
	 * @return NORMAL_PROGRAM_COUNTER_UPDATE.
	 **/
	@Override
	public int execute(Machine m) {
		m.getRegisters().set(result, value);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + value;
	}

	@Override
	public boolean equals(Object o){
		if (o instanceof MovInstruction other) {
			return Objects.equals(this.label, other.label)
					&& Objects.equals(this.result, other.result)
					&& Objects.equals(this.value, other.value);
		}
		return false;
	}

	@Override
	public int hashCode(){
		return Objects.hash(label, result, value);
	}
}
