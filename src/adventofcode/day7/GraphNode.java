package adventofcode.day7;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
  private String color;
  private Set<GraphNode> neighbors;

  public GraphNode(String color) {
    this.color = color;
    this.neighbors = new HashSet<GraphNode>();
  }

  @Override
  public boolean equals(Object obj) {
    var other = (GraphNode) obj;
    return this.color == other.color;
  }

  public String getColor() {
    return this.color;
  }

  public void addNeighbor(GraphNode node) {
    this.neighbors.add(node);
  }

  public Set<GraphNode> getNeighbors() {
    return this.neighbors;
  }
}