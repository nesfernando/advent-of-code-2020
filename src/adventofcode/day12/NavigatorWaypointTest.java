package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NavigatorWaypointTest {

  @Test
  void baseExample2() {
    var navigator = new NavigatorWaypoint();

    navigator.navigate("F10");
    navigator.navigate("N3");
    navigator.navigate("F7");
    navigator.navigate("R90");
    navigator.navigate("F11");

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
