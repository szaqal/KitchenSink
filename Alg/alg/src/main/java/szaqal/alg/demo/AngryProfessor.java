package szaqal.alg.demo;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/angry-professor/problem?isFullScreen=true
 */
public class AngryProfessor {
    
    /**
     * Original implementation - processes entire list with stream overhead.
     * 
     * Performance issues:
     * - O(n) always, no early termination even when k on-time students found early
     * - Stream API pipeline allocation overhead
     * - Autoboxing from Integer to int in filter lambda
     */
    public static String angryProfessor(int k, List<Integer> a) {
        long collect = a.stream().filter(x -> x <= 0).count();
        return collect >= k ? "NO" : "YES";
    }

    /**
     * Optimized implementation with early termination and reduced overhead.
     * 
     * Optimization findings:
     * - Short-circuit: Returns immediately when k on-time students are found (O(k) best case vs O(n))
     * - No stream overhead: Direct iteration eliminates Stream pipeline allocation and intermediate operations
     * - No autoboxing: Uses primitive int in loop, avoiding Integer boxing/unboxing overhead
     * 
     * Original implementation issues:
     * - Counts ALL students even when answer is already determined
     * - Stream API adds object allocation overhead
     * - List<Integer> causes autoboxing on each iteration
     * 
     * @param k minimum number of on-time students required for class to NOT be cancelled
     * @param a list of student arrival times (negative/zero = on-time, positive = late)
     * @return "NO" if class is cancelled, "YES" otherwise
     */
    public static String angryProfessorOptimized(int k, List<Integer> a) {
        int onTimeCount = 0;
        for (int arrival : a) {
            if (arrival <= 0) {
                onTimeCount++;
                if (onTimeCount >= k) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

}
