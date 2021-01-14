package adventofcode.day8;

public class Instruction {

  public static final String NOP = "nop";
  public static final String ACC = "acc";
  public static final String JMP = "jmp";

  private String opCode;
  private int argument;

  public Instruction(String instructionStr) {
    parse(instructionStr);
  }

  @Override
  public String toString() {
    return getOpCode() + " " + String.format("+%d", getArgument());
  }

  public String getOpCode() {
    return this.opCode;
  }

  public int getArgument() {
    return this.argument;
  }

  private void parse(String instructionStr) {
    var terms = instructionStr.split(" ");
    this.opCode = terms[0];
    this.argument = Integer.parseInt(terms[1]);
  }
}
