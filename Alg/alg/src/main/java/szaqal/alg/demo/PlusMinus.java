package szaqal.alg.demo;

import java.util.List;

public class PlusMinus {
  public static void plusMinus( List<Integer> arr ) {
    int size = arr.size();
    int pos = 0, neg = 0, zero = 0;
    for (Integer value : arr) {
      if (value == 0) {
        zero++;
      } else if (value > 0) {
        pos++;
      } else {
        neg++;
      }
    }
    System.out.printf("%.06f\n", (double) pos / size);
    System.out.printf("%.06f\n", (double) neg / size);
    System.out.printf("%.06f\n", (double) zero / size);
  }

  public static void main( String[] args ) {
    plusMinus(List.of(1, 1, 0, -1, -1));
  }
}
