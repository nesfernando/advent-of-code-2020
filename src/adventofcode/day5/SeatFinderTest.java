package adventofcode.day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeatFinderTest {

  @Test
  void findRow44() {
    int rowNumber = SeatFinder.findRowNumber("FBFBBFF");

    assertEquals(44, rowNumber);
  }

  @Test
  void findRow70() {
    int rowNumber = SeatFinder.findRowNumber("BFFFBBF");

    assertEquals(70, rowNumber);
  }

  @Test
  void findRow102() {
    int rowNumber = SeatFinder.findRowNumber("BBFFBB");

    assertEquals(102, rowNumber);
  }

  @Test
  void findColumn5() {
    int columnNumber = SeatFinder.findColumnNumber("RLR");

    assertEquals(5, columnNumber);
  }

  @Test
  void findColumn7() {
    int columnNumber = SeatFinder.findColumnNumber("RRR");

    assertEquals(7, columnNumber);
  }

  @Test
  void findColumn4() {
    int columnNumber = SeatFinder.findColumnNumber("RLL");

    assertEquals(4, columnNumber);
  }
}
