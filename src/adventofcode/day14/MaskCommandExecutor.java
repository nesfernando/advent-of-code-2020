package adventofcode.day14;

public class MaskCommandExecutor implements DecoderCommandExecutor {

  private String mask;

  public MaskCommandExecutor(String mask) {
    this.mask = mask;
  }

  @Override
  public void execute(Decoder decoder) {
    decoder.setMask(mask);
  }
}
