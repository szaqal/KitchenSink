package szaqal.alg.demo.misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/minimum-distances/problem?isFullScreen=true
 */
public class MinimumDistance {

  /**
   * Optimized O(n) solution using HashMap to track last seen position.
   * Time: O(n), Space: O(n)
   */
  public static int minimumDistances(List<Integer> a) {
    if (a == null || a.isEmpty()) {
      return -1;
    }

    int minDistance = Integer.MAX_VALUE;
    Map<Integer, Integer> lastSeen = new HashMap<>();

    for (int i = 0; i < a.size(); i++) {
      int value = a.get(i);
      if (lastSeen.containsKey(value)) {
        int distance = i - lastSeen.get(value);
        minDistance = Math.min(minDistance, distance);
      }
      lastSeen.put(value, i);
    }

    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
  }

  /**
   * Original O(n²) nested loop approach (kept for reference).
   */
  public static int minimumDistancesOriginal(List<Integer> a) {
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
