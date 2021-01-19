package adventofcode.day11;

public class LineOfSightSeatCounter implements OccupiedSeatCounter {

  private Direction[] directions = { new Direction(-1, -1), new Direction(-1, 0), new Direction(-1, 1),
      new Direction(0, -1), new Direction(0, 1), new Direction(1, -1), new Direction(1, 0), new Direction(1, 1) };

  @Override
  public int count(char[][] matrix, int row, int col) {
    int count = 0;
    for (var direction : directions) {
      var seat = firstSeatSeen(matrix, row, col, direction);
      if (seat == SeatLegend.OCCUPIED) {
        count++;
      }
    }
    return count;
  }

  // or floor if no seat is seen
  private static char firstSeatSeen(char[][] matrix, int row, int col, Direction direction) {
    int dr = row + direction.drow;
    int dc = col + direction.dcol;

    while (inBounds(matrix, dr, dc)) {
      var seatSeen = matrix[dr][dc];
      if (seatSeen != SeatLegend.FLOOR) {
        return seatSeen;
      }

      dr += direction.drow;
      dc += direction.dcol;
    }

    // default to floor
    return SeatLegend.FLOOR;
  }

  private static boolean inBounds(char[][] matrix, int row, int col) {
    var numRows = matrix.length;
    var numCols = matrix[0].length;

    return (row >= 0 && row < numRows) && (col >= 0 && col < numCols);
  }

  private class Direction {
    public int drow;
    public int dcol;

    public Direction(int drow, int dcol) {
      this.drow = drow;
      this.dcol = dcol;
    }
  }
}
