package adventofcode.day14;

public class MaskCommand implements DecoderCommand {

  private String mask;

  public MaskCommand(String mask) {
    this.mask = mask;
  }

  @Override
  public void execute(Decoder decoder) {
    decoder.setMask(mask);
  }
}
