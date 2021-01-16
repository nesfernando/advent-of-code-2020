package adventofcode.day04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassportDataParser {

  /*
   * "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd"
   * "byr:1937 iyr:2017 cid:147 hgt:183cm"
   */
  public static Map<String, String> parse(List<String> dataBuffer) {

    var map = new HashMap<String, String>();

    for (String line : dataBuffer) {
      String[] whitespaceTerms = line.split(" ");

      for (String whitespaceTerm : whitespaceTerms) {
        String[] colonTerms = whitespaceTerm.split(":");

        map.put(colonTerms[0], colonTerms[1]);
      }
    }

    return map;
  }

}
