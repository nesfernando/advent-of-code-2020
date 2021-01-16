package adventofcode.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class EncodingError {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    List<Long> numbers = lines.stream().map(Long::parseLong).collect(Collectors.toList());

    System.out.println("First without complement: " + Solution.findFirstWithoutComplement(numbers, 25));
  }
}