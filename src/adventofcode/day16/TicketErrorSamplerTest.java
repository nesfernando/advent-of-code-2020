package adventofcode.day16;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TicketErrorSamplerTest {

  private static TicketErrorSampler getSamplerInstance() {
    var rules = List.of(
        Rule.parse("class: 1-3 or 5-7"), Rule.parse("row: 6-11 or 33-44"), Rule.parse("seat: 13-40 or 45-50"));

    return new TicketErrorSampler(rules);
  }

  @Test
  void baseExample1() {
    var sampler = getSamplerInstance();

    sampler.takeSample("7,3,47");
    assertEquals(0, sampler.getErrorRate());
    sampler.takeSample("40,4,50");
    assertEquals(4, sampler.getErrorRate());
    sampler.takeSample("55,2,20");
    assertEquals(59, sampler.getErrorRate());
    sampler.takeSample("38,6,12");
    assertEquals(71, sampler.getErrorRate());
  }

}
