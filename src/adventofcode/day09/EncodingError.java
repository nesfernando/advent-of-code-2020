package adventofcode.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class EncodingError {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    List<Long> numbers = lines.stream().map(Long::parseLong).collect(Collectors.toList());

    long target = Solution.findFirstWithoutComplement(numbers, 25);
    System.out.println("First without complement: " + target);

    System.out.println("Sum of min / max of range that sum to target: " + Solution.partTwo(numbers, target));
  }
}
