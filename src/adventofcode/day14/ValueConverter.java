package adventofcode.day14;

import java.math.BigInteger;

public class ValueConverter {

  public static String decimalToBinaryString(long decimal) {
    return String.format("%36s", Long.toBinaryString(decimal)).replace(" ", "0");
  }

  public static long binaryStringToDecimal(String binaryString) {
    return new BigInteger(binaryString, 2).longValue();
  }
}
