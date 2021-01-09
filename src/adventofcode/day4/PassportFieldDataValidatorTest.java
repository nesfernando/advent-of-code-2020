package adventofcode.day4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class PassportFieldDataValidatorTest {

  @Test
  void allFieldsValid() {
//    var map = Map.ofEntries(
//        Map.entry("pid", "087499704"), Map.entry("hgt", "74in"), Map.entry("ecl", "grn"), Map.entry("iyr", "2012"),
//        Map.entry("eyr", "2030"), Map.entry("byr", "1980"), Map.entry("hcl", "#623a2f"));

    var map = Map.ofEntries(Map.entry("byr", "1980"));

    assertTrue(PassportFieldDataValidator.validate(map));
  }

}
