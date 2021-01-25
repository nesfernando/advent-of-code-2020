package adventofcode.day16;

import java.util.List;
import java.util.Map;

public class Solution {

  public static int partOne(List<String> lines) {
    var sampler = getSamplerInstance();

    for (var line : lines) {
      sampler.takeSample(line);
    }

    return sampler.getErrorRate();
  }

  public static Map<String, Integer> partTwo(List<String> lines) {
    var sampler = getSamplerInstance();

    for (var line : lines) {
      sampler.takeSample(line);
    }

    return sampler.getRuleNameToFieldNumberMapping();
  }

  private static TicketErrorSampler getSamplerInstance() {
    var rules = List.of(
        Rule.parse("departure location: 27-180 or 187-953"), Rule.parse("departure station: 47-527 or 545-958"),
        Rule.parse("departure platform: 36-566 or 572-973"), Rule.parse("departure track: 37-497 or 505-971"),
        Rule.parse("departure date: 47-707 or 719-969"), Rule.parse("departure time: 36-275 or 290-949"),
        Rule.parse("arrival location: 31-855 or 864-955"), Rule.parse("arrival station: 50-148 or 158-949"),
        Rule.parse("arrival platform: 50-441 or 467-965"), Rule.parse("arrival track: 30-648 or 659-962"),
        Rule.parse("class: 26-470 or 481-966"), Rule.parse("duration: 27-808 or 818-958"),
        Rule.parse("price: 49-769 or 784-970"), Rule.parse("route: 49-796 or 809-964"),
        Rule.parse("row: 42-362 or 383-971"), Rule.parse("seat: 34-877 or 887-952"),
        Rule.parse("train: 31-354 or 363-950"), Rule.parse("type: 39-208 or 231-953"),
        Rule.parse("wagon: 47-736 or 746-968"), Rule.parse("zone: 44-290 or 310-974"));

    return new TicketErrorSampler(rules);
  }
}
