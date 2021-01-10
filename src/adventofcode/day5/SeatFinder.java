package adventofcode.day5;

public class SeatFinder {

  private static int MAX_ROWS = 128;

  public static int findRowNumber(String string) {
    return binaryFinder(string.replace('F', 'd').replace('B', 'u'), MAX_ROWS);
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
