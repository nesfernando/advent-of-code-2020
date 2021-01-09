package adventofcode.day4;

import java.util.Map;
import java.util.function.Predicate;

public class PassportFieldDataValidator {

  public static boolean validate(Map<String, String> passportData) {
    return validate(passportData, "byr", PassportFieldDataValidator::isBirthYearValid);
  }

  private static boolean validate(Map<String, String> passportData, String key, Predicate<String> predicate) {

    String value = passportData.get(key);

    if (value == null)
      return false;

    return predicate.test(value);
  }

  private static boolean isBirthYearValid(String value) {
    // specific to birth year
    int birthYear = Integer.parseInt(value);
    return 1920 <= birthYear && birthYear <= 2002;
  }

}
