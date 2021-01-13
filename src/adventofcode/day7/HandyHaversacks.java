package adventofcode.day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HandyHaversacks {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    part1(lines);

    part2(lines);
  }

  private static void part1(List<String> lines) {
    var terminalRulesRemoved = lines.stream().filter(s -> !s.contains("no other"));

    var evaluator = new BagRuleEvaluatorForContainingBags();

    terminalRulesRemoved.forEach(line -> evaluator.addRule(new BagRuleParser(line)));

    var containingBagColors = evaluator.getRecursivelyContainingBagColors("shiny gold");

    System.out.println(
        "Number of bag colors that can eventually contain at least one shiny gold: " + containingBagColors.size());
  }

  private static void part2(List<String> lines) {
    var terminalRulesRemoved = lines.stream().filter(s -> !s.contains("no other"));

    var evaluator = new BagRuleEvaluatorForAllBagContents();

    terminalRulesRemoved.forEach(line -> evaluator.addRule(new BagRuleParser(line)));

    System.out.println(
        "Total number of bags within this bag and those within them and so on: "
            + evaluator.getTotalRecursiveBagCount("shiny gold"));
  }
}
