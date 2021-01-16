package adventofcode.day07;

import java.util.HashMap;
import java.util.Map;

public class BagRuleEvaluatorForAllBagContents {

  private Map<String, GraphNode> nodes;

  public BagRuleEvaluatorForAllBagContents() {
    this.nodes = new HashMap<String, GraphNode>();
  }

  public void addRule(BagRuleParser rule) {
    var container = getNode(rule.getColor());
    nodes.put(rule.getColor(), container);

    for (var content : rule.getContents()) {
      var color = BagRuleParser.parseColorFromContent(content);
      var count = BagRuleParser.parseCountFromContent(content);

      var node = new GraphNode(color, count);

      container.addNeighbor(node);
    }
  }

  private GraphNode getNode(String color) {
    return nodes.getOrDefault(color, new GraphNode(color));
  }

  public int getTotalRecursiveBagCount(String bagColor) {
    var node = getNode(bagColor);

    return getCount(node, 1) - 1; // don't count myself
  }

  private int getCount(GraphNode node, int countOfThisBag) {
    int count = 0;

    for (var neighbor : node.getNeighbors()) {
      count += getCount(getNode(neighbor.getColor()), neighbor.getCount());
    }

    return countOfThisBag * count + countOfThisBag;
  }
}
