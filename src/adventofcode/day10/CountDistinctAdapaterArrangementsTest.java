package adventofcode.day10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CountDistinctAdapaterArrangementsTest {

  @Test
  void baseCase() {
    var joltages = List.of(1);

    assertEquals(1, Solution.countDistinctAdapterArrangements(joltages));
  }

  @Test
  void twoAdapters() {
    var joltages = List.of(1, 2);

    assertEquals(2, Solution.countDistinctAdapterArrangements(joltages));
  }

  @Test
  void baseExample1() {
    var joltages = List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4);

    assertEquals(8, Solution.countDistinctAdapterArrangements(joltages));
  }

  @Test
  void baseExample2() {
    var joltages = List.of(
        28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19, 38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34,
        10, 3);

    assertEquals(19208, Solution.countDistinctAdapterArrangements(joltages));
  }
}
