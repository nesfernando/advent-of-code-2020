package adventofcode.day16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValueRangeTest {

  @Test
  void withinRange() {
    var range = new ValueRange(27, 180);

    assertTrue(range.inRange(27));
    assertTrue(range.inRange(30));
    assertTrue(range.inRange(180));
  }

  @Test
  void belowRange() {
    var range = new ValueRange(27, 180);

    assertFalse(range.inRange(26));
  }

  @Test
  void aboveRange() {
    var range = new ValueRange(27, 180);

    assertFalse(range.inRange(181));
  }
}
