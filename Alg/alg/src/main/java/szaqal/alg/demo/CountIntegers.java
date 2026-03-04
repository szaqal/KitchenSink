package szaqal.alg.demo;

import java.util.Arrays;
import java.util.List;

//Hacker rank count integers
public class CountIntegers {

  public static int simpleArraySum( List<Integer> ar ) {
    return ar.stream().mapToInt(x -> x).sum();
  }

  public static int simpleArraySum(int[] ar) {
    return Arrays.stream(ar).sum();
  }

}
