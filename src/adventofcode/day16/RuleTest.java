package adventofcode.day16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RuleTest {

  @Test
  void withinRange() {
    var rule = Rule.parse("departure location: 27-180 or 187-953");

    assertTrue(rule.valueIsWithinOneRange(27));
    assertTrue(rule.valueIsWithinOneRange(30));
    assertTrue(rule.valueIsWithinOneRange(180));
    assertTrue(rule.valueIsWithinOneRange(187));
    assertTrue(rule.valueIsWithinOneRange(500));
    assertTrue(rule.valueIsWithinOneRange(953));
  }

  @Test
  void outsidesRanges() {
    var rule = Rule.parse("departure location: 27-180 or 187-953");

    assertFalse(rule.valueIsWithinOneRange(26));
    assertFalse(rule.valueIsWithinOneRange(181));
    assertFalse(rule.valueIsWithinOneRange(186));
    assertFalse(rule.valueIsWithinOneRange(954));
  }
}
