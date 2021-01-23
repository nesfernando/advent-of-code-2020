package adventofcode.day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DockingData {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    System.out.println("What is the sum of all values left in memory after it completes? " + Solution.partOne(lines));

    System.out.println(
        "What is the sum of all values left in memory after it completes? V2: " + Solution.partTwo(lines));
  }
}
