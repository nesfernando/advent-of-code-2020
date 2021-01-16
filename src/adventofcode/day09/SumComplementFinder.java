package adventofcode.day09;

import java.util.HashSet;
import java.util.List;

public class SumComplementFinder {

  public static boolean hasComplementingPair(List<Long> numbers, long target) {
    var set = new HashSet<Long>();
    numbers.stream().forEach(n -> set.add(n));

    return set.stream().filter(x -> set.contains(target - x)).findAny().isPresent();
  }
}
