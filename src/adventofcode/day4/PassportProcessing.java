package adventofcode.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class PassportProcessing {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    var dataBatch = BatchPassportData.parse(lines);

    int countValidPassports = 0;

    for (Map<String, String> passportData : dataBatch) {
      if (PassportDataValidator.isValid(passportData)) {
        countValidPassports++;
      }
    }

    System.out.println("Number of valid passports: " + countValidPassports);
  }
}
