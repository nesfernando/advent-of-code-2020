package adventofcode.day4;

import java.util.Map;
import java.util.function.Predicate;

public class PassportFieldDataValidator {

  public static boolean validate(Map<String, String> passportData) {
    return validateField(passportData, "byr", PassportFieldDataValidator::isBirthYearValid)
        && validateField(passportData, "iyr", PassportFieldDataValidator::isIssueYearValid)
        && validateField(passportData, "eyr", PassportFieldDataValidator::isExpirationYearValid);
  }

  private static boolean validateField(Map<String, String> passportData, String key, Predicate<String> predicate) {
    String value = passportData.get(key);

    return value != null && predicate.test(value);
  }

  private static boolean isBirthYearValid(String value) {
    int birthYear = Integer.parseInt(value);
    return 1920 <= birthYear && birthYear <= 2002;
  }

  private static boolean isIssueYearValid(String value) {
    int issueYear = Integer.parseInt(value);
    return 2010 <= issueYear && issueYear <= 2020;
  }

  private static boolean isExpirationYearValid(String value) {
    int expirationYear = Integer.parseInt(value);
    return 2020 <= expirationYear && expirationYear <= 2030;
  }
}
