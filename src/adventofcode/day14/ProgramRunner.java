package adventofcode.day14;

import java.util.List;

public class ProgramRunner {

  public static long sumOfValues(List<String> lines) {

    var computer = new Computer();

    for (String line : lines) {
      var executor = InstructionParser.parse(line);
      executor.execute(computer);
    }

    return computer.getValues().stream().mapToLong(Long::valueOf).sum();
  }
}
