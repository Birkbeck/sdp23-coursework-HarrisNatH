package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;
import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * JnzInstruction is a subclass for Instruction class, specialized for address jump operation.
 * Moreover, this subclass has result and 
 * 
 * @param label is the line for other instructions to jump.
 * @param result is the leftmost RegisterName that contains one of 8 registers, contains an int number
 * @return 
 * @author Harris
 */

public class JnzInstruction extends Instruction {
	private final RegisterName condition;
	private final String labelJump;

	public static final String OP_CODE = "jnz";

	public JnzInstruction(String label, RegisterName condition, String labelJump) {
		super(label, OP_CODE);
		this.condition = condition;
		this.labelJump = labelJump;
	}

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
