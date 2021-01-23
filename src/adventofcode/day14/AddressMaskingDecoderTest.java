package adventofcode.day14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddressMaskingDecoderTest {

  @Test
  void baseExample2() {
    var decoder = new AddressMaskingDecoder();
    decoder.setMask("000000000000000000000000000000X1001X");
    decoder.setValue(42L, 100L);
    decoder.setMask("00000000000000000000000000000000X0XX");
    decoder.setValue(26L, 1L);

    var sumOfValues = decoder.getValues().stream().mapToLong(Long::valueOf).sum();

    assertEquals(208, sumOfValues);
  }

}
