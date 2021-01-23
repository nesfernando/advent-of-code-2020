package adventofcode.day14;

import java.util.regex.Pattern;

public class InstructionParser {

  public static DecoderCommandExecutor parse(String instruction) {
    if (instruction.startsWith("mask")) {
      return createMaskCommandExecutor(instruction);
    }
    else if (instruction.startsWith("mem")) {
      return createMemorySetCommandExecutor(instruction);
    }
    else {
      throw new IllegalArgumentException("Unknown instruction: " + instruction);
    }
  }

  private static DecoderCommandExecutor createMaskCommandExecutor(String instruction) {
    var mask = instruction.split(" = ")[1];
    return new MaskCommandExecutor(mask);
  }

  private static DecoderCommandExecutor createMemorySetCommandExecutor(String instruction) {
    // mem[40190] = 23031023
    var pattern = Pattern.compile("mem\\[(\\d+)\\] = (\\d+)");
    var matcher = pattern.matcher(instruction);

    if (!matcher.matches()) {
      throw new IllegalArgumentException("Unknown memory set instruction: " + instruction);
    }

    var address = Long.parseLong(matcher.group(1));
    var value = Long.parseLong(matcher.group(2));

    return new MemorySetCommandExecutor(address, value);
  }
}
