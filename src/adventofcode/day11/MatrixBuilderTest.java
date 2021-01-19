package adventofcode.day11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MatrixBuilderTest {

  @Test
  void twoByTen() {
    var lines = List.of("#.LL.L#.##", "#LLLLLL.L#");

    var matrix = MatrixBuilder.build(lines);

    char[][] expected = { { '#', '.', 'L', 'L', '.', 'L', '#', '.', '#', '#' },
        { '#', 'L', 'L', 'L', 'L', 'L', 'L', '.', 'L', '#' } };

    assertArrayEquals(expected, matrix);
  }

}
