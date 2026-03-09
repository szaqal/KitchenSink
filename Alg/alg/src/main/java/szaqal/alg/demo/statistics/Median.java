package szaqal.alg.demo.statistics;

import java.util.Collections;
import java.util.List;

//https://www.hackerrank.com/challenges/find-the-median
public class Median {

/**
 * Computes the median of a list of integers.
 * 
 * <p>Example: arr = [5,3,1,2,4] median = 3</p>
 * 
 * <h2>Code Review Notes:</h2>
 * <ul>
 *   <li><b>CRITICAL BUG:</b> This method mutates the input list via {@link Collections#sort(List)}.
 *     This is a side effect that can cause unexpected behavior in calling code. Consider creating
 *     a copy before sorting: {@code List<Integer> sorted = new ArrayList<>(arr);}</li>
 *   
 *   <li><b>Missing null/empty validation:</b> No null check on input parameter or empty list check.
 *     Will throw {@link NullPointerException} or {@link IndexOutOfBoundsException} without helpful messages.
 *     Add validation: {@code if (arr == null || arr.isEmpty()) throw new IllegalArgumentException(...);}</li>
 *   
 *   <li><b>Performance:</b> Uses full sort with O(n log n) time complexity. Consider implementing
 *     Quickselect algorithm for O(n) average time complexity if called frequently on large datasets.</li>
 *   
 *   <li><b>Code style:</b> Unnecessary use of floating point math ({@code arr.size() / 2.0} and
 *     {@link Math#floor(double)}). Use simple integer division: {@code arr.size() / 2}</li>
 * </ul>
 * 
 * @param arr the list of integers (must not be null or empty)
 * @return the median value
 * @throws IllegalArgumentException if arr is null or empty
 * @see <a href="https://www.hackerrank.com/challenges/find-the-median">Find the Median - HackerRank</a>
 */
public static int findMedian( List<Integer> arr ) {
    Collections.sort(arr);
    double a = arr.size() / 2.0;
    return arr.get((int) Math.floor(a));
  }
}
