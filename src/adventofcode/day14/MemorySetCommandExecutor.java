package adventofcode.day14;

public class MemorySetCommandExecutor implements DecoderCommandExecutor {

  private long address;
  private long value;

  public MemorySetCommandExecutor(long address, long value) {
    this.address = address;
    this.value = value;
  }

  @Override
  public void execute(Decoder decoder) {
    decoder.setValue(this.address, this.value);
  }
}
