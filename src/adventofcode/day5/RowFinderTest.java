package adventofcode.day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RowFinderTest {

  @Test
  void findRow44() {
    int rowNumber = RowFinder.findRowNumber("FBFBBFF");

    assertEquals(44, rowNumber);
  }

  @Test
  void findRow70() {
    int rowNumber = RowFinder.findRowNumber("BFFFBBF");

    assertEquals(70, rowNumber);
  }

  @Test
  void findRow102() {
    int rowNumber = RowFinder.findRowNumber("BBFFBB");

    assertEquals(102, rowNumber);
  }
}
