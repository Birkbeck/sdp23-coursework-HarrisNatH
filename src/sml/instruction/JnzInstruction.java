package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;
import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * JnzInstruction implements the jnz r1 label operation.
 * 
 * @author Harris
 */

public class JnzInstruction extends Instruction {
	private final RegisterName condition;
	private final String labelJump;

	public static final String OP_CODE = "jnz";

	/**
	 * @param label is the line for other instructions to jump.
	 * @param condition register containing the value to be tested.
	 * @param labelJump name of the label to jump to if the value in condition is non-zero.
	 * @return new JnzInstruction instance.
	 **/
	public JnzInstruction(String label, RegisterName condition, String labelJump) {
		super(label, OP_CODE);
		this.condition = condition;
		this.labelJump = labelJump;
	}

	/**
	 * Execute the jnz operation by reading the value in the condition register and 
	 * 			jumping to jumpLabel if the value is non-zero
	 * 
	 * @param m Machine object containing the current state of the registers.
	 * @return NORMAL_PROGRAM_COUNTER_UPDATE if value in the condition register is zero. 
	 * 			Address of labelJump otherwise.
	 **/
	@Override
	public int execute(Machine m) {
		int value = m.getRegisters().get(condition);
		if (value != 0){
			return m.getLabels().getAddress(labelJump);
		}
		return NORMAL_PROGRAM_COUNTER_UPDATE;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + condition + " " + labelJump;
	}

	@Override
	public boolean equals(Object o){
		if (o instanceof JnzInstruction other) {
			return Objects.equals(this.label, other.label)
					&& Objects.equals(this.condition, other.condition)
					&& Objects.equals(this.labelJump, other.labelJump);
		}
		return false;
	}

	@Override
	public int hashCode(){
		return Objects.hash(label, condition, labelJump);
	}
}
