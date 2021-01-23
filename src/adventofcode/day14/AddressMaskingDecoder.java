package adventofcode.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressMaskingDecoder implements Decoder {

  private String mask = "";
  private Map<Long, Long> memory = new HashMap<Long, Long>();

  public AddressMaskingDecoder() {

  }

  @Override
  public void setMask(String mask) {
    this.mask = mask;
  }

  @Override
  public void setValue(long address, long value) {
    var addresses = AddressMask.apply(this.mask, ValueConverter.decimalToBinaryString(address));

    for (var addr : addresses) {
      memory.put(ValueConverter.binaryStringToDecimal(addr), value);
    }
  }

  @Override
  public List<Long> getValues() {
    return new ArrayList<>(memory.values());
  }
}
