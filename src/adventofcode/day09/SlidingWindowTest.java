package adventofcode.day09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SlidingWindowTest {

  @Test
  void fiveNumbersThreeWidthTwoSlides() {
    var numbers = List.of(95L, 102L, 117L, 150L, 182L);

    var window = new SlidingWindow(numbers, 3);

    assertTrue(window.canSlide());
    assertEquals(List.of(95L, 102L, 117L), window.getRange());
    assertEquals(150L, window.getNextAfterWindowEdge());

    window.slide();

    assertTrue(window.canSlide());
    assertEquals(List.of(102L, 117L, 150L), window.getRange());
    assertEquals(182L, window.getNextAfterWindowEdge());

    window.slide();
    assertFalse(window.canSlide());
  }

}
