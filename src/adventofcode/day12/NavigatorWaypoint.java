package adventofcode.day12;

public class NavigatorWaypoint {
  private Waypoint waypoint = new Waypoint();

  private int latitudinalPosition = 0;
  private int longitudinalPosition = 0;

  public void navigate(String command) {
    var action = command.substring(0, 1);
    var value = Integer.parseInt(command.substring(1));

    if (action.equals(NavigatorActions.FORWARD)) {
      doForward(value);
    }
    else if (action.equals(NavigatorActions.RIGHT)) {
      waypoint.rotateRight(value);
    }
    else if (action.equals(NavigatorActions.LEFT)) {
      waypoint.rotateLeft(value);
    }
    else if (action.equals(NavigatorActions.NORTH)) {
      waypoint.moveNorth(value);
    }
    else if (action.equals(NavigatorActions.SOUTH)) {
      waypoint.moveSouth(value);
    }
    else if (action.equals(NavigatorActions.EAST)) {
      waypoint.moveEast(value);
    }
    else if (action.equals(NavigatorActions.WEST)) {
      waypoint.moveWest(value);
    }
  }

  public int getManhattanDistance() {
    return Math.abs(longitudinalPosition) + Math.abs(latitudinalPosition);
  }

  private void doForward(int value) {
    for (int i = 0; i < value; i++) {
      longitudinalPosition += waypoint.getLongitudinalValue();
      latitudinalPosition += waypoint.getLatitudinalValue();
    }
  }
}
