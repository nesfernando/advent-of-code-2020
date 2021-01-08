package adventofcode.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TobogganTrajectory {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    System.out.println("Number of trees encountered: " + runTrajectory(lines, 1, 1));
    System.out.println("Number of trees encountered: " + runTrajectory(lines, 3, 1));
    System.out.println("Number of trees encountered: " + runTrajectory(lines, 5, 1));
    System.out.println("Number of trees encountered: " + runTrajectory(lines, 7, 1));
    System.out.println("Number of trees encountered: " + runTrajectory(lines, 1, 2));
  }

  private static int runTrajectory(List<String> lines, int rightMoves, int downMoves) {
    var map = createMap(lines);

    int numTrees = 0;

    while (map.canMoveDown()) {
      map.moveRight(rightMoves);
      map.moveDown(downMoves);

      if (map.isTree()) {
        numTrees++;
      }
    }

    return numTrees;
  }

  private static TobogganMap createMap(List<String> lines) {
    var rows = new ArrayList<TobogganMapRow>();

    for (String s : lines) {
      rows.add(new TobogganMapRow(s));
    }

    return new TobogganMap(rows);
  }

}
