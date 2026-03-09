package szaqal.alg.demo.misc;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class DiagonalDifference {

  /**
   * <pre>
   *     1 2 3
   *     4 5 6
   *     9 8 9
   * </pre>
   Single pass - O(n) time, O(1) space
   * (1+5+9) - (3+5+9)
   */
  public static int diagonalDifference( List<List<Integer>> arr ) {
    int count = arr.size();
    int diag1 = 0;
    int diag2 = 0;
    for (int i=0;i<count;i++) {
      diag1 += arr.get(i).get(i);
      diag2 += arr.get(i).get(count -1 - i);
    }
    return Math.abs(diag1 - diag2);
  }
}
