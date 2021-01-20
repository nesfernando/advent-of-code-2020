package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WaypointTest {

  @Test
  void turnRight90Degrees() {
    var waypointHelm = new Waypoint();

    waypointHelm.rotateRight(90);
    assertEquals(1, waypointHelm.getLongtitudinalValue());
    assertEquals(-10, waypointHelm.getLatitudinalValue());

    waypointHelm.rotateRight(90);
    assertEquals(-10, waypointHelm.getLongtitudinalValue());
    assertEquals(-1, waypointHelm.getLatitudinalValue());

    waypointHelm.rotateRight(90);
    assertEquals(-1, waypointHelm.getLongtitudinalValue());
    assertEquals(10, waypointHelm.getLatitudinalValue());

    waypointHelm.rotateRight(90);
    assertEquals(10, waypointHelm.getLongtitudinalValue());
    assertEquals(1, waypointHelm.getLatitudinalValue());
  }

  @Test
  void turnLeft90Degrees() {
    var waypointHelm = new Waypoint();

    waypointHelm.rotateLeft(90);
    assertEquals(-1, waypointHelm.getLongtitudinalValue());
    assertEquals(10, waypointHelm.getLatitudinalValue());

    waypointHelm.rotateLeft(90);
    assertEquals(-10, waypointHelm.getLongtitudinalValue());
    assertEquals(-1, waypointHelm.getLatitudinalValue());

    waypointHelm.rotateLeft(90);
    assertEquals(1, waypointHelm.getLongtitudinalValue());
    assertEquals(-10, waypointHelm.getLatitudinalValue());

    waypointHelm.rotateLeft(90);
    assertEquals(10, waypointHelm.getLongtitudinalValue());
    assertEquals(1, waypointHelm.getLatitudinalValue());
  }

  @Test
  void turnRight180Degrees() {
    var waypointHelm = new Waypoint();

    waypointHelm.rotateRight(180);
    assertEquals(-10, waypointHelm.getLongtitudinalValue());
    assertEquals(-1, waypointHelm.getLatitudinalValue());
  }

  @Test
  void turnLeft180Degrees() {
    var waypointHelm = new Waypoint();

    waypointHelm.rotateLeft(180);
    assertEquals(-10, waypointHelm.getLongtitudinalValue());
    assertEquals(-1, waypointHelm.getLatitudinalValue());
  }
}
