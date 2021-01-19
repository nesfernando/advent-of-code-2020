package adventofcode.day11;

import java.util.List;

public class Solution {

  public static int partOne(List<String> lines) {
    var matrix = MatrixBuilder.build(lines);

    var layout = new SeatLayout(matrix);

    do {

    }
    while (layout.applyRules());

    return layout.occupiedSeatsCount();
  }
}
