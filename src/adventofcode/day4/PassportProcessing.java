package adventofcode.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PassportProcessing {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    var dataBatch = BatchDataParser.parse(lines);

    System.out.println(
        "Number of valid passports, by field count: "
            + dataBatch.stream().filter(PassportFieldCountValidator::validate).count());

    System.out.println(
        "Number of valid passports, by field value validity: "
            + dataBatch.stream().filter(PassportFieldDataValidator::validate).count());
  }
}
