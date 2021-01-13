package adventofcode.day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HandyHaversacks {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    var terminalRulesRemoved = lines.stream().filter(s -> !s.contains("no other"));

    var graph = new BagRuleEvaluatorForContainingBags();

    terminalRulesRemoved.forEach(line -> graph.addRule(new BagRuleParser(line)));

    var containingBagColors = graph.getRecursivelyContainingBagColors("shiny gold");

    System.out.println(
        "Number of bag colors that can eventually contain at least one shiny gold: " + containingBagColors.size());
  }
}
