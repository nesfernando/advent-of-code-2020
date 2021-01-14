package adventofcode.day8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HaltingComputer {

  private List<String> program;
  private int instructionPointer = 0;
  private int accumulator = 0;

  // we can also use an Instruction object here
  private Set<Integer> executedInstructions = new HashSet<Integer>();

  public HaltingComputer(List<String> program) {
    this.program = program;
  }

  public void executeCurrentInstruction() {
    var currentInstruction = new Instruction(this.program.get(instructionPointer));

    switch (currentInstruction.getOpCode()) {

    case Instruction.NOP:
      break;

    case Instruction.ACC:
      this.accumulator += currentInstruction.getArgument();
      break;

    case Instruction.JMP:
      this.instructionPointer += currentInstruction.getArgument() - 1;
      break;
    }

    this.executedInstructions.add(this.instructionPointer);
    this.instructionPointer++;
  }

  public int getAccumulator() {
    return this.accumulator;
  }

  public boolean hasSuccessfullyTerminated() {
    // should use == but guarding against being out of sync with other methods
    return this.instructionPointer >= this.program.size();
  }

  public boolean willLoopAtCurrentInstruction() {
    return this.executedInstructions.contains(this.instructionPointer);
  }

}
