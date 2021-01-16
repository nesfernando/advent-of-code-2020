package adventofcode.day9;

import java.util.List;

public class Solution {
  public static long findFirstWithoutComplement(List<Long> numbers, int preamble) {
    var window = new SlidingWindow(numbers, preamble);

    while (window.hasNextAfterWindowEdge()) {
      var target = window.getNextAfterWindowEdge();
      if (!SumComplementFinder.hasComplementingPair(window.getWindow(), target)) {
        return target;
      }
      window.slide();
    }

    throw new IllegalArgumentException("Input does not have a target with complement: " + numbers);
  }
}
