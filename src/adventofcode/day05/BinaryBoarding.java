package adventofcode.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BinaryBoarding {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    System.out.println("Highest seat ID: " + getHighestSeatID(lines));
  }

  private static int getHighestSeatID(List<String> lines) {
    return lines.stream().map(line -> getSeatID(line)).max(Integer::compare).get();
  }

  private static int getSeatID(String boardingString) {
    int rowNumber = SeatFinder.findRowNumber(boardingString.substring(0, 7));
    int columnNumber = SeatFinder.findColumnNumber(boardingString.substring(7, 10));

    return rowNumber * 8 + columnNumber;
  }
}
