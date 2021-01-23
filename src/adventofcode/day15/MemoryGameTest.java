package adventofcode.day15;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MemoryGameTest {

  private static MemoryGame getInstance(List<Integer> startingNumbers) {
     return new MemoryGameListImpl(startingNumbers);
    // return new MemoryGameMapImpl(startingNumbers);
  }

  private static int getSpokenNumberAtTurn(List<Integer> startingNumbers, int turns) {
    var game = getInstance(startingNumbers);

    var turnsToGo = turns - startingNumbers.size();

    var lastSpoken = 0;
    for (int i = 0; i < turnsToGo; i++) {
      lastSpoken = game.takeTurn();
    }

    return lastSpoken;
  }

  @Test
  void partOne() {
    var lastSpoken = getSpokenNumberAtTurn(List.of(6, 4, 12, 1, 20, 0, 16), 2020);

    assertEquals(475, lastSpoken);
  }

  @Test
  void baseExample1() {
    var startingNumbers = List.of(0, 3, 6);

    var game = getInstance(startingNumbers);

    assertEquals(0, game.takeTurn()); // turn 4
    assertEquals(3, game.takeTurn()); // turn 5
    assertEquals(3, game.takeTurn()); // turn 6
    assertEquals(1, game.takeTurn()); // turn 7
    assertEquals(0, game.takeTurn()); // turn 8
    assertEquals(4, game.takeTurn()); // turn 9
    assertEquals(0, game.takeTurn()); // turn 10
  }

  @Test
  void baseExample1a() {
    var lastSpoken = getSpokenNumberAtTurn(List.of(1, 3, 2), 2020);

    assertEquals(1, lastSpoken);
  }

  @Test
  void baseExample1b() {
    var lastSpoken = getSpokenNumberAtTurn(List.of(2, 1, 3), 2020);

    assertEquals(10, lastSpoken);
  }

  @Test
  void baseExample1c() {
    var lastSpoken = getSpokenNumberAtTurn(List.of(1, 2, 3), 2020);

    assertEquals(27, lastSpoken);
  }

  @Test
  void baseExample1d() {
    var lastSpoken = getSpokenNumberAtTurn(List.of(2, 3, 1), 2020);

    assertEquals(78, lastSpoken);
  }

  @Test
  void baseExample1e() {
    var lastSpoken = getSpokenNumberAtTurn(List.of(3, 2, 1), 2020);

    assertEquals(438, lastSpoken);
  }

  @Test
  void baseExample1f() {
    var lastSpoken = getSpokenNumberAtTurn(List.of(3, 1, 2), 2020);

    assertEquals(1836, lastSpoken);
  }

}
