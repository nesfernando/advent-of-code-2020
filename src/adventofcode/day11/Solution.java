package adventofcode.day11;

import java.util.List;

public class Solution {

  public static int partOne(List<String> lines) {
    var layout = new SeatLayout(MatrixBuilder.build(lines), new AdjacentSeatCounter());

    do {

    }
    while (layout.applyRules());

    return layout.occupiedSeatsCount();
  }
}
