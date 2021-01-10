package adventofcode.day4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class PassportFieldDataValidatorTest {

  private static Map<String, String> getValidPassportData() {
    return new HashMap<>(Map.ofEntries(
        Map.entry("pid", "087499704"), Map.entry("hgt", "74in"), Map.entry("ecl", "grn"), Map.entry("iyr", "2012"),
        Map.entry("eyr", "2030"), Map.entry("byr", "1980"), Map.entry("hcl", "#623a2f")));
  }

  @Test
  void allFieldsValid() {
    var passportData = getValidPassportData();

    assertTrue(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void birthYearBefore1920Invalid() {
    var passportData = getValidPassportData();
    passportData.put("byr", "1919");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void birthYearAfter2002Invalid() {
    var passportData = getValidPassportData();
    passportData.put("byr", "2003");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void issueYearBefore2010Invalid() {
    var passportData = getValidPassportData();
    passportData.put("iyr", "2009");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void issueYearAfter2020Invalid() {
    var passportData = getValidPassportData();
    passportData.put("iyr", "2021");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void expirationYearBefore2020Invalid() {
    var passportData = getValidPassportData();
    passportData.put("eyr", "2019");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void expirationYearAfter2030Invalid() {
    var passportData = getValidPassportData();
    passportData.put("eyr", "2031");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }
}
