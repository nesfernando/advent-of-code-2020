package adventofcode.day11;

import java.util.List;

public class MatrixBuilder {

  public static char[][] build(List<String> lines) {
    var numRows = lines.size();
    var numCols = lines.get(0).length();

    var matrix = new char[numRows][numCols];

    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        matrix[row][col] = lines.get(row).charAt(col);
      }
    }

    return matrix;
  }
}
