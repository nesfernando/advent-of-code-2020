package adventofcode.day14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class AddressMaskTest {

  @Test
  void twoFloatingFourAddresses() {
    var mask = "000000000000000000000000000000X1001X";
    var address = "000000000000000000000000000000101010";

    var generatedAddresses = Set.of(
        "000000000000000000000000000000011010", "000000000000000000000000000000011011",
        "000000000000000000000000000000111010", "000000000000000000000000000000111011");

    assertEquals(generatedAddresses, AddressMask.apply(mask, address));
  }
}
