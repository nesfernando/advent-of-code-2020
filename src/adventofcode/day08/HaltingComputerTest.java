package adventofcode.day08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class HaltingComputerTest {

  @Test
  void baseExampleFromPart1() {
    var program = Arrays.asList(
        "nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4", "acc +6");

    var computer = new HaltingComputer(program);

    while (!computer.willLoopAtCurrentInstruction()) {
      computer.executeCurrentInstruction();
    }

    assertEquals(5, computer.getAccumulator());
  }

  @Test
  void executeProgramSuccessfully() {
    var program = Arrays.asList(
        "nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "nop -4", "acc +6");

    var computer = new HaltingComputer(program);

    do {
      computer.executeCurrentInstruction();
    }
    while (!computer.hasSuccessfullyTerminated());

    assertEquals(8, computer.getAccumulator());
  }

}
