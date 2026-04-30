package szaqal.alg.demo.misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class SalesByMatch {

    public static int sockMerchant(int n, List<Integer> ar) {
      int result = 0 ;
      Map<Integer, Integer> numbers = new HashMap<>();
      for(int number : ar) {
        if(numbers.containsKey(number)) {
          numbers.put(number, numbers.get(number)+1);
        } else {
          numbers.put(number, 1);
        }
      }

      for(int count: numbers.values()) {
        if(count % 2 == 0) {
          result+= count/2;
        } else {
          result+=(count -1)/2;
        }
      }
      return result;
    }

}
