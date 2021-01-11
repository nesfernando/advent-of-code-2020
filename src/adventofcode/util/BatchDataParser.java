package adventofcode.util;

import java.util.ArrayList;
import java.util.List;

public class BatchDataParser {

  /*
   * Given list of lines, partition groups of lines that are separated by a
   * newline character.
   */
  public static List<List<String>> parseGroups(List<String> lines) {
    var batch = new ArrayList<List<String>>();

    var dataBuffer = new ArrayList<String>();

    for (String line : lines) {
      if (!line.isEmpty()) {
        dataBuffer.add(line);
      }
      else if (!dataBuffer.isEmpty()) {
        batch.add(new ArrayList<String>(dataBuffer));
        dataBuffer.clear();
      }
    }

    if (!dataBuffer.isEmpty()) {
      batch.add(dataBuffer);
    }

    return batch;
  }
}
