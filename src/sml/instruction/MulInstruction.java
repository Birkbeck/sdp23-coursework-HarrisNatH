package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;
import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * MulInstruction implements the multiplication r1 r2 operation.
 * 
 * @author Harris
 */

public class MulInstruction extends Instruction {
	private final RegisterName result;
	private final RegisterName source;

	public static final String OP_CODE = "mul";

	/**
	 * @param label is the line for other instructions to jump.
	 * @param result register containing one value to be multiplied by r2. 
	 * 					The result of the multiplication is written here.
	 * @param source register containing one value to multiply to r1.
	 * @return new MulInstruction instance.
	 **/
	public MulInstruction(String label, RegisterName result, RegisterName source) {
		super(label, OP_CODE);
		this.result = result;
		this.source = source;
	}

	/**
	 * Execute the multiplication operation by reading the values in the result and source registers, 
	 * 			multiplying them up and writing the result into the result register.
	 * 
	 * @param m Machine object containing the current state of the registers.
	 * @return NORMAL_PROGRAM_COUNTER_UPDATE.
	 **/
	@Override
	public int execute(Machine m) {
		int value1 = m.getRegisters().get(result);
		int value2 = m.getRegisters().get(source);
		m.getRegisters().set(result, value1 * value2);
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + result + " " + source;
	}

	@Override
	public boolean equals(Object o){
		if (o instanceof MulInstruction other) {
			return Objects.equals(this.label, other.label)
					&& Objects.equals(this.result, other.result)
					&& Objects.equals(this.source, other.source);
		}
		return false;
	}

	@Override
	public int hashCode(){
		return Objects.hash(label, result, source);
	}
}
