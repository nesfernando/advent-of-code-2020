package adventofcode.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BagRuleParserTest {

  @Test
  void LightRedWithOneBrightWhiteTwoMutedYellow() {
    var rule = new BagRuleParser("light red bags contain 1 bright white bag, 2 muted yellow bags.");

    assertEquals("light red", rule.getColor());
    assertEquals("1 bright white", rule.getContents().get(0));
    assertEquals("2 muted yellow", rule.getContents().get(1));
  }

  @Test
  void BrightWhiteWithOneShinyGold() {
    var rule = new BagRuleParser("bright white bags contain 1 shiny gold bag.");

    assertEquals("bright white", rule.getColor());
    assertEquals("1 shiny gold", rule.getContents().get(0));
  }

}
