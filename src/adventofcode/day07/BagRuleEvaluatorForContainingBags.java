package adventofcode.day07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class BagRuleEvaluatorForContainingBags {

  private Map<String, GraphNode> nodes;

  public BagRuleEvaluatorForContainingBags() {
    this.nodes = new HashMap<String, GraphNode>();
  }

  public void addRule(BagRuleParser rule) {
    var containedBy = getNode(rule.getColor());
    nodes.put(rule.getColor(), containedBy);

    for (var content : rule.getContents()) {
      var color = BagRuleParser.parseColorFromContent(content);

      var node = getNode(color);

      node.addNeighbor(containedBy);
      nodes.put(color, node);
    }
  }

  public Set<String> getContainingBagColors(String bagColor) {
    var node = nodes.get(bagColor);
    var colors = new HashSet<String>();
    node.getNeighbors().forEach(n -> colors.add(n.getColor()));
    return colors;
  }

  // BFS
  public Set<String> getRecursivelyContainingBagColors(String bagColor) {

    var containingNodeColors = new HashSet<String>();
    var visitedNodes = new HashSet<GraphNode>();
    var queue = new LinkedList<GraphNode>();
    var node = getNode(bagColor);

    visitedNodes.add(node);
    queue.add(node);

    while (!queue.isEmpty()) {
      var current = queue.poll();

      for (var neighbor : current.getNeighbors()) {
        containingNodeColors.add(neighbor.getColor());
        if (!visitedNodes.contains(neighbor)) {
          visitedNodes.add(neighbor);
          queue.add(neighbor);
        }
      }
    }

    return containingNodeColors;
  }

  private GraphNode getNode(String color) {
    return nodes.getOrDefault(color, new GraphNode(color));
  }
}
