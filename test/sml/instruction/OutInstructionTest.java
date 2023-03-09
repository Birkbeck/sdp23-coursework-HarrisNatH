package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OutInstructionTest {
  private Machine machine;
  private Registers registers;
  private ByteArrayOutputStream capturedOut;

  @BeforeEach
  void setUp() {
    machine = new Machine(new Registers());
    registers = machine.getRegisters();
    capturedOut = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(capturedOut);
    System.setOut(ps);
  }

  @AfterEach
  void tearDown() {
    machine = null;
    registers = null;
    capturedOut = null;
  }

  @Test
  void executeValid() {
    registers.set(EAX, 5);
    Instruction instruction = new OutInstruction(null, EAX);
    instruction.execute(machine);
    Assertions.assertEquals("5", capturedOut.toString().strip());
  }

  @Test
  void executeValidTwo() {
    registers.set(EAX, -5);
    Instruction instruction = new OutInstruction(null, EAX);
    instruction.execute(machine);
    Assertions.assertEquals("-5", capturedOut.toString().strip());
  }
}