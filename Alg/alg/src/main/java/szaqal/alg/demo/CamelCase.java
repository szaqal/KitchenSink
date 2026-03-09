package szaqal.alg.demo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/camelcase/problem
 */
public class CamelCase {

  /**
   * s=oneTwoTree => 3
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

  public static int camelCase4(String s) {
    long result = s.chars()
            .mapToObj(x -> (char) x)
            .filter(Character::isUpperCase)
            .count();
    return (int) result + 1;
  }

  public static int camelCase2( String s ) {
    return (int) IntStream.rangeClosed(0, s.length() - 1)
            .filter(x -> Character.isUpperCase(s.charAt(x)))
            .count() + 1;
  }

  public static int camelCase3( String s ) {
    int result = 1;
    for (int i = 0; i < s.length() - 1; i++) {
      if (Character.isUpperCase(s.charAt(i))) {
        result++;
      }
    }
    return result;
  }
}
