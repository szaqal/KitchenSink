package szaqal.alg.demo.misc;

import java.util.Arrays;
import java.util.List;

//Hacker rank count integers
public class CountIntegers {

  // has a performance issue: mapToInt(x -> x) creates an unnecessary Integer-to-int boxing/unboxing operation.

  public static int simpleArraySum( List<Integer> ar ) {
    return ar.stream().mapToInt(Integer::intValue).sum();
  }

  public static int simpleArraySum2( List<Integer> ar ) {
    return ar.stream().reduce(0, Integer::sum);
  }

  public static int simpleArraySum(int[] ar) {
    return Arrays.stream(ar).sum();
  }
}
