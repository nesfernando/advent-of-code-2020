package adventofcode.day18;

public class Tokenizer {

  private static final char OPENPAREN = '(';
  private static final char CLOSEPAREN = ')';
  private static final char ADDOP = '+';
  private static final char MULTIOP = '*';

  private String line;
  private int index = 0;

  public Tokenizer(String line) {
    this.line = line;
  }

  public boolean hasNext() {
    return index < line.length();
  }

  public Token getNextToken() {
    char c = moveToNextCharacter();

    if (c == OPENPAREN) {
      index++;
      return new OpenParenToken();
    }
    else if (c == CLOSEPAREN) {
      index++;
      return new CloseParenToken();
    }
    else if (c == ADDOP) {
      index++;
      return new AddOpToken();
    }
    else if (c == MULTIOP) {
      index++;
      return new MultiOpToken();
    }
    else if (Character.isDigit(c)) {
      return new NumberToken(getNumberString());
    }

    throw new IllegalStateException("Unable to parse next token at index: " + index);

  }

  private String getNumberString() {
    var buffer = new StringBuffer();
    char c = ' ';

    for (; index < line.length(); index++) {
      c = line.charAt(index);
      if (!Character.isDigit(c)) {
        break;
      }
      buffer.append(c);
    }

    return buffer.toString();
  }

  private char moveToNextCharacter() {
    char c = ' ';

    for (; index < line.length(); index++) {
      c = line.charAt(index);
      if (!Character.isWhitespace(c)) {
        break;
      }
    }

    return c;
  }
}
