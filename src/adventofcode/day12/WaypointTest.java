package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WaypointTest {

  @Test
  void turnRight90Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateRight(90);
    assertEquals(1, waypoint.getLongitudinalValue());
    assertEquals(-10, waypoint.getLatitudinalValue());

    waypoint.rotateRight(90);
    assertEquals(-10, waypoint.getLongitudinalValue());
    assertEquals(-1, waypoint.getLatitudinalValue());

    waypoint.rotateRight(90);
    assertEquals(-1, waypoint.getLongitudinalValue());
    assertEquals(10, waypoint.getLatitudinalValue());

    waypoint.rotateRight(90);
    assertEquals(10, waypoint.getLongitudinalValue());
    assertEquals(1, waypoint.getLatitudinalValue());
  }

  @Test
  void turnLeft90Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateLeft(90);
    assertEquals(-1, waypoint.getLongitudinalValue());
    assertEquals(10, waypoint.getLatitudinalValue());

    waypoint.rotateLeft(90);
    assertEquals(-10, waypoint.getLongitudinalValue());
    assertEquals(-1, waypoint.getLatitudinalValue());

    waypoint.rotateLeft(90);
    assertEquals(1, waypoint.getLongitudinalValue());
    assertEquals(-10, waypoint.getLatitudinalValue());

    waypoint.rotateLeft(90);
    assertEquals(10, waypoint.getLongitudinalValue());
    assertEquals(1, waypoint.getLatitudinalValue());
  }

  @Test
  void turnRight180Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateRight(180);
    assertEquals(-10, waypoint.getLongitudinalValue());
    assertEquals(-1, waypoint.getLatitudinalValue());
  }

  @Test
  void turnLeft180Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateLeft(180);
    assertEquals(-10, waypoint.getLongitudinalValue());
    assertEquals(-1, waypoint.getLatitudinalValue());
  }

  @Test
  void turnRight270Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateRight(270);
    assertEquals(-1, waypoint.getLongitudinalValue());
    assertEquals(10, waypoint.getLatitudinalValue());
  }

  @Test
  void turnLeft270Degrees() {
    var waypoint = new Waypoint();

    waypoint.rotateLeft(270);
    assertEquals(1, waypoint.getLongitudinalValue());
    assertEquals(-10, waypoint.getLatitudinalValue());
  }

  @Test
  void moveNorthNoQuadrantChange() {
    var waypoint = new Waypoint();

    waypoint.moveNorth(20);
    assertEquals(10, waypoint.getLongitudinalValue());
    assertEquals(21, waypoint.getLatitudinalValue());
  }

  @Test
  void moveSouthNoQuadrantChange() {
    var waypoint = new Waypoint();
    waypoint.rotateRight(90);

    waypoint.moveSouth(20);
    assertEquals(1, waypoint.getLongitudinalValue());
    assertEquals(-30, waypoint.getLatitudinalValue());
  }

  @Test
  void moveEastNoQuadrantChange() {
    var waypoint = new Waypoint();

    waypoint.moveEast(20);
    assertEquals(30, waypoint.getLongitudinalValue());
    assertEquals(1, waypoint.getLatitudinalValue());
  }

  @Test
  void moveWestNoQuadrantChange() {
    var waypoint = new Waypoint();
    waypoint.rotateLeft(90);

    waypoint.moveWest(20);
    assertEquals(-21, waypoint.getLongitudinalValue());
    assertEquals(10, waypoint.getLatitudinalValue());
  }

  @Test
  void moveNorthFromBetaToAlpha() {
    var waypoint = new Waypoint();
    waypoint.rotateRight(90);

    waypoint.moveNorth(20);
    assertEquals(1, waypoint.getLongitudinalValue());
    assertEquals(10, waypoint.getLatitudinalValue());
  }

  @Test
  void moveNorthFromGammaToDelta() {
    var waypoint = new Waypoint();
    waypoint.rotateRight(180);

    waypoint.moveNorth(20);
    assertEquals(-10, waypoint.getLongitudinalValue());
    assertEquals(19, waypoint.getLatitudinalValue());
  }

  @Test
  void moveSouthFromDeltaToGamma() {
    var waypoint = new Waypoint();
    waypoint.rotateLeft(90);

    waypoint.moveSouth(20);
    assertEquals(-1, waypoint.getLongitudinalValue());
    assertEquals(-10, waypoint.getLatitudinalValue());
  }

  @Test
  void moveSouthFromAlphaToBeta() {
    var waypoint = new Waypoint();

    waypoint.moveSouth(20);
    assertEquals(10, waypoint.getLongitudinalValue());
    assertEquals(-19, waypoint.getLatitudinalValue());
  }

  @Test
  void moveEastFromDeltaToAlpha() {
    var waypoint = new Waypoint();
    waypoint.rotateLeft(90);

    waypoint.moveEast(20);
    assertEquals(19, waypoint.getLongitudinalValue());
    assertEquals(10, waypoint.getLatitudinalValue());
  }

  @Test
  void moveEastFromGammaToBeta() {
    var waypoint = new Waypoint();
    waypoint.rotateLeft(180);

    waypoint.moveEast(20);
    assertEquals(10, waypoint.getLongitudinalValue());
    assertEquals(-1, waypoint.getLatitudinalValue());
  }

  @Test
  void moveWestFromAlphaToDelta() {
    var waypoint = new Waypoint();

    waypoint.moveWest(20);
    assertEquals(-10, waypoint.getLongitudinalValue());
    assertEquals(1, waypoint.getLatitudinalValue());
  }

  @Test
  void moveWestFromBetaToGamma() {
    var waypoint = new Waypoint();
    waypoint.rotateRight(90);

    waypoint.moveWest(20);
    assertEquals(-19, waypoint.getLongitudinalValue());
    assertEquals(-10, waypoint.getLatitudinalValue());
  }
}
