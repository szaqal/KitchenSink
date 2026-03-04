package szaqal.alg.demo;

import java.util.*;

//https://www.hackerrank.com/challenges/missing-numbers/problem?isFullScreen=true
public class MissingNumbers {

  /**
   * arr = [7,2,5,3,5,3]
   * brr = [7,2,5,4,6,3,5,3]
   * result => 4,6
   */
  public static List<Integer> missingNumbers(
      List<Integer> arr,
      List<Integer> brr ) {
    //Meant to be unique
    Set<Integer> result = new HashSet<>();
    for (Integer elem : brr) {
      int i = arr.indexOf(elem);
      if (i != -1) {
        arr.set(i, null);
      } else {
        result.add(elem);
      }
    }
    return new ArrayList<>(result);
  }
}
