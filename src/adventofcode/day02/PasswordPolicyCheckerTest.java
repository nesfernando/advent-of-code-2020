package adventofcode.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PasswordPolicyCheckerTest {

  static class PasswordEntryParserTest {

    @Test
    void test() {
      String entry = "13-17 s: ssssssssssssgsssj";

      var parser = new PasswordPolicyChecker.PasswordEntryParser(entry);

      assertEquals(13, parser.getFirstNumericalParam());
      assertEquals(17, parser.getSecondNumericalParam());
      assertEquals('s', parser.getLetter());
      assertEquals("ssssssssssssgsssj", parser.getPassword());
    }
  }

  static class FrequencyPolicyTest {

    @Test
    void meetsMinimumInBeginning() {
      var policy = new PasswordPolicyChecker.FrequencyPolicy('s', 2, 3);

      assertTrue(policy.meetsPolicy("sst"));
    }

    @Test
    void meetsMinimumInMiddle() {
      var policy = new PasswordPolicyChecker.FrequencyPolicy('s', 2, 3);

      assertTrue(policy.meetsPolicy("tsst"));
    }

    @Test
    void meetsMinimumInEnd() {
      var policy = new PasswordPolicyChecker.FrequencyPolicy('s', 2, 3);

      assertTrue(policy.meetsPolicy("tss"));
    }

    @Test
    void meetsMinimumSplit() {
      var policy = new PasswordPolicyChecker.FrequencyPolicy('s', 2, 3);

      assertTrue(policy.meetsPolicy("sts"));
    }

    @Test
    void failsMinimum() {
      var policy = new PasswordPolicyChecker.FrequencyPolicy('s', 3, 4);

      assertFalse(policy.meetsPolicy("ststtt"));
    }

    @Test
    void failsMaximumInBeginning() {
      var policy = new PasswordPolicyChecker.FrequencyPolicy('s', 2, 3);

      assertFalse(policy.meetsPolicy("sssst"));
    }

    @Test
    void failsMaximumInEnd() {
      var policy = new PasswordPolicyChecker.FrequencyPolicy('s', 2, 3);

      assertFalse(policy.meetsPolicy("tssss"));
    }

    @Test
    void failsMaximumSplit() {
      var policy = new PasswordPolicyChecker.FrequencyPolicy('s', 2, 3);

      assertFalse(policy.meetsPolicy("sstss"));
    }
  }

  static class PositionalPolicyTest {

    // 1-3 a: abcde is valid: position 1 contains a and position 3 does not.
    @Test
    void validFirstAndSecondPositions() {
      var policy = new PasswordPolicyChecker.PositionalXORPolicy('a', 1, 3);

      assertTrue(policy.meetsPolicy("abcde"));
    }

    // 1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
    @Test
    void neitherFirstNorSecondPositionValid() {
      var policy = new PasswordPolicyChecker.PositionalXORPolicy('b', 1, 3);

      assertFalse(policy.meetsPolicy("abcde"));
    }

    // 2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
    @Test
    void bothFirstAndSecondPositionInvalid() {
      var policy = new PasswordPolicyChecker.PositionalXORPolicy('c', 2, 9);

      assertFalse(policy.meetsPolicy("ccccccccc"));
    }
  }
}
