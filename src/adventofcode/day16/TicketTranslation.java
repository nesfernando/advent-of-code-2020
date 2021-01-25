package adventofcode.day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TicketTranslation {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    System.out.println("What is your ticket scanning error rate? " + Solution.partOne(lines));

    System.out.println("Rule name to field number mapping: " + Solution.partTwo(lines));
  }
}
