package szaqal.alg.demo;

import java.util.*;

//https://www.hackerrank.com/challenges/missing-number
public class MissingNumbers {
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

    List<Integer> aaa = new ArrayList<>(result);
    Collections.sort(aaa);
    return aaa;
  }
}
