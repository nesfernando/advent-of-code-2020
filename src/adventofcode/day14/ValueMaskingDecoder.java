package adventofcode.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueMaskingDecoder implements Decoder {

  private String mask = "";
  private Map<Long, Long> memory = new HashMap<Long, Long>();

  public ValueMaskingDecoder() {

  }

  @Override
  public void setMask(String mask) {
    this.mask = mask;
  }

  @Override
  public void setValue(long address, long value) {
    var binaryString = ValueConverter.decimalToBinaryString(value);

    var maskedValue = Mask.apply(this.mask, binaryString);

    memory.put(address, ValueConverter.binaryStringToDecimal(maskedValue));
  }

  @Override
  public List<Long> getValues() {
    return new ArrayList<>(memory.values());
  }
}
