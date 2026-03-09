package szaqal.alg.demo.misc;

import java.util.List;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/birthday-cake-candles
public class BirthDayCandle {

  /**
   * Original implementation - uses stream with groupingBy.
   * 
   * Performance issues:
   * - Creates full HashMap with all unique values and counts - O(n) space overhead
   * - Multiple stream operations (3 chained streams) - pipeline allocation overhead
   * - Uses Long for counting - unnecessary memory overhead (int suffices)
   * - Autoboxing from Integer to int in lambda
   * 
   * Example: candles = [4,4,1,3] returns 2 (max is 4, appears 2 times)
   */
  public static int birthdayCakeCandles( List<Integer> candles ) {

    return candles.stream()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .values()
            .stream()
            .max(Long::compareTo)
            .map(Long::intValue)
            .orElseThrow();
  }

  /**
   * Optimized implementation with single-pass iteration and reduced overhead.
   * 
   * Optimization findings:
   * - Single pass: O(n) time with no intermediate collections
   * - No stream overhead: Direct iteration eliminates multiple Stream pipeline allocations
   * - No HashMap: Tracks max value and count with just two primitive variables
   * - No autoboxing: Uses primitive int throughout the loop
   * - Memory: O(1) space vs O(n) for original (no Map allocation)
   * 
   * Trade-off: Original is more "functional" and readable for simple cases,
   * but this version is significantly faster for large lists.
   * 
   * @param candles list of candle heights
   * @return count of the tallest candles
   */
  public static int birthdayCakeCandlesOptimized( List<Integer> candles ) {
    int maxHeight = 0;
    int maxCount = 0;
    
    for (int height : candles) {
      if (height > maxHeight) {
        maxHeight = height;
        maxCount = 1;
      } else if (height == maxHeight) {
        maxCount++;
      }
    }
    
    return maxCount;
  }
}
