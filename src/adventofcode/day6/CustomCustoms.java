package adventofcode.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import adventofcode.util.BatchDataParser;

public class CustomCustoms {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    var dataGroups = BatchDataParser.parseGroups(lines);

    System.out.println(
        "Sum of set sizes of group questions: "
            + dataGroups.stream().mapToInt(line -> CustomsDataParser.makeUnion(line).size()).sum());
  }
}
