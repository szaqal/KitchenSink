package szaqal.alg.demo.misc;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?isFullScreen=true
 */
public class DivisibleSum {

  public static int divisibleSumPairs(
      int length,
      int divisor,
      List<Integer> ar ) {
    int result =0;
    for(int i=0;i<ar.size();i++) {
      for(int j=i;j<ar.size();j++) {
        if( i!=j && (ar.get(i) + ar.get(j)) % divisor==0) {
          //System.out.printf("%d %d%n", i, j);
          result++;
        }
      }
    }
    return result;
  }

}
