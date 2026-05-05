package szaqal.alg.demo.misc;

/**
 * https://www.hackerrank.com/challenges/utopian-tree/problem?isFullScreen=true
 */
public class UtopianTree {


  public static int utopianTree( int cycles ) {
    if (cycles == 0) {
      return 1;
    }

    int height = 1; // height of 1 meter is planted at the onset of spring.
    for (int i = 0; i < cycles; i++) {
      /*
          Tree goes through 2 cycles of growth every year.
          - Each spring, it doubles in height.
          - Each summer, its height increases by 1 meter.
       */
      if (i % 2 == 0) { //cycle 1, cycle 2 split
        height = 2 * height;
      } else {
        height += 1;
      }
    }

    return height;
  }
}
