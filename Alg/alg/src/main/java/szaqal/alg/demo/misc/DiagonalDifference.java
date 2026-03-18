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

  /**
   * Production-ready version with proper input validation and overflow handling.
   *
   * <p>Calculates the absolute difference between the sums of the diagonals
   * of a square matrix with robust error handling.
   *
   * <p>Primary diagonal: top-left to bottom-right (arr[i][i])
   * <p>Secondary diagonal: top-right to bottom-left (arr[i][n-1-i])
   *
   * <p>Time Complexity: O(n) where n is the matrix dimension
   * <p>Space Complexity: O(1)
   *
   * @param arr square matrix represented as List of Lists
   * @return absolute difference between diagonal sums
   * @throws IllegalArgumentException if matrix is null, not square,
   *         or contains null rows
   * @throws ArithmeticException if the result exceeds Integer.MAX_VALUE
   */
  public static int diagonalDifferenceSafe(List<List<Integer>> arr) {
    validateSquareMatrix(arr);

    int n = arr.size();
    long primaryDiagSum = 0;
    long secondaryDiagSum = 0;

    for (int i = 0; i < n; i++) {
      primaryDiagSum += arr.get(i).get(i);
      secondaryDiagSum += arr.get(i).get(n - 1 - i);
    }

    long absoluteDiff = Math.abs(primaryDiagSum - secondaryDiagSum);

    if (absoluteDiff > Integer.MAX_VALUE) {
      throw new ArithmeticException(
          "Result " + absoluteDiff + " exceeds Integer.MAX_VALUE");
    }

    return (int) absoluteDiff;
  }

  private static void validateSquareMatrix(List<List<Integer>> arr) {
    if (arr == null) {
      throw new IllegalArgumentException("Matrix cannot be null");
    }

    int n = arr.size();

    for (int i = 0; i < n; i++) {
      List<Integer> row = arr.get(i);
      if (row == null) {
        throw new IllegalArgumentException(
            "Row " + i + " is null");
      }
      if (row.size() != n) {
        throw new IllegalArgumentException(
            "Expected square matrix of size " + n +
            ", but row " + i + " has size " + row.size());
      }
    }
  }
}
