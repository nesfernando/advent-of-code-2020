package adventofcode.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RainRisk {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    System.out.println(
        "What is the Manhattan distance between that location and the ship's starting position? "
            + Solution.partOne(lines));
  }
}
