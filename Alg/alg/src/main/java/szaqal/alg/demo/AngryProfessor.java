package szaqal.alg.demo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/angry-professor/problem?isFullScreen=true
 */
public class AngryProfessor {
    public static String angryProfessor(int k, List<Integer> a) {
        long collect = a.stream().filter(x -> x <= 0).count();
        return collect >= k ? "NO" : "YES";
    }
}
