package szaqal.alg.demo.misc;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class CountingValleys {

  public static int countingValleys(
      int stepCount,
      String path ) {
    char[] steps = path.toCharArray();

    int level = 0;
    //definition  valley is a sequence of consecutive steps below sea level
    int valleyCount = 0;

    boolean inValley = false;

    for (char step : steps) {
      if (step == 'U') {
        level++;
        if (level == 0 && inValley) {
          // when going up from current valley reaching 0
          valleyCount++;
        }
      } else if (step == 'D') {
        level--;
        if (level < 0) {
          inValley = true;
        }
      }
    }

    return valleyCount;
  }
}
