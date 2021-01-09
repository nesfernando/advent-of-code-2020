package adventofcode.day4;

import java.util.Map;

public class PassportFieldCountValidator {

  public static boolean validate(Map<String, String> passportData) {

    return hasEightFields(passportData) || hasSevenFieldsOnlyCIDMissing(passportData);
  }

  private static boolean hasEightFields(Map<String, String> passportData) {
    return passportData.size() == 8;
  }

  private static boolean hasSevenFieldsOnlyCIDMissing(Map<String, String> passportData) {
    boolean isCIDMissing = !passportData.containsKey("cid");
    return passportData.size() == 7 && isCIDMissing;
  }

}
