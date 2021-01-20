package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WaypointHelmTest {

  @Test
  void turnRight90Degrees() {
    var waypointHelm = new WaypointHelm();

    waypointHelm.steerRight(90);
    assertEquals(1, waypointHelm.getLongtitudinalValue());
    assertEquals(-10, waypointHelm.getLatitudinalValue());

    waypointHelm.steerRight(90);
    assertEquals(-10, waypointHelm.getLongtitudinalValue());
    assertEquals(-1, waypointHelm.getLatitudinalValue());

    waypointHelm.steerRight(90);
    assertEquals(-1, waypointHelm.getLongtitudinalValue());
    assertEquals(10, waypointHelm.getLatitudinalValue());

    waypointHelm.steerRight(90);
    assertEquals(10, waypointHelm.getLongtitudinalValue());
    assertEquals(1, waypointHelm.getLatitudinalValue());
  }

  @Test
  void turnLeft90Degrees() {
    var waypointHelm = new WaypointHelm();

    waypointHelm.steerLeft(90);
    assertEquals(-1, waypointHelm.getLongtitudinalValue());
    assertEquals(10, waypointHelm.getLatitudinalValue());

    waypointHelm.steerLeft(90);
    assertEquals(-10, waypointHelm.getLongtitudinalValue());
    assertEquals(-1, waypointHelm.getLatitudinalValue());

    waypointHelm.steerLeft(90);
    assertEquals(1, waypointHelm.getLongtitudinalValue());
    assertEquals(-10, waypointHelm.getLatitudinalValue());

    waypointHelm.steerLeft(90);
    assertEquals(10, waypointHelm.getLongtitudinalValue());
    assertEquals(1, waypointHelm.getLatitudinalValue());
  }

  @Test
  void turnRight180Degrees() {
    var waypointHelm = new WaypointHelm();

    waypointHelm.steerRight(180);
    assertEquals(-10, waypointHelm.getLongtitudinalValue());
    assertEquals(-1, waypointHelm.getLatitudinalValue());
  }

  @Test
  void turnLeft180Degrees() {
    var waypointHelm = new WaypointHelm();

    waypointHelm.steerLeft(180);
    assertEquals(-10, waypointHelm.getLongtitudinalValue());
    assertEquals(-1, waypointHelm.getLatitudinalValue());
  }
}
