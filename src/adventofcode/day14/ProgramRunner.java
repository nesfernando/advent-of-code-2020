package adventofcode.day14;

import java.util.List;

public class ProgramRunner {

  public static long sumOfValues(List<String> lines) {

    var decoder = new Decoder();

    for (String line : lines) {
      var executor = InstructionParser.parse(line);
      executor.execute(decoder);
    }

    return decoder.getValues().stream().mapToLong(Long::valueOf).sum();
  }
}
