package adventofcode.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private static Map<List<Integer>, Long> memo = new HashMap<List<Integer>, Long>();

  public static int productOfOneJoltAndThreeJoltDistributions(List<Integer> joltages) {
    var sortedJoltages = sortAndPrepWithWallAndDevice(joltages);

    var joltageDelta = JoltageDelta.deltaDistributions(sortedJoltages);

    return joltageDelta.get(1) * joltageDelta.get(3);
  }

  public static long countDistinctAdapterArrangements(List<Integer> joltages) {
    var sortedJoltages = sortAndPrepWithWallAndDevice(joltages);

    return countDistinctAdapterArrangementsImpl(sortedJoltages) + 1;
  }

  private static long countDistinctAdapterArrangementsImpl(List<Integer> joltages) {
    // base case
    if (joltages.size() < 3) {
      return 0;
    }

    if (memo.containsKey(joltages)) {
      return memo.get(joltages);
    }

    var first = joltages.get(0);
    var third = joltages.get(2);

    // can't remove the middle, so recurse the remainder
    if (third - first > 3) {
      var count = countDistinctAdapterArrangementsImpl(suffixWithMiddleAdapter(joltages));
      memo.put(joltages, count);
      return count;
    }

    // else, the middle adapter can be removed, we count this arrangement, and we
    // recurse the remainder with and without it
    var count = 1 + countDistinctAdapterArrangementsImpl(suffixWithMiddleAdapter(joltages))
        + countDistinctAdapterArrangementsImpl(suffixWithoutMiddleAdapter(joltages));
    memo.put(joltages, count);
    return count;
  }

  private static List<Integer> suffixWithMiddleAdapter(List<Integer> joltages) {
    // FIXME: this is inefficient. consider starting from the right end
    var copy = new ArrayList<>(joltages);
    copy.remove(0);
    return copy;
  }

  private static List<Integer> suffixWithoutMiddleAdapter(List<Integer> joltages) {
    var copy = new ArrayList<>(joltages);
    copy.remove(1);
    return copy;
  }

  private static ArrayList<Integer> sortAndPrepWithWallAndDevice(List<Integer> joltages) {
    var sortedJoltages = new ArrayList<>(joltages);

    var max = Collections.max(sortedJoltages);
    sortedJoltages.add(0); // wall socket
    sortedJoltages.add(max + 3); // our device
    Collections.sort(sortedJoltages);
    return sortedJoltages;
  }

}
