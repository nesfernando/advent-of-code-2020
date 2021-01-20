package adventofcode.day12;

import java.util.List;

public class Solution {

  public static int partOne(List<String> lines) {
    var navigator = new Navigator();

    for (String command : lines) {
      navigator.navigate(command);
    }

    return navigator.getManhattanDistance();
  }

}
