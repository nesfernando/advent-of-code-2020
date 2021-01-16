package adventofcode.day03;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TobogganMapTest {

  private static TobogganMap getMapInstance() {
    var rows = new ArrayList<TobogganMapRow>();
    rows.add(new TobogganMapRow("......#...........#...#........"));
    rows.add(new TobogganMapRow(".#.....#...##.......#.....##..."));
    rows.add(new TobogganMapRow("......#.#....#................."));

    return new TobogganMap(rows);
  }

  @Test
  void moveToFirstTreeInRow() {
    var map = getMapInstance();

    map.moveRight(6);
    assertTrue(map.isTree());
  }

  @Test
  void moveToFirstTreeBelow() {
    var map = getMapInstance();

    map.moveRight(1);
    map.moveDown();
    assertTrue(map.isTree());
  }

  @Test
  void moveThreeRightThenDown() {
    var map = getMapInstance();

    map.moveRight(3);
    map.moveDown();
    assertTrue(map.isOpen());
  }

  @Test
  void moveSevenRightThenDown() {
    var map = getMapInstance();

    map.moveRight(7);
    map.moveDown();
    assertTrue(map.isTree());
  }

  @Test
  void canMoveDownOnStart() {
    var map = getMapInstance();

    assertTrue(map.canMoveDown());
  }

  @Test
  void moveDownOnceCanStillMoveDown() {
    var map = getMapInstance();

    map.moveDown();
    assertTrue(map.canMoveDown());
  }

  @Test
  void moveDownTwoCannotMoveDownAfter() {
    var map = getMapInstance();

    map.moveDown(2);
    assertFalse(map.canMoveDown());
  }
}
