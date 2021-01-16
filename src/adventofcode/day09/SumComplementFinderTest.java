package adventofcode.day09;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

class SumComplementFinderTest {

  @Test
  void noPairs() {
    var numbers = List.of(95L, 102L, 117L, 150L, 182L);

    assertFalse(SumComplementFinder.hasComplementingPair(numbers, 127));
  }

}
