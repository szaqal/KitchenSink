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

        Long max = collect.values()
                .stream()
                .max(Long::compareTo)
                .orElse(Long.MIN_VALUE);

        List<Integer> dominants = collect.entrySet()
                .stream()
                .filter(x->x.getValue().equals(max))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        int size = max.intValue();

        int result = 0;
        for(var dominant : dominants) {
            int nb1 = Optional.ofNullable(collect.get(dominant - 1)).map(Long::intValue).orElse(0);
            int nb2 = Optional.ofNullable(collect.get(dominant + 1)).map(Long::intValue).orElse(0);
            var candidate = Math.max(size+nb1, size+nb2);
            if(candidate> result) {
                result = candidate;
            }
        }
        return result;
    }

}
