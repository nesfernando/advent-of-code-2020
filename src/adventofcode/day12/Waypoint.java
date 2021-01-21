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

  Deque<Quadrant> quadrants = new LinkedList<Quadrant>();

  private int longitudinalValue;
  private int latitudinalValue;

  public Waypoint() {
    longitudinalValue = 10;
    latitudinalValue = 1;

    quadrants.addLast(Quadrant.ALPHA);
    quadrants.addLast(Quadrant.BETA);
    quadrants.addLast(Quadrant.GAMMA);
    quadrants.addLast(Quadrant.DELTA);
  }

  public void rotateRight(int degrees) {
    var directionShift = degrees / 90;

    for (int i = 0; i < directionShift; i++) {
      rotateQuadrantRight();
      swapMagnitudes();
    }

    orientPositions();
  }

  public void rotateLeft(int degrees) {
    var directionShift = degrees / 90;

    for (int i = 0; i < directionShift; i++) {
      rotateQuadrantLeft();
      swapMagnitudes();
    }

    orientPositions();
  }

  private void rotateQuadrantRight() {
    var direction = quadrants.removeFirst();
    quadrants.addLast(direction);
  }

  private void rotateQuadrantLeft() {
    var direction = quadrants.removeLast();
    quadrants.addFirst(direction);
  }

  private void swapMagnitudes() {
    var temp = longitudinalValue;
    longitudinalValue = latitudinalValue;
    latitudinalValue = temp;
  }

  private void orientPositions() {
    var quadrant = quadrants.peekFirst();
    longitudinalValue = Math.abs(longitudinalValue) * quadrant.xSign;
    latitudinalValue = Math.abs(latitudinalValue) * quadrant.ySign;
  }

  private void orientQuadrant() {
    var quadrant = Quadrant.DELTA;

    if (longitudinalValue > 0 && latitudinalValue > 0) {
      quadrant = Quadrant.ALPHA;
    }
    else if (longitudinalValue > 0 && latitudinalValue < 0) {
      quadrant = Quadrant.BETA;
    }
    else if (longitudinalValue < 0 && latitudinalValue < 0) {
      quadrant = Quadrant.GAMMA;
    }

    while (!quadrants.peekFirst().equals(quadrant)) {
      rotateQuadrantRight();
    }
  }

  public void moveNorth(int value) {
    latitudinalValue += value;
    orientQuadrant();
  }

  public void moveSouth(int value) {
    latitudinalValue -= value;
    orientQuadrant();
  }

  public void moveEast(int value) {
    longitudinalValue += value;
    orientQuadrant();
  }

  public void moveWest(int value) {
    longitudinalValue -= value;
    orientQuadrant();
  }

  public int getLongitudinalValue() {
    return longitudinalValue;
  }

  public int getLatitudinalValue() {
    return latitudinalValue;
  }

}
