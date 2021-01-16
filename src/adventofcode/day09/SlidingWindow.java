package adventofcode.day09;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {

  private int lowEdge = 0; // inclusive
  private int highEdge = 0; // not inclusive of the edge

  private List<Long> numbers;

  public SlidingWindow(List<Long> numbers, int width) {
    this.highEdge = width;
    this.numbers = numbers;
  }

  public List<Long> getRange() {
    return new ArrayList<Long>(numbers.subList(lowEdge, highEdge));
  }

  public boolean canSlide() {
    return highEdge < numbers.size();
  }

  public void slide() {
    lowEdge++;
    highEdge++;
  }

  public long getNextAfterWindowEdge() {
    return numbers.get(highEdge);
  }
}
