package szaqal.alg.demo.misc;

import java.util.function.IntPredicate;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class RepeatedString {

  public static long repeatedString(String s, long n) {
    // abcac n 10  -> abcacabcac -> 4 times a

    int length = s.length();
    IntPredicate intPredicate = x -> x == 'a';
    long count = s.chars().filter(intPredicate).count();

    long times = n / length;
    long left = n % length;

    String substring = s.substring(0, (int)left);
    long countInLeftOver = substring.chars().filter(intPredicate).count();
    return times * count + countInLeftOver;
  }
}
