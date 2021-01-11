package adventofcode.day7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class BagRuleGraph {

  private Map<String, Node> nodes;

  private static class Node {
    private String color;
    private Set<Node> neighbors;

    public Node(String color) {
      this.color = color;
      this.neighbors = new HashSet<Node>();
    }

    @Override
    public boolean equals(Object obj) {
      var other = (Node) obj;
      return this.color == other.color;
    }

    public String getColor() {
      return this.color;
    }

    public void addNeighbor(Node node) {
      this.neighbors.add(node);
    }

    public Set<Node> getNeighbors() {
      return this.neighbors;
    }
  }

  public BagRuleGraph() {
    this.nodes = new HashMap<String, Node>();
  }

  public void addRule(BagRuleParser rule) {
    for (var content : rule.getContents()) {
      var color = parseColorFromContent(content);

      var node = getNode(color);
      var containedBy = getNode(rule.getColor());

      node.addNeighbor(containedBy);

      nodes.put(color, node);
      nodes.put(rule.getColor(), containedBy);
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
    var visitedNodes = new HashSet<Node>();
    var queue = new LinkedList<Node>();
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

  private Node getNode(String color) {
    return nodes.getOrDefault(color, new Node(color));
  }

  // "2 muted yellow"
  private static String parseColorFromContent(String content) {
    return content.split("\\d+ ")[1];
  }
}
