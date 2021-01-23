package adventofcode.day14;

public class MaskCommandExecutor implements ComputerCommandExecutor {

  private String mask;

  public MaskCommandExecutor(String mask) {
    this.mask = mask;
  }

  @Override
  public void execute(Computer computer) {
    computer.setMask(mask);
  }
}
