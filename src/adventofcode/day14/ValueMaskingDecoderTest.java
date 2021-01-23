package adventofcode.day14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValueMaskingDecoderTest {

  @Test
  void singleEntry() {
    var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
    var decoder = new ValueMaskingDecoder();
    decoder.setMask(mask);

    decoder.setValue(8L, 11L);
    var sumOfValues = decoder.getValues().stream().mapToLong(Long::valueOf).sum();

    assertEquals(73, sumOfValues);
  }

  @Test
  void twoEntries() {
    var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
    var decoder = new ValueMaskingDecoder();
    decoder.setMask(mask);

    decoder.setValue(8L, 11L);
    decoder.setValue(7L, 101L);
    var sumOfValues = decoder.getValues().stream().mapToLong(Long::valueOf).sum();

    assertEquals(174, sumOfValues);
  }

  @Test
  void threeEntries() {
    var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
    var decoder = new ValueMaskingDecoder();
    decoder.setMask(mask);

    decoder.setValue(8L, 11L);
    decoder.setValue(7L, 101L);
    decoder.setValue(8L, 0L);
    var sumOfValues = decoder.getValues().stream().mapToLong(Long::valueOf).sum();

    assertEquals(165, sumOfValues);
  }

}
