package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NavigatorWaypointTest {

  @Test
  void baseExample2() {
    var navigator = new NavigatorWaypoint();

    navigator.navigate("F10");
    assertEquals(100, navigator.getLongitudinalPosition());
    assertEquals(10, navigator.getLatitudinalPosition());

    navigator.navigate("N3");
    assertEquals(100, navigator.getLongitudinalPosition());
    assertEquals(10, navigator.getLatitudinalPosition());

    navigator.navigate("F7");
    assertEquals(170, navigator.getLongitudinalPosition());
    assertEquals(38, navigator.getLatitudinalPosition());

    navigator.navigate("R90");
    assertEquals(170, navigator.getLongitudinalPosition());
    assertEquals(38, navigator.getLatitudinalPosition());

    navigator.navigate("F11");
    assertEquals(214, navigator.getLongitudinalPosition());
    assertEquals(-72, navigator.getLatitudinalPosition());

    assertEquals(286, navigator.getManhattanDistance());
  }

  @Test
  void moveForwardDefault() {
    var navigator = new NavigatorWaypoint();

    navigator.navigate("F1");

    assertEquals(10, navigator.getLongitudinalPosition());
    assertEquals(1, navigator.getLatitudinalPosition());
  }

  @Test
  void rotateR90moveForward() {
    var navigator = new NavigatorWaypoint();

    navigator.navigate("R90");
    navigator.navigate("F1");

    assertEquals(1, navigator.getLongitudinalPosition());
    assertEquals(-10, navigator.getLatitudinalPosition());
  }

  @Test
  void rotateR180moveForward() {
    var navigator = new NavigatorWaypoint();

    navigator.navigate("R180");
    navigator.navigate("F1");

    assertEquals(-10, navigator.getLongitudinalPosition());
    assertEquals(-1, navigator.getLatitudinalPosition());
  }

  @Test
  void rotateR270moveForward() {
    var navigator = new NavigatorWaypoint();

    navigator.navigate("R270");
    navigator.navigate("F1");

    assertEquals(-1, navigator.getLongitudinalPosition());
    assertEquals(10, navigator.getLatitudinalPosition());
  }

  @Test
  void rotateL90moveForward() {
    var navigator = new NavigatorWaypoint();

    navigator.navigate("L90");
    navigator.navigate("F1");

    assertEquals(-1, navigator.getLongitudinalPosition());
    assertEquals(10, navigator.getLatitudinalPosition());
  }

  @Test
  void rotateL180moveForward() {
    var navigator = new NavigatorWaypoint();

    navigator.navigate("L180");
    navigator.navigate("F1");

    assertEquals(-10, navigator.getLongitudinalPosition());
    assertEquals(-1, navigator.getLatitudinalPosition());
  }

  @Test
  void rotateL270moveForward() {
    var navigator = new NavigatorWaypoint();

    navigator.navigate("L270");
    navigator.navigate("F1");

    assertEquals(1, navigator.getLongitudinalPosition());
    assertEquals(-10, navigator.getLatitudinalPosition());
  }

}
