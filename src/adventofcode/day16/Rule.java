package adventofcode.day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rule {

  private String fieldName;
  private List<ValueRange> ranges;

  public Rule(String fieldName, List<ValueRange> valueRanges) {
    this.fieldName = fieldName;
    this.ranges = valueRanges;
  }

  public boolean valueIsWithinOneRange(int value) {
    return ranges.stream().anyMatch(r -> r.inRange(value));
  }

  // departure location: 27-180 or 187-953
  public static Rule parse(String str) {
    var colonTerms = str.split(": ");

    var name = colonTerms[0];

    var orTerms = colonTerms[1].split(" or ");
    List<ValueRange> ranges = Arrays.stream(orTerms).map(s -> ValueRange.parse(s)).collect(Collectors.toList());

    return new Rule(name, ranges);
  }

}
