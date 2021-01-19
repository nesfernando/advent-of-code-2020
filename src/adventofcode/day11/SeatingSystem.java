package adventofcode.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SeatingSystem {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    System.out.println(
        "After applying rules repeatedly until no seats change, how many seats end up occupied? "
            + Solution.partOne(lines));

    System.out.println("With line-of-sight occupied seat counting and increased threshold: " + Solution.partTwo(lines));
  }
}
