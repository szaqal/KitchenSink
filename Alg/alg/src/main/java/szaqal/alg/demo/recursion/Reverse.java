package szaqal.alg.demo.recursion;

import java.util.Arrays;

public class Reverse {

    public static int[] reverse(int[] toReverse, int start, int stop) {
        if (start < stop -1) {
            int tmp = toReverse[start];
            toReverse[start] = toReverse[stop-1];
            toReverse[stop-1] = tmp;
            reverse(toReverse, start+1, stop-1);
        }
        return toReverse;
    }
}
