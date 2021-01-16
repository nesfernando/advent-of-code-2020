package adventofcode.day08;

import java.util.ArrayList;
import java.util.List;

public class NopJmpSwapper {

  private List<String> program;

  // prevent infinite loops to begin with; requirements do this, too
  private int instructionPointer = 1;

  public NopJmpSwapper(List<String> program) {
    this.program = program;
  }

  public boolean hasNext() {
    return getNextSwapIndex() >= 0;
  }

  public List<String> nextSwappedProgram() {
    int nextSwapIndex = getNextSwapIndex();

    if (nextSwapIndex < 0)
      throw new IllegalStateException("Program index already past the end");

    var programCopy = new ArrayList<String>(program);

    var swappedInstruction = swapNopJmp(program.get(nextSwapIndex));
    programCopy.set(nextSwapIndex, swappedInstruction);

    // advance
    this.instructionPointer = nextSwapIndex + 1;

    return programCopy;
  }

  // starts at where we last left off
  private int getNextSwapIndex() {
    for (int i = instructionPointer; i < program.size(); i++) {
      var instruction = new Instruction(program.get(i));
      if (shouldSwap(instruction)) {
        return i;
      }
    }

    return -1;
  }

  private static boolean shouldSwap(Instruction instruction) {
    return instruction.getOpCode().equals(Instruction.JMP) || instruction.getOpCode().equals(Instruction.NOP);
  }

  private static String swapNopJmp(String instructionStr) {
    if (instructionStr.startsWith(Instruction.JMP)) {
      return instructionStr.replaceFirst(Instruction.JMP, Instruction.NOP);
    }
    else if (instructionStr.startsWith(Instruction.NOP)) {
      return instructionStr.replaceFirst(Instruction.NOP, Instruction.JMP);
    }

    throw new IllegalArgumentException("Received an instruction that's neither jmp or nop");
  }
}
