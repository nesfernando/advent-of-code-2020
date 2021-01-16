package adventofcode.day9;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {

  private int lowEdge = 0; // inclusive
  private int highEdge = 0; // not inclusive of the edge

  private List<Long> numbers;

  public SlidingWindow(List<Long> numbers, int preamble) {
    this.highEdge = preamble;
    this.numbers = numbers;
  }

  public List<Long> getWindow() {
    return new ArrayList<Long>(numbers.subList(lowEdge, highEdge));
  }

  public boolean hasNextAfterWindowEdge() {
    return highEdge < numbers.size();
  }

  public long getNextAfterWindowEdge() {
    return numbers.get(highEdge);
  }
  
  public void slide() {
    lowEdge++;
    highEdge++;
  }
}