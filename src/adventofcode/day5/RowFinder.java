package adventofcode.day5;

public class RowFinder {

  private static int MAX_ROWS = 128;

  public static int findRowNumber(String string) {
    int min = 0;
    int max = MAX_ROWS;

    for (char direction : string.toCharArray()) {
      int offset = (int) Math.ceil((max - min) / 2.0);
      if (direction == 'F') {
        max -= offset;
      }
      else if (direction == 'B') {
        min += offset;
      }
    }

    return min;
  }

}
