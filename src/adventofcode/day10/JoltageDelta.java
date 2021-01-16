package adventofcode.day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoltageDelta {

  // should we assume that the input is sorted?
  public static Map<Integer, Integer> deltaDistributions(List<Integer> joltages) {
    if (joltages.size() < 2) {
      throw new IllegalArgumentException("List of joltages must have at least two elements");
    }

    var map = new HashMap<Integer, Integer>();

    var iterator = joltages.iterator();
    var first = iterator.next();

    // is there a functional equivalent of this?
    do {
      var second = iterator.next();
      var delta = second - first;

      map.put(delta, map.getOrDefault(delta, 0) + 1);

      first = second;
    }
    while (iterator.hasNext());

    return map;
  }
}
