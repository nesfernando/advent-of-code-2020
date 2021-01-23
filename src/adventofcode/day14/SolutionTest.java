package adventofcode.day14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void baseExample1() {
    var instructions = List.of(
        "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X", "mem[8] = 11", "mem[7] = 101", "mem[8] = 0");

    assertEquals(165, Solution.partOne(instructions));
  }

  @Test
  void baseExample2() {
    var instructions = List.of(
        "mask = 000000000000000000000000000000X1001X", "mem[42] = 100", "mask = 00000000000000000000000000000000X0XX",
        "mem[26] = 1");

    assertEquals(208, Solution.partTwo(instructions));
  }

}
