package adventofcode.day9;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SlidingWindowTest {

  @Test
  void fiveNumbersThreePreambleTwoSlides() {
    var numbers = List.of(95L, 102L, 117L, 150L, 182L);
    
    var window = new SlidingWindow(numbers, 3);
    
    assertTrue(window.hasNextAfterWindowEdge());
    assertEquals(List.of(95L, 102L, 117L), window.getWindow());
    assertEquals(150L, window.getNextAfterWindowEdge());
    
    window.slide();
    
    assertTrue(window.hasNextAfterWindowEdge());
    assertEquals(List.of(102L, 117L, 150L), window.getWindow());
    assertEquals(182L, window.getNextAfterWindowEdge());
    
    window.slide();
    assertFalse(window.hasNextAfterWindowEdge());
  }

}
