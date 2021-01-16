package adventofcode.day05;

public class SeatFinder {

  private static int MAX_ROWS = 128;
  private static int MAX_COLUMNS = 8;

  public static int findRowNumber(String string) {
    return binaryFinder(string.replace('F', 'd').replace('B', 'u'), MAX_ROWS);
  }

  public static int findColumnNumber(String string) {
    return binaryFinder(string.replace('L', 'd').replace('R', 'u'), MAX_COLUMNS);
  }

  private static int binaryFinder(String string, int max) {
    int min = 0;

    for (char direction : string.toCharArray()) {
      int offset = (int) Math.ceil((max - min) / 2.0);
      if (direction == 'd') {
        max -= offset;
      }
      else if (direction == 'u') {
        min += offset;
      }
    }

    return min;
  }
}
