package adventofcode.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReportRepairTest {

  @Test
  void testTwoTerm() {
    int actual = ReportRepair.twoNumbersFormMagicNumber();

    assertEquals(902451, actual);
  }

  @Test
  void testThreeTerm() {
    int actual = ReportRepair.threeNumbersFormMagicNumber();

    assertEquals(85555470, actual);
  }
}
