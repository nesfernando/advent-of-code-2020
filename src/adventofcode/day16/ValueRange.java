package adventofcode.day16;

public class ValueRange {

  private int lowEnd;
  private int highEnd;

  public ValueRange(int lowEnd, int highEnd) {
    this.lowEnd = lowEnd;
    this.highEnd = highEnd;
  }

  public boolean inRange(int value) {
    return lowEnd <= value && value <= highEnd;
  }

  // 27-180
  public static ValueRange parse(String str) {
    var dashTerms = str.split("-");
    return new ValueRange(Integer.parseInt(dashTerms[0]), Integer.parseInt(dashTerms[1]));
  }
}
