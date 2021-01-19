package adventofcode.day11;

import java.util.Arrays;

public class SeatLayout {

  private char[][] matrix;
  private char[][] workingCopyMatrix;

  private final static char OCCUPIED = '#';
  private final static char EMPTY = 'L';

  public SeatLayout(char[][] matrix) {
    this.matrix = matrix;
    this.workingCopyMatrix = new char[matrix.length][matrix[0].length];
  }

  public int occupiedSeatsCount() {
    var numRows = matrix.length;
    var numCols = matrix[0].length;
    int count = 0;
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        if (matrix[row][col] == OCCUPIED) {
          count++;
        }
      }
    }
    return count;
  }

  // returns true if application of rule causes a seat change
  public boolean applyRules() {

    var numRows = matrix.length;
    var numCols = matrix[0].length;

    var seatHasChanged = false;

    matrixDeepCopy(workingCopyMatrix, matrix);

    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        if (isEmpty(row, col)) {
          seatHasChanged = applyEmptySeatRule(row, col) || seatHasChanged;
        }
        else if (isOccupied(row, col)) {
          seatHasChanged = applyOccupiedSeatRule(row, col) || seatHasChanged;
        }
      }
    }

    matrixDeepCopy(matrix, workingCopyMatrix);

    return seatHasChanged;
  }

  private static void matrixDeepCopy(char[][] dest, char[][] src) {
    int numRows = src.length;

    for (int row = 0; row < numRows; row++) {
      dest[row] = Arrays.copyOf(src[row], src[row].length);
    }
  }

  // returns true if empty seat becomes occupied
  private boolean applyEmptySeatRule(int row, int col) {
    var allAdjacentSeatsAreEmpty = countOccupiedAdjacent(row, col) == 0;

    if (allAdjacentSeatsAreEmpty) {
      workingCopyMatrix[row][col] = OCCUPIED;
      return true;
    }

    return false;
  }

  // returns true if occupied seat becomes empty
  private boolean applyOccupiedSeatRule(int row, int col) {
    var count = countOccupiedAdjacent(row, col);

    if (count >= 4) {
      workingCopyMatrix[row][col] = EMPTY;
      return true;
    }

    return false;
  }

  private int countOccupiedAdjacent(int row, int col) {

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

        if (matrix[i][j] == OCCUPIED) {
          count++;
        }
      }
    }

    return count;
  }

  private boolean isEmpty(int row, int col) {
    return matrix[row][col] == EMPTY;
  }

  private boolean isOccupied(int row, int col) {
    return matrix[row][col] == OCCUPIED;
  }
}
