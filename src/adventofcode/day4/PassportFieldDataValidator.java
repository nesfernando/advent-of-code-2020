package adventofcode.day4;

import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PassportFieldDataValidator {

  public static boolean validate(Map<String, String> passportData) {
    return validateField(passportData, "byr", PassportFieldDataValidator::isBirthYearValid)
        && validateField(passportData, "iyr", PassportFieldDataValidator::isIssueYearValid)
        && validateField(passportData, "eyr", PassportFieldDataValidator::isExpirationYearValid)
        && validateField(passportData, "hgt", PassportFieldDataValidator::isHeightValid);
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

  private static boolean isHeightValid(String value) {

    var metricPattern = Pattern.compile("(\\d{3})(cm)");
    var metricMatcher = metricPattern.matcher(value);
    if (metricMatcher.matches()) {
      int heightCm = Integer.parseInt(metricMatcher.group(1));
      return 150 <= heightCm && heightCm <= 193;
    }

    var imperialPattern = Pattern.compile("(\\d{2})(in)");
    var imperialMatcher = imperialPattern.matcher(value);
    if (imperialMatcher.matches()) {
      int heightInches = Integer.parseInt(imperialMatcher.group(1));
      return 59 <= heightInches && heightInches <= 76;
    }

    return false;
  }

}
