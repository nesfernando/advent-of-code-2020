package adventofcode.day14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValueConverterTest {

  @Test
  void decimal11ToBinaryString() {
    var decimal = 11L;

    assertEquals("000000000000000000000000000000001011", ValueConverter.decimalToBinaryString(decimal));
  }

  @Test
  void decimal73ToBinaryString() {
    var decimal = 73L;

    assertEquals("000000000000000000000000000001001001", ValueConverter.decimalToBinaryString(decimal));
  }

  @Test
  void binaryString11ToDecimal() {
    var string = "000000000000000000000000000000001011";

    assertEquals(11L, ValueConverter.binaryStringToDecimal(string));
  }

  @Test
  void binaryString73ToDecimal() {
    var string = "000000000000000000000000000001001001";

    assertEquals(73L, ValueConverter.binaryStringToDecimal(string));
  }
}
