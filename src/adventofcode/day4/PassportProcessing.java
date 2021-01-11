package adventofcode.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import adventofcode.util.BatchDataParser;

public class PassportProcessing {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    var dataGroups = BatchDataParser.parseGroups(lines);

    System.out.println(
        "Number of valid passports, by field count: "
            + dataGroups.stream().map(PassportDataParser::parse).filter(PassportFieldCountValidator::validate).count());

    System.out.println(
        "Number of valid passports, by field value validity: "
            + dataGroups.stream().map(PassportDataParser::parse).filter(PassportFieldDataValidator::validate).count());
  }
}
