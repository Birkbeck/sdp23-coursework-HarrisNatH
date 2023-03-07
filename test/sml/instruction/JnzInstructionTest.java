package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.*;

class JnzInstructionTest {
  private Machine machine;
  private Registers registers;

  @BeforeEach
  void setUp() {
    machine = new Machine(new Registers());
    registers = machine.getRegisters();
    //...
  }

  @AfterEach
  void tearDown() {
    machine = null;
    registers = null;
  }

  @Test
  void jumpIfNotZero() {
    registers.set(EAX, 1);
    String label = "label";
    int address = 50;
    machine.getLabels().addLabel(label,address);
    Instruction instruction = new JnzInstruction(null, EAX, label);
    int return_code = instruction.execute(machine);
    Assertions.assertEquals(address, return_code);
  }

  @Test
  void noJumpIfZero() {
    registers.set(EAX, 0);
    String label = "label";
    int address = 50;
    machine.getLabels().addLabel(label,address);
    Instruction instruction = new JnzInstruction(null, EAX, label);
    int return_code = instruction.execute(machine);
    Assertions.assertEquals(Instruction.NORMAL_PROGRAM_COUNTER_UPDATE, return_code);
  }
}