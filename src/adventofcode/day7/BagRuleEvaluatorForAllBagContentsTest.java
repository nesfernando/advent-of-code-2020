package adventofcode.day7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BagRuleEvaluatorForAllBagContentsTest {

  @Test
  void singleRule() {
    var rule1 = new BagRuleParser("shiny gold bags contain 2 dark red bags.");

    var evaluator = new BagRuleEvaluatorForAllBagContents();
    evaluator.addRule(rule1);

    assertEquals(2, evaluator.getTotalRecursiveBagCount("shiny gold"));
  }
}
