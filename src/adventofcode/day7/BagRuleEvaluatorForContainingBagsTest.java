package adventofcode.day7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BagRuleEvaluatorForContainingBagsTest {

  @Test
  void singeRule() {
    var rule = new BagRuleParser("light red bags contain 1 bright white bag, 2 muted yellow bags.");

    var graph = new BagRuleEvaluatorForContainingBags();
    graph.addRule(rule);

    assertTrue(graph.getContainingBagColors("bright white").contains("light red"));
    assertTrue(graph.getContainingBagColors("muted yellow").contains("light red"));
  }

  @Test
  void twoRules() {
    var rule1 = new BagRuleParser("light red bags contain 1 bright white bag.");
    var rule2 = new BagRuleParser("muted yellow bags contain 1 bright white bag.");

    var graph = new BagRuleEvaluatorForContainingBags();
    graph.addRule(rule1);
    graph.addRule(rule2);

    var containingBagColors = graph.getContainingBagColors("bright white");
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

    var graph = new BagRuleEvaluatorForContainingBags();
    graph.addRule(rule1);
    graph.addRule(rule2);
    graph.addRule(rule3);
    graph.addRule(rule4);
    graph.addRule(rule5);
    graph.addRule(rule6);
    graph.addRule(rule7);

    var containingBagColors = graph.getRecursivelyContainingBagColors("shiny gold");
    assertTrue(containingBagColors.contains("light red"));
    assertTrue(containingBagColors.contains("bright white"));
    assertTrue(containingBagColors.contains("muted yellow"));
    assertTrue(containingBagColors.contains("dark orange"));
  }
}
