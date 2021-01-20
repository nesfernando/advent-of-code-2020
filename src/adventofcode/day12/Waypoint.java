package adventofcode.day12;

import java.util.Deque;
import java.util.LinkedList;

public class Waypoint {

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

  public Waypoint() {
    this.longitudinalMagnitude = 10;
    this.latitudinalMagnitude = 1;

    this.deque.add(Quadrant.ALPHA);
    this.deque.add(Quadrant.BETA);
    this.deque.add(Quadrant.GAMMA);
    this.deque.add(Quadrant.DELTA);
  }

  public void rotateRight(int degrees) {
    var directionShift = degrees / 90;

    for (int i = 0; i < directionShift; i++) {
      rotateQuadrantRight();
      swapMagnitudes();
    }
  }

  private void rotateQuadrantRight() {
    var direction = deque.removeFirst();
    deque.addLast(direction);
  }

  public void rotateLeft(int degrees) {
    var directionShift = degrees / 90;

    for (int i = 0; i < directionShift; i++) {
      rotateQuadrantLeft();
      swapMagnitudes();
    }
  }

  private void rotateQuadrantLeft() {
    var direction = deque.removeLast();
    deque.addFirst(direction);
  }

  public int getLongitudinalValue() {
    return deque.getFirst().xSign * longitudinalMagnitude;
  }

  public int getLatitudinalValue() {
    return deque.getFirst().ySign * latitudinalMagnitude;
  }

  public void moveNorth(int value) {
    var delta = getLatitudinalValue() + value;

    var isQuadrantShift = getLatitudinalValue() < 0 && delta >= 0;
    if (isQuadrantShift) {
      if (inBetaQuadrant()) {
        rotateQuadrantLeft();
      }
      else if (inGammaQuadrant()) {
        rotateQuadrantRight();
      }
    }

    latitudinalMagnitude = Math.abs(delta);
  }

  public void moveSouth(int value) {
    var delta = getLatitudinalValue() - value;

    var isQuadrantShift = getLatitudinalValue() > 0 && delta < 0;
    if (isQuadrantShift) {
      if (inDeltaQuadrant()) {
        rotateQuadrantLeft();
      }
      else if (inAlphaQuadrant()) {
        rotateQuadrantRight();
      }
    }

    latitudinalMagnitude = Math.abs(delta);
  }

  public void moveEast(int value) {
    var delta = getLongitudinalValue() + value;

    var isQuadrantShift = getLongitudinalValue() < 0 && delta >= 0;
    if (isQuadrantShift) {
      if (inDeltaQuadrant()) {
        rotateQuadrantRight();
      }
      else if (inGammaQuadrant()) {
        rotateQuadrantLeft();
      }
    }

    longitudinalMagnitude = Math.abs(delta);
  }

  private boolean inAlphaQuadrant() {
    return deque.getFirst().equals(Quadrant.ALPHA);
  }

  private boolean inBetaQuadrant() {
    return deque.getFirst().equals(Quadrant.BETA);
  }

  private boolean inGammaQuadrant() {
    return deque.getFirst().equals(Quadrant.GAMMA);
  }

  private boolean inDeltaQuadrant() {
    return deque.getFirst().equals(Quadrant.DELTA);
  }

  private void swapMagnitudes() {
    var temp = longitudinalMagnitude;
    longitudinalMagnitude = latitudinalMagnitude;
    latitudinalMagnitude = temp;
  }
}
