package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WaypointTest {

  @Test
  void turnRight90Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateRight(90);
    assertEquals(1, waypoint.getLongtitudinalValue());
    assertEquals(-10, waypoint.getLatitudinalValue());

    waypoint.rotateRight(90);
    assertEquals(-10, waypoint.getLongtitudinalValue());
    assertEquals(-1, waypoint.getLatitudinalValue());

    waypoint.rotateRight(90);
    assertEquals(-1, waypoint.getLongtitudinalValue());
    assertEquals(10, waypoint.getLatitudinalValue());

    waypoint.rotateRight(90);
    assertEquals(10, waypoint.getLongtitudinalValue());
    assertEquals(1, waypoint.getLatitudinalValue());
  }

  @Test
  void turnLeft90Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateLeft(90);
    assertEquals(-1, waypoint.getLongtitudinalValue());
    assertEquals(10, waypoint.getLatitudinalValue());

    waypoint.rotateLeft(90);
    assertEquals(-10, waypoint.getLongtitudinalValue());
    assertEquals(-1, waypoint.getLatitudinalValue());

    waypoint.rotateLeft(90);
    assertEquals(1, waypoint.getLongtitudinalValue());
    assertEquals(-10, waypoint.getLatitudinalValue());

    waypoint.rotateLeft(90);
    assertEquals(10, waypoint.getLongtitudinalValue());
    assertEquals(1, waypoint.getLatitudinalValue());
  }

  @Test
  void turnRight180Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateRight(180);
    assertEquals(-10, waypoint.getLongtitudinalValue());
    assertEquals(-1, waypoint.getLatitudinalValue());
  }

  @Test
  void turnLeft180Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateLeft(180);
    assertEquals(-10, waypoint.getLongtitudinalValue());
    assertEquals(-1, waypoint.getLatitudinalValue());
  }

  @Test
  void moveNorthFromBetaToAlpha() {
    var waypoint = new Waypoint();
    waypoint.rotateRight(90);

    waypoint.moveNorth(20);
    assertEquals(1, waypoint.getLongtitudinalValue());
    assertEquals(10, waypoint.getLatitudinalValue());
  }

  @Test
  void moveNorthFromGammaToDelta() {
    var waypoint = new Waypoint();
    waypoint.rotateRight(180);

    waypoint.moveNorth(20);
    assertEquals(-10, waypoint.getLongtitudinalValue());
    assertEquals(19, waypoint.getLatitudinalValue());
  }

  @Test
  void moveSouthFromDeltaToGamma() {
    var waypoint = new Waypoint();
    waypoint.rotateLeft(90);

    waypoint.moveSouth(20);
    assertEquals(-1, waypoint.getLongtitudinalValue());
    assertEquals(-10, waypoint.getLatitudinalValue());
  }

  @Test
  void moveSouthFromAlphaToBeta() {
    var waypoint = new Waypoint();

    waypoint.moveSouth(20);
    assertEquals(10, waypoint.getLongtitudinalValue());
    assertEquals(-19, waypoint.getLatitudinalValue());
  }
}
