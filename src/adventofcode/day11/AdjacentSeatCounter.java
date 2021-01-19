package adventofcode.day11;

public class AdjacentSeatCounter implements OccupiedSeatCounter {

  @Override
  public int count(char[][] matrix, int row, int col) {
    int count = 0;
    for (int i = row - 1; i <= row + 1; i++) {
      if (i < 0 || i >= matrix.length) {
        continue;
      }

      for (int j = col - 1; j <= col + 1; j++) {
        if (j < 0 || j >= matrix[0].length) {
          continue;
        }

        if (i == row && j == col) {
          continue;
        }

        if (matrix[i][j] == SeatLegend.OCCUPIED) {
          count++;
        }
      }
    }

    return count;
  }
}