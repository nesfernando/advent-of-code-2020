package adventofcode.day10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class JoltageDeltaTest {

  @Test
  void oneBucket() {
    var joltages = List.of(0, 1);

    var joltageDelta = JoltageDelta.deltaDistributions(joltages);

    assertEquals(1, joltageDelta.size());
    assertEquals(1, joltageDelta.get(1));
  }

  @Test
  void twoBuckets() {
    var joltages = List.of(0, 1, 3);

    var joltageDelta = JoltageDelta.deltaDistributions(joltages);

    assertEquals(2, joltageDelta.size());
    assertEquals(1, joltageDelta.get(1));
    assertEquals(1, joltageDelta.get(2));
  }

  @Test
  void twoBucketsMultipleDistributions() {
    var joltages = List.of(0, 2, 3, 5, 6);

    var joltageDelta = JoltageDelta.deltaDistributions(joltages);

    assertEquals(2, joltageDelta.size());
    assertEquals(2, joltageDelta.get(1));
    assertEquals(2, joltageDelta.get(2));
  }

  @Test
  void sevenDeltasOfOneAndFiveDeltasOfThree() {
    var joltages = new ArrayList<>(List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4));
    joltages.add(0);
    joltages.add(22);
    Collections.sort(joltages);

    var joltageDelta = JoltageDelta.deltaDistributions(joltages);

    assertEquals(2, joltageDelta.size());
    assertEquals(7, joltageDelta.get(1));
    assertEquals(5, joltageDelta.get(3));
  }
}
