package szaqal.alg.demo.array;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr)  {
      int count = 0;
      boolean sorted = false;

      // CONSECUTIVE NUMBERS important
      while(!sorted) {
        //System.out.println(Arrays.toString(arr));
        sorted = true;
        for(int i=0;i<arr.length;i++) {
          int currValue = arr[i];
          if(!(currValue-1 == i)) {
            sorted = false;
            int expectedAt = currValue - 1;
            int currentAt = arr[expectedAt];
            arr[i] = currentAt;
            arr[expectedAt] = currValue;
            count++;
          }
        }

      }

      return count;
    }
}
