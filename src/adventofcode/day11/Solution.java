package adventofcode.day11;

import java.util.List;

public class Solution {

  public static int partOne(List<String> lines) {
    var layout = new SeatLayout(MatrixBuilder.build(lines), new AdjacentSeatCounter());

    return countOccupiedSeats(layout);
  }

  public static int partTwo(List<String> lines) {
    var layout = new SeatLayout(MatrixBuilder.build(lines), new LineOfSightSeatCounter(), 5);

    return countOccupiedSeats(layout);
  }

  private static int countOccupiedSeats(SeatLayout layout) {
    do {

    }
    while (layout.applyRules());

    return layout.occupiedSeatsCount();
  }
}
