package szaqal.alg.demo;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?isFullScreen=true
 */
public class BreakingTheRecords {

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int lowestCount = 0;
        int highestCount = 0;
        int lowest = 0;
        int highest = 0;

        for (int i = 0; i < scores.size(); i++) {
            if (i == 0) {
                lowest = highest = scores.get(i);
            } else {
                var score = scores.get(i);
                if (score < lowest) {
                    lowest = score;
                    lowestCount++;
                } else if (score > highest) {
                    highest = score;
                    highestCount++;
                }
            }
        }
        return List.of(highestCount, lowestCount);
    }

}
