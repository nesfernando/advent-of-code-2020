package adventofcode.day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomsDataParser {

  public static Set<Character> makeUnion(List<String> lines) {
    var set = new HashSet<Character>();

    for (var line : lines) {
      for (var c : line.toCharArray()) {
        set.add(c);
      }
    }

    return set;
  }
}
