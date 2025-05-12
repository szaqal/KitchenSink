package szaqal.alg.demo;

import java.util.Collections;
import java.util.List;

//https://www.hackerrank.com/challenges/find-the-median
public class Median {
    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        double a = arr.size() / 2.0;
        return arr.get((int)Math.floor(a));
    }
}
