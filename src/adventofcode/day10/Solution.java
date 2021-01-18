package adventofcode.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public static int productOfOneJoltAndThreeJoltDistributions(List<Integer> joltages) {
    var sortedJoltages = sortAndPrepWithWallAndDevice(joltages);

    var joltageDelta = JoltageDelta.deltaDistributions(sortedJoltages);

    return joltageDelta.get(1) * joltageDelta.get(3);
  }

  public static int countDistinctAdapterArrangements(List<Integer> joltages) {
    var sortedJoltages = sortAndPrepWithWallAndDevice(joltages);

    return countDistinctAdapterArrangementsImpl(sortedJoltages) + 1;
  }

  private static int countDistinctAdapterArrangementsImpl(List<Integer> joltages) {
    // base case
    if (joltages.size() < 3) {
      return 0;
    }

    var first = joltages.get(0);
    var third = joltages.get(2);

    // can't remove the middle, so recurse the remainder
    if (third - first > 3) {
      return countDistinctAdapterArrangementsImpl(suffixWithMiddleAdapter(joltages));
    }

    // else, the middle adapter can be removed, we count this arrangement, and we
    // recurse the remainder with and without it
    return 1 + countDistinctAdapterArrangementsImpl(suffixWithMiddleAdapter(joltages))
        + countDistinctAdapterArrangementsImpl(suffixWithoutMiddleAdapter(joltages));
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
