package advent_of_code.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*
 * Advent of Code, Day 2
 */
public class PasswordPolicyChecker {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    int countValidFrequencyPolicyPasswords = countFrequencyPolicy(lines);
    System.out.println("Count of valid frequency policy passwords: " + countValidFrequencyPolicyPasswords);

    int countValidPositionalPolicyPasswords = countPositionalPolicy(lines);
    System.out.println("Count of valid positional policy passwords: " + countValidPositionalPolicyPasswords);
  }

  private static int countPositionalPolicy(List<String> lines) {
    int countValidPasswords = 0;
    for (String line : lines) {
      var parser = new PasswordEntryParser(line);

      var policy = new PositionalXORPolicy(parser.getLetter(), parser.getFirstNumericalParam(),
          parser.getSecondNumericalParam());

      if (policy.meetsPolicy(parser.getPassword())) {
        countValidPasswords++;
      }
    }

    return countValidPasswords;
  }

  private static int countFrequencyPolicy(List<String> lines) {
    int countValidPasswords = 0;
    for (String line : lines) {
      var parser = new PasswordEntryParser(line);

      var policy = new FrequencyPolicy(parser.getLetter(), parser.getFirstNumericalParam(),
          parser.getSecondNumericalParam());

      if (policy.meetsPolicy(parser.getPassword())) {
        countValidPasswords++;
      }
    }

    return countValidPasswords;
  }

  public static class PasswordEntryParser {

    private char letter;
    private int firstNumericalParam;
    private int secondNumericalParam;
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

      this.firstNumericalParam = Integer.parseInt(hyphenTerms[0]);
      this.secondNumericalParam = Integer.parseInt(hyphenTerms[1]);
    }

    public char getLetter() {
      return this.letter;
    }

    public int getFirstNumericalParam() {
      return this.firstNumericalParam;
    }

    public int getSecondNumericalParam() {
      return this.secondNumericalParam;
    }

    public String getPassword() {
      return this.password;
    }
  }

  public static class FrequencyPolicy {

    private final char letter;
    private final int minFrequency;
    private final int maxFrequency;

    public FrequencyPolicy(char letter, int minFrequency, int maxFrequency) {
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

  /*
   * Each policy actually describes two positions in the password, where 1 means
   * the first character, 2 means the second character, and so on. (Be careful;
   * Toboggan Corporate Policies have no concept of "index zero"!) Exactly one of
   * these positions must contain the given letter.
   */
  public static class PositionalXORPolicy {

    private final char letter;
    private final int firstPosition;
    private final int secondPosition;

    public PositionalXORPolicy(char letter, int firstPosition, int secondPosition) {
      this.letter = letter;
      this.firstPosition = firstPosition;
      this.secondPosition = secondPosition;
    }

    public boolean meetsPolicy(String password) {
      var firstChar = password.charAt(firstPosition - 1);
      var secondChar = password.charAt(secondPosition - 1);
      return firstChar == this.letter ^ secondChar == this.letter;
    }
  }
}
