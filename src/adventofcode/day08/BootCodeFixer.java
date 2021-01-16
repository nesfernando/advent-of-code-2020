package adventofcode.day08;

import java.util.List;

public class BootCodeFixer {

  private NopJmpSwapper swapper;

  public BootCodeFixer(List<String> program) {
    this.swapper = new NopJmpSwapper(program);
  }

  public int getAccumulatorAtProgramEnd() {

    while (swapper.hasNext()) {
      var program = swapper.nextSwappedProgram();
      var computer = new HaltingComputer(program);

      while (!computer.willLoopAtCurrentInstruction()) {
        computer.executeCurrentInstruction();
        if (computer.hasSuccessfullyTerminated()) {
          return computer.getAccumulator();
        }
      }
    }

    return -1;
  }

}
