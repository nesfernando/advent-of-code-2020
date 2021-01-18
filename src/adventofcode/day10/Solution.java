package adventofcode.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public static int productOfOneJoltAndThreeJoltDistributions(List<Integer> joltages) {
    var sortedJoltages = new ArrayList<>(joltages);

    var max = Collections.max(sortedJoltages);
    sortedJoltages.add(0); // wall socket
    sortedJoltages.add(max + 3); // our device
    Collections.sort(sortedJoltages);

    var joltageDelta = JoltageDelta.deltaDistributions(sortedJoltages);

    return joltageDelta.get(1) * joltageDelta.get(3);
  }
}
