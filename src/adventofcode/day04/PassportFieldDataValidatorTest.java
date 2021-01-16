package adventofcode.day04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class PassportFieldDataValidatorTest {

  private static Map<String, String> getValidPassportData() {
    return new HashMap<>(Map.ofEntries(
        Map.entry("pid", "087499704"), Map.entry("hgt", "74in"), Map.entry("ecl", "grn"), Map.entry("iyr", "2012"),
        Map.entry("eyr", "2030"), Map.entry("byr", "1980"), Map.entry("hcl", "#623a2f")));
  }

  private static Map<String, String> getCompletePassportDataWith(String key, String value) {
    var passportData = getValidPassportData();
    passportData.put(key, value);
    return passportData;
  }

  @Test
  void allFieldsValid() {
    var passportData = getValidPassportData();

    assertTrue(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void birthYearBefore1920Invalid() {
    var passportData = getCompletePassportDataWith("byr", "1919");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void birthYearAfter2002Invalid() {
    var passportData = getCompletePassportDataWith("byr", "2003");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void issueYearBefore2010Invalid() {
    var passportData = getCompletePassportDataWith("iyr", "2009");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void issueYearAfter2020Invalid() {
    var passportData = getCompletePassportDataWith("iyr", "2021");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void expirationYearBefore2020Invalid() {
    var passportData = getCompletePassportDataWith("eyr", "2019");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void expirationYearAfter2030Invalid() {
    var passportData = getCompletePassportDataWith("eyr", "2031");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void metricHeightLessThan150cmInvalid() {
    var passportData = getCompletePassportDataWith("hgt", "149cm");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void metricHeightGreatherThan193cmInvalid() {
    var passportData = getCompletePassportDataWith("hgt", "194cm");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void imperialHeightLessThan59InchesInvalid() {
    var passportData = getCompletePassportDataWith("hgt", "58in");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void imperialHeightGreatherThan76InchesInvalid() {
    var passportData = getCompletePassportDataWith("hgt", "77in");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void hairColorLessThanSixCharactersInvalid() {
    var passportData = getCompletePassportDataWith("hcl", "#623a2");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void hairColorGreaterThanSixCharactersInvalid() {
    var passportData = getCompletePassportDataWith("hcl", "#623a2f0");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void unknownHairColorInvalid() {
    var passportData = getCompletePassportDataWith("ecl", "pnk");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }

  @Test
  void passportIDLessThanNineDigitsInvalid() {
    var passportData = getCompletePassportDataWith("pid", "08749970");

    assertFalse(PassportFieldDataValidator.validate(passportData));
  }
}
