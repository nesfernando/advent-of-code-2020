package adventofcode.day14;

import java.util.List;

public interface Decoder {

  void setMask(String mask);

  void setValue(long address, long value);

  List<Long> getValues();

}
