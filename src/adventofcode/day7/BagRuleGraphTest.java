package adventofcode.day7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BagRuleGraphTest {

  @Test
  void singeRule() {
    var rule = new BagRuleParser("light red bags contain 1 bright white bag, 2 muted yellow bags.");

    var graph = new BagRuleGraph();
    graph.addRule(rule);

    assertTrue(graph.getContainingBagColors("bright white").contains("light red"));
    assertTrue(graph.getContainingBagColors("muted yellow").contains("light red"));
  }

  @Test
  void twoRules() {
    var rule1 = new BagRuleParser("light red bags contain 1 bright white bag.");
    var rule2 = new BagRuleParser("muted yellow bags contain 1 bright white bag.");

    var graph = new BagRuleGraph();
    graph.addRule(rule1);
    graph.addRule(rule2);

    var containingBagColors = graph.getContainingBagColors("bright white");
    assertTrue(containingBagColors.contains("light red"));
    assertTrue(containingBagColors.contains("muted yellow"));
  }
}
