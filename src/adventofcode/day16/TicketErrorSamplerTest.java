package adventofcode.day16;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class TicketErrorSamplerTest {

  @Test
  void baseExample1() {
    var rules = List.of(
        Rule.parse("class: 1-3 or 5-7"), Rule.parse("row: 6-11 or 33-44"), Rule.parse("seat: 13-40 or 45-50"));

    var sampler = new TicketErrorSampler(rules);

    sampler.takeSample("7,3,47");
    assertEquals(0, sampler.getErrorRate());
    sampler.takeSample("40,4,50");
    assertEquals(4, sampler.getErrorRate());
    sampler.takeSample("55,2,20");
    assertEquals(59, sampler.getErrorRate());
    sampler.takeSample("38,6,12");
    assertEquals(71, sampler.getErrorRate());
  }

  @Test
  void baseExample2() {
    var rules = List.of(
        Rule.parse("class: 0-1 or 4-19"), Rule.parse("row: 0-5 or 8-19"), Rule.parse("seat: 0-13 or 16-19"));

    var sampler = new TicketErrorSampler(rules);

    sampler.takeSample("3,9,18");
    sampler.takeSample("15,1,5");
    sampler.takeSample("5,14,9");

    var expected = Map.of("row", 0, "class", 1, "seat", 2);
    assertEquals(expected, sampler.getRuleNameToFieldNumberMapping());
  }
}
