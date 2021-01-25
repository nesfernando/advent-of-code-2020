package adventofcode.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TicketErrorSampler {

  private List<Rule> rules;

  // are invalid values unique?
  private List<Integer> invalidValues = new ArrayList<Integer>();

  public TicketErrorSampler(List<Rule> rules) {
    this.rules = rules;
  }

  public void takeSample(String ticketStr) {
    var ticketFields = getTicketFieldsInts(ticketStr);

    for (var ticketField : ticketFields) {
      var failedAllRules = true;
      for (var rule : rules) {
        if (rule.valueIsWithinOneRange(ticketField)) {
          failedAllRules = false;
        }
      }

      if (failedAllRules) {
        invalidValues.add(ticketField);
      }
    }
  }

  private static List<Integer> getTicketFieldsInts(String ticketStr) {
    return Arrays.stream(ticketStr.split(",")).map(Integer::parseInt).collect(Collectors.toList());
  }

  public int getErrorRate() {
    return invalidValues.stream().mapToInt(Integer::valueOf).sum();
  }

}
