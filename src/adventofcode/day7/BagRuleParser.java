package adventofcode.day7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BagRuleParser {

  private String color;
  private List<String> contents;

  public BagRuleParser(String rule) {
    parse(rule);
  }

  public String getColor() {
    return this.color;
  }

  public List<String> getContents() {
    return this.contents;
  }

  // FIXME: duplication with parse+FromContent
  // "2 muted yellow"
  public static int parseCountFromContent(String content) {
    return Integer.parseInt(content.split(" ")[0]);
  }

  // "2 muted yellow"
  public static String parseColorFromContent(String content) {
    return content.split("\\d+ ")[1];
  }

  // "light red bags contain 1 bright white bag, 2 muted yellow bags."
  private void parse(String rule) {
    var containTerms = rule.split(" contain ");
    this.color = parseColor(containTerms[0]);

    this.contents = parseContents(containTerms[1]);
  }

  // "<color> bag" | "<color> bags"
  private static String parseColor(String s) {
    int endIndex = s.indexOf(" bag");
    return s.substring(0, endIndex);
  }

  // "1 bright white bag, 2 muted yellow bags."
  private static List<String> parseContents(String s) {
    var periodRemoved = s.substring(0, s.length() - 1);

    var commaTerms = periodRemoved.split(", ");

    return Arrays.stream(commaTerms).map(BagRuleParser::parseColor).collect(Collectors.toList());
  }
}
