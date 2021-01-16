package adventofcode.day9;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  public static long findFirstWithoutComplement(List<Long> numbers, int preamble) {
    var window = new SlidingWindow(numbers, preamble);

    while (window.canSlide()) {
      var target = window.getNextAfterWindowEdge();
      if (!SumComplementFinder.hasComplementingPair(window.getRange(), target)) {
        return target;
      }
      window.slide();
    }

    throw new IllegalArgumentException("Input does not have a target with complement: " + numbers);
  }

  public static long partTwo(List<Long> numbers, long target) {
    var windowWidth = 2; // starts with two consecutive numbers
    var maxWindowWidth = numbers.size();

    while (windowWidth < maxWindowWidth) {
      var window = new SlidingWindow(numbers, windowWidth);

      while (window.canSlide()) {

        // this... is amazing
        var stats = window.getRange().stream().collect(Collectors.summarizingLong(Long::longValue));

        if (stats.getSum() == target) {
          return stats.getMin() + stats.getMax();
        }

        window.slide();
      }

      windowWidth++;
    }

    throw new IllegalArgumentException("Input does not have a range that sum to target: " + numbers);
  }
}
