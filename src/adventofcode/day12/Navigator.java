package adventofcode.day12;

public class Navigator {

  private Helm helm = new Helm();

  private static final String FORWARD = "F";
  private static final String RIGHT = "R";
  private static final String LEFT = "R";
  private static final String NORTH = "N";
  private static final String EAST = "E";
  private static final String SOUTH = "S";
  private static final String WEST = "W";

  private int latitudinalPosition = 0;
  private int longitudinalPosition = 0;

  public Navigator() {

  }

  public void navigate(String command) {
    var action = command.substring(0, 1);
    var value = Integer.parseInt(command.substring(1));

    if (action.equals(FORWARD)) {
      doForward(value);
    }
    else if (action.equals(RIGHT)) {
      helm.steerRight(value);
    }
    else if (action.equals(LEFT)) {
      helm.steerLeft(value);
    }
    else if (action.equals(NORTH)) {
      goNorth(value);
    }
    else if (action.equals(SOUTH)) {
      goSouth(value);
    }
    else if (action.equals(EAST)) {
      goEast(value);
    }
    else if (action.equals(WEST)) {
      goWest(value);
    }
  }

  public int getManhattanDistance() {
    return Math.abs(longitudinalPosition) + Math.abs(latitudinalPosition);
  }

  private void doForward(int value) {
    if (helm.getDirection() == Direction.NORTH) {
      goNorth(value);
    }
    else if (helm.getDirection() == Direction.SOUTH) {
      goSouth(value);
    }
    else if (helm.getDirection() == Direction.EAST) {
      goEast(value);
    }
    else if (helm.getDirection() == Direction.WEST) {
      goWest(value);
    }
  }

  private void goNorth(int value) {
    latitudinalPosition += value;
  }

  private void goSouth(int value) {
    latitudinalPosition -= value;
  }

  private void goEast(int value) {
    longitudinalPosition += value;
  }

  private void goWest(int value) {
    longitudinalPosition -= value;
  }
}
