package adventofcode.day18;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TokenizerTest {

  @Test
  void one() {
    var line = "1";

    var tokenizer = new Tokenizer(line);

    assertTrue(tokenizer.hasNext());
    assertEquals("1", tokenizer.getNextToken().getValue());
  }

  @Test
  void whitespaceTest() {
    var line = "    1     2    3";

    var tokenizer = new Tokenizer(line);

    assertTrue(tokenizer.hasNext());
    assertEquals("1", tokenizer.getNextToken().getValue());
    assertTrue(tokenizer.hasNext());
    assertEquals("2", tokenizer.getNextToken().getValue());
    assertTrue(tokenizer.hasNext());
    assertEquals("3", tokenizer.getNextToken().getValue());
    assertFalse(tokenizer.hasNext());
  }

  @Test
  void baseExample1a() {
    var line = "1 + 2 * 3 + 4 * 5 + 6";

    var tokenizer = new Tokenizer(line);

    assertTrue(tokenizer.hasNext());
    assertEquals("1", tokenizer.getNextToken().getValue());
    assertEquals("AddOp", tokenizer.getNextToken().getValue());
    assertEquals("2", tokenizer.getNextToken().getValue());
    assertEquals("MultiOp", tokenizer.getNextToken().getValue());
    assertEquals("3", tokenizer.getNextToken().getValue());
    assertEquals("AddOp", tokenizer.getNextToken().getValue());
    assertEquals("4", tokenizer.getNextToken().getValue());
    assertEquals("MultiOp", tokenizer.getNextToken().getValue());
    assertEquals("5", tokenizer.getNextToken().getValue());
    assertEquals("AddOp", tokenizer.getNextToken().getValue());
    assertEquals("6", tokenizer.getNextToken().getValue());
    assertFalse(tokenizer.hasNext());
  }

  @Test
  void baseExample1b() {
    var line = "1 + (2 * 3) + (4 * (5 + 6))";

    var tokenizer = new Tokenizer(line);

    assertEquals("1", tokenizer.getNextToken().getValue());
    assertEquals("AddOp", tokenizer.getNextToken().getValue());
    assertEquals("OpenParen", tokenizer.getNextToken().getValue());
    assertEquals("2", tokenizer.getNextToken().getValue());
    assertEquals("MultiOp", tokenizer.getNextToken().getValue());
    assertEquals("3", tokenizer.getNextToken().getValue());
    assertEquals("CloseParen", tokenizer.getNextToken().getValue());
    assertEquals("AddOp", tokenizer.getNextToken().getValue());
    assertEquals("OpenParen", tokenizer.getNextToken().getValue());
    assertEquals("4", tokenizer.getNextToken().getValue());
    assertEquals("MultiOp", tokenizer.getNextToken().getValue());
    assertEquals("OpenParen", tokenizer.getNextToken().getValue());
    assertEquals("5", tokenizer.getNextToken().getValue());
    assertEquals("AddOp", tokenizer.getNextToken().getValue());
    assertEquals("6", tokenizer.getNextToken().getValue());
    assertEquals("CloseParen", tokenizer.getNextToken().getValue());
    assertEquals("CloseParen", tokenizer.getNextToken().getValue());
    assertFalse(tokenizer.hasNext());
  }

}
