package adventofcode.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BatchPassportData {

  public static List<Map<String, String>> parse(List<String> lines) {

    var batch = new ArrayList<Map<String, String>>();

    var dataBuffer = new ArrayList<String>();

    for (String line : lines) {
      if (!line.isEmpty()) {
        dataBuffer.add(line);
      }
      else if (line.isEmpty() && !dataBuffer.isEmpty()) {
        var map = PassportDataParser.parse(dataBuffer);
        batch.add(map);
        dataBuffer.clear();
      }
    }

    // FIXME: this seems dirty to me
    // leftover data
    if (!dataBuffer.isEmpty()) {
      var map = PassportDataParser.parse(dataBuffer);
      batch.add(map);
    }

    return batch;
  }

}
