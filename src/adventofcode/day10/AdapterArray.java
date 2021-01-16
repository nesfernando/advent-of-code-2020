package adventofcode.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterArray {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    List<Integer> numbers = lines.stream().map(Integer::parseInt).collect(Collectors.toList());

    System.out.println(
        "What is the number of 1-jolt differences multiplied by the number of 3-jolt differences? "
            + Solution.partOne(numbers));
  }
}
