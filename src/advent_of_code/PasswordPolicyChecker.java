package advent_of_code;

/*
 * Advent of Code, Day 2
 */
public class PasswordPolicyChecker {

  public static class PasswordEntryParser {

    private char letter;
    private int minFrequency;
    private int maxFrequency;
    private String password;

    public PasswordEntryParser(String entry) {
      parseEntry(entry);
    }

    // "13-17 s: ssssssssssssgsssj"
    private void parseEntry(String entry) {
      String[] spaceTerms = entry.split(" ");

      this.password = spaceTerms[2];

      this.letter = spaceTerms[1].charAt(0);

      String[] hyphenTerms = spaceTerms[0].split("-");

      this.minFrequency = Integer.parseInt(hyphenTerms[0]);
      this.maxFrequency = Integer.parseInt(hyphenTerms[1]);
    }

    public char getLetter() {
      return this.letter;
    }

    public int getMinFrequency() {
      return this.minFrequency;
    }

    public int getMaxFrequency() {
      return this.maxFrequency;
    }

    public String getPassword() {
      return this.password;
    }
  }

  public static class PasswordPolicy {

    private final char letter;
    private final int minFrequency;
    private final int maxFrequency;

    public PasswordPolicy(char letter, int minFrequency, int maxFrequency) {
      this.letter = letter;
      this.minFrequency = minFrequency;
      this.maxFrequency = maxFrequency;
    }

    public boolean meetsPolicy(String password) {

      int frequency = 0;

      for (char character : password.toCharArray()) {
        if (character == this.letter) {
          frequency++;
        }
      }

      return this.minFrequency <= frequency && frequency <= this.maxFrequency;
    }
  }
}
