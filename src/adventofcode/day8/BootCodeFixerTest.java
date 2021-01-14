package adventofcode.day8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class BootCodeFixerTest {
  @Test
  void baseExampleFromPart1() {
    var program = Arrays.asList(
        "nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4", "acc +6");

    var fixer = new BootCodeFixer(program);

    assertEquals(8, fixer.getAccumulatorAtProgramEnd());
  }

}
