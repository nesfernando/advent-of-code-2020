package adventofcode.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class PassportProcessing {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    var dataBatch = BatchDataParser.parse(lines);

    // part 1
    System.out.println("Number of valid passports: " + getCountOfValidPassportssByMissingFields(dataBatch));

  }

  private static int getCountOfValidPassportssByMissingFields(List<Map<String, String>> dataBatch) {
    int countValidPassports = 0;

    for (Map<String, String> passportData : dataBatch) {
      if (PassportFieldCountValidator.validate(passportData)) {
        countValidPassports++;
      }
    }
    return countValidPassports;
  }
}
