package szaqal.alg.demo.misc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.hackerrank.com/challenges/pairs
public class Pairs {

  /**
   * Given an array of integers and a target value, determine the number of
   * pairs of array elements that have a difference equal to the target value.
   */
  public static int pairs(
      int k,
      List<Integer> arr ) {
    //TODO compare per set with array.containes
    Set<Integer> set = new HashSet<>(arr);
    int count = 0;
      for (Integer integer : arr) {
          if (set.contains(integer + k)) {
              count++;
          }
      }
    return count;
  }
}
