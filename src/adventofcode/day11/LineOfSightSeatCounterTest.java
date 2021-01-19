package adventofcode.day11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LineOfSightSeatCounterTest {

  @Test
  void allDirectionsEightOccupied() {
    var matrix = MatrixBuilder.build(
        List.of(
            ".......#.", "...#.....", ".#.......", ".........", "..#L....#", "....#....", ".........", "#........",
            "...#....."));

    var occupiedSeatCounter = new LineOfSightSeatCounter();

    assertEquals(8, occupiedSeatCounter.count(matrix, 4, 3));
  }

  @Test
  void oneEmptySeatNoOccupied() {
    var matrix = MatrixBuilder.build(List.of(".............", ".L.L.#.#.#.#.", "............."));

    var occupiedSeatCounter = new LineOfSightSeatCounter();

    assertEquals(0, occupiedSeatCounter.count(matrix, 1, 1));
  }

  @Test
  void noOccupiedSeatsInLineOfSight() {
    var matrix = MatrixBuilder.build(
        List.of(".##.##.", "#.#.#.#", "##...##", "...L...", "##...##", "#.#.#.#", ".##.##."));

    var occupiedSeatCounter = new LineOfSightSeatCounter();

    assertEquals(0, occupiedSeatCounter.count(matrix, 3, 3));
  }
}
