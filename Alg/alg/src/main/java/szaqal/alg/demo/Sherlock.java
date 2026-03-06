package szaqal.alg.demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true
 */
public class Sherlock {

    public static String isValid(String s) {
        Map<Character, Long> list = s.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        int allowedChange = 1;
        long prevCount = 0;
        for (Map.Entry<Character, Long> entries : list.entrySet()) {
            if (prevCount == 0) {
                prevCount = entries.getValue();
            } else {
                if (prevCount != entries.getValue()) {
                    long numberOfChangeRequired = Math.abs(entries.getValue() - prevCount);
                    allowedChange-= (int) numberOfChangeRequired;
                }
            }
            if (allowedChange < 0) {
                return "NO";
            }
        }
        return "YES";
    }
}
