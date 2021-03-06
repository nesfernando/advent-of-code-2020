package adventofcode.day15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryGameMapImpl implements MemoryGame {

  private int turnNumber = 1;
  private int lastNumberSpoken = 0;

  private Map<Integer, LastTurns> turnNumbersWhenLastCalled = new HashMap<Integer, LastTurns>();

  public MemoryGameMapImpl(List<Integer> startingNumbers) {

    // smelleh
    for (var number : startingNumbers) {
      speakNumber(number);
    }
  }

  @Override
  public int takeTurn() {
    var numberSpokenForThisTurn = 0;

    if (firstTimeLastNumberWasSpoken()) {
      numberSpokenForThisTurn = 0;
      speakNumber(numberSpokenForThisTurn);
    }
    else {
      numberSpokenForThisTurn = differenceBetweenLastTurns(lastNumberSpoken);
      speakNumber(numberSpokenForThisTurn);
    }

    return numberSpokenForThisTurn;
  }

  private boolean firstTimeLastNumberWasSpoken() {
    var lastTurns = turnNumbersWhenLastCalled.get(lastNumberSpoken);
    return lastTurns.secondToLast == 0;
  }

  private void speakNumber(int number) {
    memoizeLastTurns(number);
    lastNumberSpoken = number;
    turnNumber++;
  }

  private void memoizeLastTurns(int number) {
    var lastTurns = turnNumbersWhenLastCalled.getOrDefault(number, new LastTurns());

    lastTurns.secondToLast = lastTurns.last;
    lastTurns.last = turnNumber;
    turnNumbersWhenLastCalled.put(number, lastTurns);
  }

  private int differenceBetweenLastTurns(int number) {
    var lastTurns = turnNumbersWhenLastCalled.get(number);
    return lastTurns.last - lastTurns.secondToLast;
  }

  private static class LastTurns {
    public int secondToLast;
    public int last;
  }
}
