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

  private static class Instruction {

    public static final String NOP = "nop";
    public static final String ACC = "acc";
    public static final String JMP = "jmp";

    public String opCode;
    public int argument;

    public Instruction(String opCode, int argument) {
      this.opCode = opCode;
      this.argument = argument;
    }
  }

  public HaltingComputer(List<String> program) {
    this.program = program;
  }

  public void executeCurrentInstruction() {
    var currentInstruction = getCurrentInstruction();

    switch (currentInstruction.opCode) {

    case Instruction.NOP:
      break;

    case Instruction.ACC:
      this.accumulator += currentInstruction.argument;
      break;

    case Instruction.JMP:
      this.instructionPointer += currentInstruction.argument - 1;
      break;
    }

    this.executedInstructions.add(this.instructionPointer);
    this.instructionPointer++;
  }

  public int getAccumulator() {
    return this.accumulator;
  }

  public boolean willLoopAtCurrentInstruction() {
    return this.executedInstructions.contains(this.instructionPointer);
  }

  private Instruction getCurrentInstruction() {

    // FIXME: this should be moved to Instruction
    var parsed = this.program.get(instructionPointer).split(" ");
    return new Instruction(parsed[0], Integer.parseInt(parsed[1]));
  }

}
