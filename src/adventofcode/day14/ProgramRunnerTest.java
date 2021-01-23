package adventofcode.day14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ProgramRunnerTest {

  @Test
  void baseExample1() {
    var instructions = List.of(
        "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X", "mem[8] = 11", "mem[7] = 101", "mem[8] = 0");

    assertEquals(165, ProgramRunner.sumOfValues(instructions));
  }

}
