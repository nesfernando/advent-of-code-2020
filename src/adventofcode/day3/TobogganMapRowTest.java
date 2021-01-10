package adventofcode.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TobogganMapRowTest {

  @Test
  void noMoves() {
    var row = new TobogganMapRow("......#...........#...#........");

    assertTrue(row.isOpen());
  }

  @Test
  void moveToFirstTree() {
    var row = new TobogganMapRow("......#...........#...#........");

    row.moveRight(6);

    assertTrue(row.isTree());
  }

  @Test
  void moveToFirstThenSecondTree() {
    var row = new TobogganMapRow("......#...........#...#........");

    row.moveRight(6);
    row.moveRight(12);

    assertTrue(row.isTree());
  }

  @Test
  void moveToLastThenToFirstTree() {
    var row = new TobogganMapRow("......#...........#...#........");

    row.moveRight(22);
    assertTrue(row.isTree(), "Did not get to the last tree");

    row.moveRight(15);
    assertTrue(row.isTree(), "Did not get to the first tree");
    assertEquals(6, row.getPosition());
  }

  @Test
  void moveToLastThenToBeginning() {
    var row = new TobogganMapRow("......#...........#...#........");

    row.moveRight(22);
    assertTrue(row.isTree(), "Did not get to the last tree");
    row.moveRight(9);
    assertTrue(row.isOpen());
    assertEquals(0, row.getPosition(), "Did not get back to the beginning");
  }
}
