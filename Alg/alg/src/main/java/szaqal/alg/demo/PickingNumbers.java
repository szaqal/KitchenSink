package szaqal.alg.demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/picking-numbers/problem?isFullScreen=true
 */
public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {

        Map<Integer, Long> collect = a.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        List<Integer> sortedValues = collect.keySet().stream().sorted().collect(Collectors.toList());

        int size=0;
        for(int value : sortedValues) {
            int l = collect.get(value).intValue();
            int l1 = Optional.ofNullable(collect.get(value - 1)).map(Long::intValue).orElse(0);
            int l2 = Optional.ofNullable(collect.get(value + 1)).map(Long::intValue).orElse(0);
            int candSize = Math.max(l+l1, l+l2);
            if(candSize > size) {
                size=candSize;
            }

        }

        return size;
    }

}
