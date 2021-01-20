package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelmTest {

  @Test
  void startEastTurnRight90Degrees() {
    var helm = new Helm();

    helm.steerRight(90);
    assertEquals(Direction.SOUTH, helm.getDirection());

    helm.steerRight(90);
    assertEquals(Direction.WEST, helm.getDirection());

    helm.steerRight(90);
    assertEquals(Direction.NORTH, helm.getDirection());

    helm.steerRight(90);
    assertEquals(Direction.EAST, helm.getDirection());
  }

  @Test
  void startEastTurnLeft90Degrees() {
    var helm = new Helm();

    helm.steerLeft(90);
    assertEquals(Direction.NORTH, helm.getDirection());

    helm.steerLeft(90);
    assertEquals(Direction.WEST, helm.getDirection());

    helm.steerLeft(90);
    assertEquals(Direction.SOUTH, helm.getDirection());

    helm.steerLeft(90);
    assertEquals(Direction.EAST, helm.getDirection());
  }

  @Test
  void startEastTurnRight180Degrees() {
    var helm = new Helm();

    helm.steerRight(180);
    assertEquals(Direction.WEST, helm.getDirection());
  }

  @Test
  void startEastTurnLeft180Degrees() {
    var helm = new Helm();

    helm.steerLeft(180);
    assertEquals(Direction.WEST, helm.getDirection());
  }

  @Test
  void startEastTurnRight270Degrees() {
    var helm = new Helm();

    helm.steerRight(270);
    assertEquals(Direction.NORTH, helm.getDirection());
  }

  @Test
  void startEastTurnLeft270Degrees() {
    var helm = new Helm();

    helm.steerLeft(270);
    assertEquals(Direction.SOUTH, helm.getDirection());
  }
}
