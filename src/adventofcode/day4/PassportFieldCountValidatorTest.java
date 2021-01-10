package adventofcode.day4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

class PassportFieldCountValidatorTest {

  @Test
  void completePassportDataIsValid() {
    var data = Map.of(
        "ecl", "gry", "pid", "860033327", "eyr", "2020", "hcl", "#fffffd", "byr", "1937", "iyr", "2017", "cid", "147",
        "hgt", "183cm");

    assertTrue(PassportFieldCountValidator.validate(data));
  }

  @Test
  void onlyMissingFieldIsCIDStillValid() {
    var data = Map.of(
        "ecl", "gry", "pid", "860033327", "eyr", "2020", "hcl", "#fffffd", "byr", "1937", "iyr", "2017", "hgt",
        "183cm");

    assertTrue(PassportFieldCountValidator.validate(data));
  }
}
