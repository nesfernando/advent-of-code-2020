package adventofcode.day7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BagRuleEvaluatorForContainingBagsTest {

  @Test
  void singeRule() {
    var rule = new BagRuleParser("light red bags contain 1 bright white bag, 2 muted yellow bags.");

    var evaluator = new BagRuleEvaluatorForContainingBags();
    evaluator.addRule(rule);

    assertTrue(evaluator.getContainingBagColors("bright white").contains("light red"));
    assertTrue(evaluator.getContainingBagColors("muted yellow").contains("light red"));
  }

  @Test
  void twoRules() {
    var rule1 = new BagRuleParser("light red bags contain 1 bright white bag.");
    var rule2 = new BagRuleParser("muted yellow bags contain 1 bright white bag.");

    var evaluator = new BagRuleEvaluatorForContainingBags();
    evaluator.addRule(rule1);
    evaluator.addRule(rule2);

    var containingBagColors = evaluator.getContainingBagColors("bright white");
    assertTrue(containingBagColors.contains("light red"));
    assertTrue(containingBagColors.contains("muted yellow"));
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

    var evaluator = new BagRuleEvaluatorForContainingBags();
    evaluator.addRule(rule1);
    evaluator.addRule(rule2);
    evaluator.addRule(rule3);
    evaluator.addRule(rule4);
    evaluator.addRule(rule5);
    evaluator.addRule(rule6);
    evaluator.addRule(rule7);

    var containingBagColors = evaluator.getRecursivelyContainingBagColors("shiny gold");
    assertTrue(containingBagColors.contains("light red"));
    assertTrue(containingBagColors.contains("bright white"));
    assertTrue(containingBagColors.contains("muted yellow"));
    assertTrue(containingBagColors.contains("dark orange"));
  }
}
