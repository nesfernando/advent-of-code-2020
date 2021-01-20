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

}
