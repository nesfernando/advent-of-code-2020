package adventofcode.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketErrorSampler {

  private List<Rule> rules;

  // are invalid values unique?
  private List<Integer> invalidValues = new ArrayList<Integer>();
  private List<List<Integer>> validTickets = new ArrayList<List<Integer>>();

  public TicketErrorSampler(List<Rule> rules) {
    this.rules = rules;
  }

  public void takeSample(String ticketStr) {
    var ticketFields = getTicketFieldsInts(ticketStr);

    var invalidValuesForTicket = new ArrayList<Integer>();

    for (var ticketField : ticketFields) {
      var fieldFailedAllRules = true;
      for (var rule : rules) {
        if (rule.valueIsWithinOneRange(ticketField)) {
          fieldFailedAllRules = false;
        }
      }

      if (fieldFailedAllRules) {
        invalidValuesForTicket.add(ticketField);
      }
    }

    invalidValues.addAll(invalidValuesForTicket);

    if (invalidValuesForTicket.isEmpty()) {
      validTickets.add(ticketFields);
    }
  }

  public Map<String, Integer> getRuleNameToFieldNumberMapping() {
    assert (!validTickets.isEmpty());

    Map<String, Integer> ruleNameToFieldNumber = new HashMap<String, Integer>();

    // assume all tickets are of the same length
    var numFields = validTickets.get(0).size();

    for (int fieldNumber = 0; fieldNumber < numFields; fieldNumber++) {
      for (var rule : rules) {
        if (ruleNameToFieldNumber.containsKey(rule.getRuleName())) {
          continue;
        }

        if (fieldValuesMeetAllTheRules(fieldNumber, rule)) {
          ruleNameToFieldNumber.put(rule.getRuleName(), fieldNumber);
          break;
        }
      }
    }

    return ruleNameToFieldNumber;
  }

  private boolean fieldValuesMeetAllTheRules(int fieldNumber, Rule rule) {
    for (var ticket : validTickets) {
      var fieldValue = ticket.get(fieldNumber);
      if (!rule.valueIsWithinOneRange(fieldValue)) {
        return false;
      }
    }

    return true;
  }

  private static List<Integer> getTicketFieldsInts(String ticketStr) {
    return Arrays.stream(ticketStr.split(",")).map(Integer::parseInt).collect(Collectors.toList());
  }

  public int getErrorRate() {
    return invalidValues.stream().mapToInt(Integer::valueOf).sum();
  }

}
