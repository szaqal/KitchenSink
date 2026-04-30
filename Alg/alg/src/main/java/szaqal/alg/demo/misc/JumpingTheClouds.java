package szaqal.alg.demo.misc;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class JumpingTheClouds {

    public static int jumpingOnClouds( List<Integer> c) {
      int size = c.size();
      int pointer = 0;
      int jumpCount=0;

      while(pointer < size) {
        int nextPointer = pointer + 1;
        if(nextPointer==size) {
          break;
        }
        int next = c.get(nextPointer);
        boolean longJumpThunder = next==1;
        boolean longJumpSafe = (nextPointer+2 <= size && next==0 && c.get(nextPointer+1) ==0);
        if(longJumpThunder || longJumpSafe) {
          pointer+=2;
        } else {
          pointer++;
        }
        jumpCount++;
      }
      return jumpCount;
    }
}
