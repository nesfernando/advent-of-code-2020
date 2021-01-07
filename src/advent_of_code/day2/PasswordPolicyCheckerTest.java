package advent_of_code.day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordPolicyCheckerTest {

  static class PasswordEntryParserTest {

    @Test
    void test() {
      String entry = "13-17 s: ssssssssssssgsssj";

      var parser = new PasswordPolicyChecker.PasswordEntryParser(entry);

      assertEquals(13, parser.getMinFrequency());
      assertEquals(17, parser.getMaxFrequency());
      assertEquals('s', parser.getLetter());
      assertEquals("ssssssssssssgsssj", parser.getPassword());
    }
  }

  static class PasswordPolicyTest {

    @Test
    void meetsMinimumInBeginning() {
      var policy = new PasswordPolicyChecker.PasswordPolicy('s', 2, 3);

      assertTrue(policy.meetsPolicy("sst"));
    }

    @Test
    void meetsMinimumInMiddle() {
      var policy = new PasswordPolicyChecker.PasswordPolicy('s', 2, 3);

      assertTrue(policy.meetsPolicy("tsst"));
    }

    @Test
    void meetsMinimumInEnd() {
      var policy = new PasswordPolicyChecker.PasswordPolicy('s', 2, 3);

      assertTrue(policy.meetsPolicy("tss"));
    }

    @Test
    void meetsMinimumSplit() {
      var policy = new PasswordPolicyChecker.PasswordPolicy('s', 2, 3);

      assertTrue(policy.meetsPolicy("sts"));
    }

    @Test
    void failsMinimum() {
      var policy = new PasswordPolicyChecker.PasswordPolicy('s', 3, 4);

      assertFalse(policy.meetsPolicy("ststtt"));
    }

    @Test
    void failsMaximumInBeginning() {
      var policy = new PasswordPolicyChecker.PasswordPolicy('s', 2, 3);

      assertFalse(policy.meetsPolicy("sssst"));
    }

    @Test
    void failsMaximumInEnd() {
      var policy = new PasswordPolicyChecker.PasswordPolicy('s', 2, 3);

      assertFalse(policy.meetsPolicy("tssss"));
    }

    @Test
    void failsMaximumSplit() {
      var policy = new PasswordPolicyChecker.PasswordPolicy('s', 2, 3);

      assertFalse(policy.meetsPolicy("sstss"));
    }
  }
}
