package adventofcode.day14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddressMask {
  private static final char X = 'X';
  private static final char ZERO = '0';
  private static final char ONE = '1';

  public static Set<String> apply(String mask, String address) {

    if (mask.indexOf(X) < 0) {
      throw new IllegalArgumentException("Mask does not have a floating bit: " + mask);
    }

    var maskIndices = new ArrayList<Integer>();

    for (int i = 0; i < mask.length(); i++) {
      if (mask.charAt(i) != X) {
        continue;
      }

      maskIndices.add(i);
    }

    var addressWithFloatingBits = applyMask(mask, address);

    return replaceFloatingBits(maskIndices, addressWithFloatingBits);
  }

  private static Set<String> replaceFloatingBits(List<Integer> maskIndices, String addressWithFloatingBits) {

    var size = (int) Math.pow(2, maskIndices.size());
    var addresses = new ArrayList<StringBuffer>(size); // is this big enough?

    for (int i = 0; i < size; i++) {
      addresses.add(new StringBuffer(addressWithFloatingBits));
    }

    for (int i = 0; i < size; i++) {
      var bitMaskString = paddedBinaryString(maskIndices.size(), i);

      var buffer = addresses.get(i);
      for (int j = 0; j < maskIndices.size(); j++) {
        var mask = bitMaskString.charAt(j);
        buffer.setCharAt(maskIndices.get(j), mask);
      }
    }

    var set = new HashSet<String>();
    addresses.forEach(address -> set.add(address.toString()));
    return set;
  }

  private static String paddedBinaryString(int length, int number) {
    var buffer = new StringBuffer(length);

    var binaryString = Integer.toBinaryString(number);

    for (int i = 0; i < length - binaryString.length(); i++) {
      buffer.append('0');
    }

    buffer.append(binaryString);

    return buffer.toString();
  }

  private static String applyMask(String mask, String address) {
    StringBuffer buffer = new StringBuffer(36);

    for (int i = 0; i < mask.length(); i++) {
      char m = mask.charAt(i);
      char c = address.charAt(i);

      if (m == ZERO) {
        buffer.append(c);
      }
      else if (m == ONE || m == X) {
        buffer.append(m);
      }
      else {
        throw new IllegalArgumentException("Unknown bit: " + m);
      }
    }

    return buffer.toString();
  }
}
