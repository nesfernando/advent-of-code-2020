package adventofcode.day14;

public class MemorySetCommandExecutor implements ComputerCommandExecutor {

  private long address;
  private long value;

  public MemorySetCommandExecutor(long address, long value) {
    this.address = address;
    this.value = value;
  }

  @Override
  public void execute(Computer computer) {
    computer.setValue(this.address, this.value);
  }
}
