package adventofcode.day12;

import java.util.Deque;
import java.util.LinkedList;

public class WaypointHelm {

  private enum Quadrant {
    ALPHA(1, 1), BETA(1, -1), GAMMA(-1, -1), DELTA(-1, 1);

    public final int xSign;
    public final int ySign;

    Quadrant(int xSign, int ySign) {
      this.xSign = xSign;
      this.ySign = ySign;
    }
  }

  private Deque<Quadrant> deque = new LinkedList<Quadrant>();

  private int longitudinalMagnitude = 0;
  private int latitudinalMagnitude = 0;

  public WaypointHelm() {
    this.longitudinalMagnitude = 10;
    this.latitudinalMagnitude = 1;

    this.deque.add(Quadrant.ALPHA);
    this.deque.add(Quadrant.BETA);
    this.deque.add(Quadrant.GAMMA);
    this.deque.add(Quadrant.DELTA);
  }

  public void steerRight(int degrees) {
    var directionShift = degrees / 90;

    for (int i = 0; i < directionShift; i++) {
      var direction = deque.removeFirst();
      deque.addLast(direction);
      swapMagnitudes();
    }
  }

  public void steerLeft(int degrees) {
    var directionShift = degrees / 90;

    for (int i = 0; i < directionShift; i++) {
      var direction = deque.removeLast();
      deque.addFirst(direction);
      swapMagnitudes();
    }
  }

  public int getLongtitudinalValue() {
    return deque.getFirst().xSign * longitudinalMagnitude;
  }

  public int getLatitudinalValue() {
    return deque.getFirst().ySign * latitudinalMagnitude;
  }

  private void swapMagnitudes() {
    var temp = longitudinalMagnitude;
    longitudinalMagnitude = latitudinalMagnitude;
    latitudinalMagnitude = temp;
  }
}
