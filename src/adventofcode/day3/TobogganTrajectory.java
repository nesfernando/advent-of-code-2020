package adventofcode.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TobogganTrajectory {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    var map = createMap(lines);

    int numTrees = 0;

    while (map.canMoveDown()) {
      map.moveRight(3);
      map.moveDown();

      if (map.isTree()) {
        numTrees++;
      }
    }

    System.out.println("Number of trees encountered: " + numTrees);
  }

  private static TobogganMap createMap(List<String> lines) {
    var rows = new ArrayList<TobogganMapRow>();

    for (String s : lines) {
      rows.add(new TobogganMapRow(s));
    }

    return new TobogganMap(rows);
  }

}
