package szaqal.alg.demo;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true
 */
public class DiagonalDifference {
  public static int diagonalDifference( List<List<Integer>> arr ) {
    Integer count = arr.size();
    int diag1 = 0;
    int diag2 = 0;
    for (int i=0;i<count;i++) {
      diag1 += arr.get(i).get(i);
      diag2 += arr.get(i).get(count -1 - i);
    }
    return Math.abs(diag1 - diag2);
  }
}
