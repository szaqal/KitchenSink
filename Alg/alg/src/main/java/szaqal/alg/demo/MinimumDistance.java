package szaqal.alg.demo;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/minimum-distances/problem?isFullScreen=true
 */
public class MinimumDistance {

  public static int minimumDistances( List<Integer> a ) {
    int length = Integer.MAX_VALUE;
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.size(); j++) {
        if (i != j && a.get(i).equals(a.get(j))) {
          int candLength = Math.abs(i - j);
          if (candLength < length) {
            length = candLength;
          }
        }
      }
    }
    return length == Integer.MAX_VALUE ? -1 : length;
  }
}
