package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NavigatorTest {

  @Test
  void baseExample1() {
    var navigator = new Navigator();

    navigator.navigate("F10");
    navigator.navigate("N3");
    navigator.navigate("F7");
    navigator.navigate("R90");
    navigator.navigate("F11");

    assertEquals(25, navigator.getManhattanDistance());
  }

}
