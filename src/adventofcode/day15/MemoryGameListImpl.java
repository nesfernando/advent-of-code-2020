package adventofcode.day15;

import java.util.ArrayList;
import java.util.List;

public class MemoryGameListImpl implements MemoryGame {

  private List<Integer> spokenNumbers;

  public MemoryGameListImpl(List<Integer> startingNumbers) {
    spokenNumbers = new ArrayList<Integer>(startingNumbers);
  }

  @Override
  public int takeTurn() {

    var numberSpokenForThisTurn = 0;

    if (lastNumberWasSpokenForFirstTime()) {
      numberSpokenForThisTurn = 0;
      speakNumber(numberSpokenForThisTurn);
    }
    else {
      var lastNumberSpoken = lastNumberSpoken();
      numberSpokenForThisTurn = differenceBetweenLastTwoTurnNumbers(lastNumberSpoken);
      speakNumber(numberSpokenForThisTurn);
    }

    return numberSpokenForThisTurn;
  }

  private boolean lastNumberWasSpokenForFirstTime() {
    var lastNumber = lastNumberSpoken();

    for (int i = spokenNumbers.size() - 2; i >= 0; i--) {
      if (spokenNumbers.get(i) == lastNumber) {
        return false;
      }
    }

    return true;
  }

  private int lastNumberSpoken() {
    return spokenNumbers.get(spokenNumbers.size() - 1);
  }

  private void speakNumber(int number) {
    spokenNumbers.add(number);
  }

  private int differenceBetweenLastTwoTurnNumbers(int number) {
    int count = 0;
    int lastTurnNumber = 0;
    int secondToLastTurnNumber = 0;

    for (int i = spokenNumbers.size() - 1; i >= 0; i--) {
      if (spokenNumbers.get(i) != number) {
        continue;
      }

      if (count == 0) {
        lastTurnNumber = i + 1;
        count++;
      }
      else if (count == 1) {
        secondToLastTurnNumber = i + 1;
        break;
      }
    }

    return lastTurnNumber - secondToLastTurnNumber;
  }
}
