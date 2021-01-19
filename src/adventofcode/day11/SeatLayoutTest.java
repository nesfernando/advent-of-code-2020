package adventofcode.day11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SeatLayoutTest {

  @Test
  void baseExample1() {
    var lines = List.of(
        "L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL",
        "L.LLLLLL.L", "L.LLLLL.LL");
    var matrix = MatrixBuilder.build(lines);

    var layout = new SeatLayout(matrix);
    assertEquals(0, layout.occupiedSeatsCount());

    assertTrue(layout.applyRules());
    assertEquals(71, layout.occupiedSeatsCount());

    do {

    }
    while (layout.applyRules());

    assertEquals(37, layout.occupiedSeatsCount());
  }

}
