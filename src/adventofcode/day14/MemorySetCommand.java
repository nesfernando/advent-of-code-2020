package adventofcode.day14;

public class MemorySetCommand implements DecoderCommand {

  private long address;
  private long value;

  public MemorySetCommand(long address, long value) {
    this.address = address;
    this.value = value;
  }

  @Override
  public void execute(Decoder decoder) {
    decoder.setValue(this.address, this.value);
  }
}
