package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;
import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * OutInstruction implements the output r1 operation to the console.
 * 
 * @author Harris
 */

public class OutInstruction extends Instruction {
	private final RegisterName result;

	public static final String OP_CODE = "out";

	/**
	 * @param label is the line for other instructions to jump.
	 * @param result register containing the value to be outputed.
	 * @return new OutInstruction instance.
	 **/
	public OutInstruction(String label, RegisterName result) {
		super(label, OP_CODE);
		this.result = result;
	}

	/**
	 * Execute the out operation by outputting the value in result to stdout (the console).
	 * 
	 * @param m Machine object containing the current state of the registers.
	 * @return NORMAL_PROGRAM_COUNTER_UPDATE.
	 **/
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
