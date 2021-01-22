package adventofcode.day14;

public class Mask {

  private static final char X = 'X';
  private static final char ZERO = '0';
  private static final char ONE = '1';

  public static String apply(String mask, String value) {
    StringBuffer buffer = new StringBuffer(36);

    for (int i = 0; i < mask.length(); i++) {
      char m = mask.charAt(i);
      char c = value.charAt(i);

      if (m == X) {
        buffer.append(c);
      }
      else if (m == ZERO || m == ONE) {
        buffer.append(m);
      }
      else {
        throw new IllegalArgumentException("Unknown bit: " + m);
      }
    }

    return buffer.toString();
  }
}
