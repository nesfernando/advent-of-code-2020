package adventofcode.day14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerTest {

  @Test
  void singleEntry() {
    var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
    var computer = new Computer();
    computer.setMask(mask);

    computer.setValue(8L, 11L);
    var sumOfValues = computer.getValues().stream().mapToLong(Long::valueOf).sum();

    assertEquals(73, sumOfValues);
  }

  @Test
  void twoEntries() {
    var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
    var computer = new Computer();
    computer.setMask(mask);

    computer.setValue(8L, 11L);
    computer.setValue(7L, 101L);
    var sumOfValues = computer.getValues().stream().mapToLong(Long::valueOf).sum();

    assertEquals(174, sumOfValues);
  }

  @Test
  void threeEntries() {
    var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
    var computer = new Computer();
    computer.setMask(mask);

    computer.setValue(8L, 11L);
    computer.setValue(7L, 101L);
    computer.setValue(8L, 0L);
    var sumOfValues = computer.getValues().stream().mapToLong(Long::valueOf).sum();

    assertEquals(165, sumOfValues);
  }

}
