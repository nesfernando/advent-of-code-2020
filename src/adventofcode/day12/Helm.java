package adventofcode.day12;

import java.util.Deque;
import java.util.LinkedList;

public class Helm {

  private Deque<Direction> deque = new LinkedList<Direction>();

  public Helm() {
    deque.addLast(Direction.EAST); // start facing east
    deque.addLast(Direction.SOUTH);
    deque.addLast(Direction.WEST);
    deque.addLast(Direction.NORTH);
  }

  public void steerRight(int degrees) {
    var directionShift = degrees / 90;

    for (int i = 0; i < directionShift; i++) {
      var direction = deque.removeFirst();
      deque.addLast(direction);
    }
  }

  public void steerLeft(int degrees) {
    var directionShift = degrees / 90;

    for (int i = 0; i < directionShift; i++) {
      var direction = deque.removeLast();
      deque.addFirst(direction);
    }
  }

  public Direction getDirection() {
    return deque.getFirst();
  }

}
