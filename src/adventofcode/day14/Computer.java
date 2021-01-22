package adventofcode.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

  private String mask = "";
  private Map<Long, Long> memory = new HashMap<Long, Long>();

  public Computer() {

  }

  public void setMask(String mask) {
    this.mask = mask;
  }

  public void setValue(long address, long value) {
    var binaryString = ValueConverter.decimalToBinaryString(value);

    var maskedValue = Mask.apply(this.mask, binaryString);

    memory.put(address, ValueConverter.binaryStringToDecimal(maskedValue));
  }

  public List<Long> getValues() {
    return new ArrayList<>(memory.values());
  }
}
