package adventofcode.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HandheldHalting {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(args[0]));

    var computer = new HaltingComputer(lines);

    while (!computer.willLoopAtCurrentInstruction()) {
      computer.executeCurrentInstruction();
    }

    System.out.println("Accumulator value before looping: " + computer.getAccumulator());

    var fixer = new BootCodeFixer(lines);

    System.out.println("Accumulator value after fixing program: " + fixer.getAccumulatorAtProgramEnd());
  }
}
