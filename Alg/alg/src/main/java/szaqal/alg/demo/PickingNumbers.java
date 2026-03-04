package szaqal.alg.demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/picking-numbers/problem?isFullScreen=true
 */
public class PickingNumbers {

    public static int pickingNumbers(List<Integer> input) {

        Map<Integer, Long> collect = input.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        Long max = collect.values()
                .stream()
                .max(Long::compareTo)
                .orElse(Long.MIN_VALUE);

        int dominant = collect.entrySet()
                .stream()
                .filter(x->x.getValue().equals(max))
                .findFirst().map(Map.Entry::getKey).orElseThrow();


        int size = max.intValue();


        int nb1 = Optional.ofNullable(collect.get(dominant - 1)).map(Long::intValue).orElse(0);
        int nb2 = Optional.ofNullable(collect.get(dominant + 1)).map(Long::intValue).orElse(0);

        return Math.max(size+nb1, size+nb2);
    }

}
