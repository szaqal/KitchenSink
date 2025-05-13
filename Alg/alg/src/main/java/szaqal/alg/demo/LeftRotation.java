package szaqal.alg.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftRotation {
  public static List<Integer> rotateLeft(
      int shift,
      List<Integer> arr ) {
    int size = arr.size();
    Integer[] temp = new Integer[size];
    for (int i = 0; i < size; i++) {
      int idx = (i - shift) % size;
      if (idx < 0) {
        idx = size - Math.abs(idx);
      }
      temp[idx] = arr.get(i);
    }

    return Arrays.stream(temp).collect(Collectors.toList());

  }
}
