package adventofcode.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class PassportDataParserTest {

  @Test
  void parsedValidDataHasEightFields() {
    var lines = Arrays.asList("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd", "byr:1937 iyr:2017 cid:147 hgt:183cm");

    var parsedDataMap = PassportDataParser.parse(lines);

    assertEquals(8, parsedDataMap.size());
  }

  @Test
  void parsedDataWithMissingFieldHasSevenFields() {
    var lines = Arrays.asList("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884", "hcl:#cfa07d byr:1929");

    var parsedDataMap = PassportDataParser.parse(lines);

    assertEquals(7, parsedDataMap.size());
  }
}
