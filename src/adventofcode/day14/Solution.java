package adventofcode.day14;

import java.util.List;

public class Solution {

  public static long partOne(List<String> lines) {
    return executeUsingDecoder(lines, new ValueMaskingDecoder());
  }

  public static long partTwo(List<String> lines) {
    return executeUsingDecoder(lines, new AddressMaskingDecoder());
  }

  private static long executeUsingDecoder(List<String> lines, Decoder decoder) {
    for (String line : lines) {
      var command = InstructionParser.parse(line);
      command.execute(decoder);
    }

    return decoder.getValues().stream().mapToLong(Long::valueOf).sum();
  }
}
