package szaqal.alg.demo.misc;

//https://www.hackerrank.com/challenges/migratory-birds/problem?isFullScreen=true

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class MigratoryBirds {

  /**
   * Given an array of bird sightings where every element represents a bird type id, 
   * determine the id of the most frequently sighted type.
   * 
   * Uses simple array counting - O(n) time, O(1) space.
   * Correctly handles tie-breaking by returning lowest ID.
   */
  public static int migratoryBirds(List<Integer> arr) {
    int[] counts = new int[6];  // IDs are 1-5, index 0 unused
    
    for (int id : arr) {
      counts[id]++;
    }
    
    int maxCount = 0;
    int result = Integer.MAX_VALUE;
    
    for (int i = 1; i < counts.length; i++) {
      if (counts[i] > maxCount) {
        maxCount = counts[i];
        result = i;
      } else if (counts[i] == maxCount && i < result) {
        result = i;
      }
    }
    
    return result;
  }

  /**
   * Stream-based approach (kept for reference).
   * Note: This version has a tie-breaking bug - returns arbitrary max instead of lowest ID.
   */
  public static int migratoryBirdsStream(List<Integer> arr) {
    return arr.stream()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .entrySet()
        .stream()
        .max(comparingByValue()).get()
        .getKey();
  }
}
