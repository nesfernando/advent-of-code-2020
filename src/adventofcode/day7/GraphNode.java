package adventofcode.day7;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
  private String color;
  private int count = 1; // the count of instances "my" container has of "me"
  private Set<GraphNode> neighbors = new HashSet<GraphNode>();

  public GraphNode(String color) {
    this.color = color;
  }

  public GraphNode(String color, int count) {
    this.color = color;
    this.count = count;
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

  public void setCount(int count) {
    this.count = count;
  }
}