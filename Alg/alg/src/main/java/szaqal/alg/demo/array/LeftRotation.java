package szaqal.alg.demo.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
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
