package szaqal.alg.demo.misc;

import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/camelcase/problem
 * 
 * Counts the number of words in a CamelCase string.
 * Example: "oneTwoTree" => 3 words
 */
public class CamelCase {

  /**
   * Original implementation - extremely inefficient.
   * 
   * Performance issues:
   * - toCharArray() creates unnecessary copy
   * - Creates new String object for EVERY character (String.valueOf)
   * - Calls toUpperCase() on single-char string - massive overhead
   * - O(n) String allocations instead of O(1)
   */
  public static int camelCase( String s ) {
    char[] charArray = s.toCharArray();
    int found = 1;//first start with lower always
    for (char c : charArray) {
      String s1 = String.valueOf(c);
      if (s1.toUpperCase().equals(s1)) {
        found++;
      }
    }
    return found;
  }

  /**
   * Stream-based implementation with mapToObj overhead.
   * 
   * Performance issues:
   * - Stream pipeline allocation overhead
   * - Unnecessary mapToObj(x -> (char) x) - adds boxing operation
   * - Still processes entire string even after count is determined
   */
  public static int camelCase4(String s) {
    long result = s.chars()
            .mapToObj(x -> (char) x)
            .filter(Character::isUpperCase)
            .count();
    return (int) result + 1;
  }

  /**
   * Stream-based with IntStream - slightly better than camelCase4.
   * 
   * Performance issues:
   * - Stream pipeline overhead
   * - No early termination (counts all uppercase even when not needed)
   */
  public static int camelCase2( String s ) {
    return (int) IntStream.rangeClosed(0, s.length() - 1)
            .filter(x -> Character.isUpperCase(s.charAt(x)))
            .count() + 1;
  }

  /**
   * Direct iteration - most efficient approach.
   * 
   * Optimization findings:
   * - Single pass, no intermediate objects
   * - Uses Character.isUpperCase() directly on char - no allocations
   * - O(1) space complexity
   * 
   * Note: Originally had a bug (i < s.length() - 1) that skipped the last character.
   * Fixed to i < s.length() to check all characters.
   */
  public static int camelCase3( String s ) {
    int result = 1;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isUpperCase(s.charAt(i))) {
        result++;
      }
    }
    return result;
  }

  /**
   * Optimal implementation with validation.
   * 
   * Optimization findings:
   * - Early return for empty/null strings
   * - Single for-each loop - clean and efficient
   * - Uses enhanced for loop over char array (avoids index bounds checks in some cases)
   * - No stream overhead, no allocations
   * 
   * @param s CamelCase string
   * @return number of words (always at least 1 for non-null/empty)
   */
  public static int camelCaseOptimized( String s ) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    
    int wordCount = 1;
    for (char c : s.toCharArray()) {
      if (Character.isUpperCase(c)) {
        wordCount++;
      }
    }
    return wordCount;
  }
}
