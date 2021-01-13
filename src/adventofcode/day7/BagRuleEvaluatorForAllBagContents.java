package adventofcode.day7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
      nodes.put(color, node);
    }
  }

  private GraphNode getNode(String color) {
    return nodes.getOrDefault(color, new GraphNode(color));
  }

  // FIXME: this isn't a BFS problem, it's a composite recursive traversal (DFS?)
  public int getTotalRecursiveBagCount(String bagColor) {
    var totalCount = 0;
    var visitedNodes = new HashSet<GraphNode>();
    var queue = new LinkedList<GraphNode>();
    var node = getNode(bagColor);

    visitedNodes.add(node);
    queue.add(node);

    while (!queue.isEmpty()) {
      var current = queue.poll();

      for (var neighbor : current.getNeighbors()) {
        totalCount += neighbor.getCount();
        if (!visitedNodes.contains(neighbor)) {
          visitedNodes.add(neighbor);
          queue.add(neighbor);
        }
      }
    }

    return totalCount;
  }

}
