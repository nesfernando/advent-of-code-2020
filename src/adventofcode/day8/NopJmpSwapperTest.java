package adventofcode.day8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class NopJmpSwapperTest {

  @Test
  void swapNopAtIndexOneJmpAtIndexTwo() {
    var program = Arrays.asList("acc +1", "nop +1", "jmp -4");

    var swapper = new NopJmpSwapper(program);

    assertEquals(Arrays.asList("acc +1", "jmp +1", "jmp -4"), swapper.nextSwappedProgram());
    assertEquals(Arrays.asList("acc +1", "nop +1", "nop -4"), swapper.nextSwappedProgram());
  }

  @Test
  void twoSwapsThenThrow() {
    var program = Arrays.asList("acc +1", "nop +1", "jmp -4");

    var swapper = new NopJmpSwapper(program);

    swapper.nextSwappedProgram();
    swapper.nextSwappedProgram();

    assertThrows(IllegalStateException.class, () -> {
      swapper.nextSwappedProgram();
    });
  }

  @Test
  void twoSwapsThenHasNextIsFalse() {
    var program = Arrays.asList("acc +1", "nop +1", "jmp -4");

    var swapper = new NopJmpSwapper(program);

    swapper.nextSwappedProgram();
    swapper.nextSwappedProgram();
    assertFalse(swapper.hasNext());
  }
}
