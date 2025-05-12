package szaqal.alg.demo;

import java.util.List;

//https://www.hackerrank.com/challenges/pairs
public class Pairs {
    public static int pairs(int k, List<Integer> list) {
        Integer[] arr = list.toArray(new Integer[list.size()]);

        int count = 0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i;j<arr.length;j++) {
                if(Math.abs(arr[i] - arr[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
