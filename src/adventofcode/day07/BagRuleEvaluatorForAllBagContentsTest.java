package adventofcode.day07;

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

  @Test
  void twoRules() {
    var rule1 = new BagRuleParser("shiny gold bags contain 2 dark red bags.");
    var rule2 = new BagRuleParser("dark red bags contain 2 dark orange bags.");

    var evaluator = new BagRuleEvaluatorForAllBagContents();
    evaluator.addRule(rule1);
    evaluator.addRule(rule2);

    assertEquals(6, evaluator.getTotalRecursiveBagCount("shiny gold"));
  }

  @Test
  void threeRules() {
    var evaluator = new BagRuleEvaluatorForAllBagContents();
    evaluator.addRule(new BagRuleParser("blue bags contain 2 green bags."));
    evaluator.addRule(new BagRuleParser("yellow bags contain 3 green bags."));
    evaluator.addRule(new BagRuleParser("green bags contain 1 red bag."));

    assertEquals(6, evaluator.getTotalRecursiveBagCount("yellow"));
    assertEquals(4, evaluator.getTotalRecursiveBagCount("blue"));
  }

  @Test
  void baseExampleFromPart1() {
    var rule1 = new BagRuleParser("light red bags contain 1 bright white bag, 2 muted yellow bags.");
    var rule2 = new BagRuleParser("dark orange bags contain 3 bright white bags, 4 muted yellow bags.");
    var rule3 = new BagRuleParser("bright white bags contain 1 shiny gold bag.");
    var rule4 = new BagRuleParser("muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.");
    var rule5 = new BagRuleParser("shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.");
    var rule6 = new BagRuleParser("dark olive bags contain 3 faded blue bags, 4 dotted black bags.");
    var rule7 = new BagRuleParser("vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.");

    var evaluator = new BagRuleEvaluatorForAllBagContents();
    evaluator.addRule(rule1);
    evaluator.addRule(rule2);
    evaluator.addRule(rule3);
    evaluator.addRule(rule4);
    evaluator.addRule(rule5);
    evaluator.addRule(rule6);
    evaluator.addRule(rule7);

    assertEquals(32, evaluator.getTotalRecursiveBagCount("shiny gold"));
  }

  @Test
  void baseExampleFromPart2() {
    var rule1 = new BagRuleParser("shiny gold bags contain 2 dark red bags.");
    var rule2 = new BagRuleParser("dark red bags contain 2 dark orange bags.");
    var rule3 = new BagRuleParser("dark orange bags contain 2 dark yellow bags.");
    var rule4 = new BagRuleParser("dark yellow bags contain 2 dark green bags.");
    var rule5 = new BagRuleParser("dark green bags contain 2 dark blue bags.");
    var rule6 = new BagRuleParser("dark blue bags contain 2 dark violet bags.");

    var evaluator = new BagRuleEvaluatorForAllBagContents();
    evaluator.addRule(rule1);
    evaluator.addRule(rule2);
    evaluator.addRule(rule3);
    evaluator.addRule(rule4);
    evaluator.addRule(rule5);
    evaluator.addRule(rule6);

    assertEquals(126, evaluator.getTotalRecursiveBagCount("shiny gold"));
  }
}
