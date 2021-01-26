package adventofcode.day18;

public abstract class Token {

  private String value;

  public Token(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public abstract void transition(State state);
}
