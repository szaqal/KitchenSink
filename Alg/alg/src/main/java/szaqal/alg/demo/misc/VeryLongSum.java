package szaqal.alg.demo.misc;

import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem?isFullScreen=true
 */
public class VeryLongSum {

  public static long aVeryBigSum( List<Long> ar ) {
    return ar.stream().collect(Collectors.summingLong(x->x));
  }

  public static long aVeryBigSum1( List<Long> ar ) {
    return ar.stream().mapToLong(x -> x).sum();
  }
}
