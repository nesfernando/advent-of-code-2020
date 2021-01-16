package adventofcode.day06;

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
        "Sum of number of questions to which anyone answered \"yes\": "
            + dataGroups.stream().mapToInt(line -> CustomsDataParser.makeUnion(line).size()).sum());

    System.out.println(
        "Sum of number of questions to which everyone answered \"yes\": "
            + dataGroups.stream().mapToInt(line -> CustomsDataParser.makeIntersection(line).size()).sum());
  }
}
