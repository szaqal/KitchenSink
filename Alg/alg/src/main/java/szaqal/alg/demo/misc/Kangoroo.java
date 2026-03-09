package szaqal.alg.demo.misc;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true
 */
public class Kangoroo {
    /**
     * Determines if two kangaroos will land on the same position.
     * 
     * Mathematical solution (O(1)):
     * - Kangaroo 2 can only catch up if v1 > v2
     * - They meet when: x1 + n*v1 = x2 + n*v2
     * - Rearranged: n = (x2 - x1) / (v1 - v2)
     * - They meet iff (x2 - x1) is divisible by (v1 - v2)
     * 
     * Example: x1=0, v1=3, x2=4, v2=2
     * - distance = 4, relativeSpeed = 1
     * - 4 % 1 = 0 → YES
     * - Proof: positions are [0,3,6,9,12] and [4,6,8,10,12] - meet at 12
     *
     * @param x1 starting position of kangaroo 1
     * @param v1 jump distance of kangaroo 1
     * @param x2 starting position of kangaroo 2
     * @param v2 jump distance of kangaroo 2
     * @return "YES" if they meet, "NO" otherwise
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Kangaroo 2 can only catch up if it's jumping faster
        if (v1 <= v2) {
            return "NO";
        }

        int distance = x2 - x1;
        int relativeSpeed = v1 - v2;

        return distance % relativeSpeed == 0 ? "YES" : "NO";
    }

    /**
     * Original iterative approach - kept for reference (inefficient)
     */
    public static String kangarooOriginal(int x1, int v1, int x2, int v2) {
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
