package szaqal.alg.demo;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true
 */
public class Kangoroo {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int prevGap = 0;
        boolean first = true;
        while (true) {
            x1 += v1;
            x2 += v2;

            int currentGap = Math.abs(x1 - x2);
            if (currentGap == 0) {
                return "YES";
            }
            //The gap needs to shrink
            if (!first && currentGap > prevGap || prevGap == currentGap) {
                return "NO";
            }

            prevGap = currentGap;
            first = false;
        }
    }
}
