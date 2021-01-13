package adventofcode.day7;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
  private String color;
  private int count;
  private Set<GraphNode> neighbors = new HashSet<GraphNode>();

  public GraphNode(String color) {
    this.color = color;
  }

  public GraphNode(String color, int count) {
    this.color = color;
    this.count = count;
  }

  @Override
  public boolean equals(Object obj) {
    var other = (GraphNode) obj;
    return this.color == other.color;
  }

  public String getColor() {
    return this.color;
  }

  public int getCount() {
    return this.count;
  }

  public void addNeighbor(GraphNode node) {
    this.neighbors.add(node);
  }

  public Set<GraphNode> getNeighbors() {
    return this.neighbors;
  }
}