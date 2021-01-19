package adventofcode.day11;

import java.util.Arrays;

public class SeatLayout {

  private char[][] matrix;
  private char[][] workingCopyMatrix;

  private int occupiedSeatThreshold;
  private OccupiedSeatCounter occupiedSeatCounter;

  public SeatLayout(char[][] matrix, OccupiedSeatCounter occupiedSeatCounter, int occupiedSeatThreshold) {
    this.matrix = matrix;
    this.workingCopyMatrix = new char[matrix.length][matrix[0].length];

    this.occupiedSeatCounter = occupiedSeatCounter;
    this.occupiedSeatThreshold = occupiedSeatThreshold;
  }

  public SeatLayout(char[][] matrix, OccupiedSeatCounter occupiedSeatCounter) {
    this(matrix, new AdjacentSeatCounter(), 4);
  }

  public SeatLayout(char[][] matrix) {
    this(matrix, new AdjacentSeatCounter());
  }

  public int occupiedSeatsCount() {
    var numRows = matrix.length;
    var numCols = matrix[0].length;
    int count = 0;
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        if (matrix[row][col] == SeatLegend.OCCUPIED) {
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
    var allAdjacentSeatsAreEmpty = occupiedSeatCounter.count(matrix, row, col) == 0;

    if (allAdjacentSeatsAreEmpty) {
      workingCopyMatrix[row][col] = SeatLegend.OCCUPIED;
      return true;
    }

    return false;
  }

  // returns true if occupied seat becomes empty
  private boolean applyOccupiedSeatRule(int row, int col) {
    var count = occupiedSeatCounter.count(matrix, row, col);

    if (count >= occupiedSeatThreshold) {
      workingCopyMatrix[row][col] = SeatLegend.EMPTY;
      return true;
    }

    return false;
  }

  private boolean isEmpty(int row, int col) {
    return matrix[row][col] == SeatLegend.EMPTY;
  }

  private boolean isOccupied(int row, int col) {
    return matrix[row][col] == SeatLegend.OCCUPIED;
  }
}
