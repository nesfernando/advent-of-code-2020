package adventofcode.day14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaskTest {

  @Test
  void decimal11To73() {
    var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
    var value = "000000000000000000000000000000001011";

    assertEquals("000000000000000000000000000001001001", Mask.apply(mask, value));
  }

  @Test
  void decimal101To101() {
    var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
    var value = "000000000000000000000000000001100101";

    assertEquals("000000000000000000000000000001100101", Mask.apply(mask, value));
  }

  @Test
  void decimal0To64() {
    var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
    var value = "000000000000000000000000000000000000";

    assertEquals("000000000000000000000000000001000000", Mask.apply(mask, value));
  }
}
