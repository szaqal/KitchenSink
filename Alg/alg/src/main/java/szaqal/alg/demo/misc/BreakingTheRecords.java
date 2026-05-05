package szaqal.alg.demo.misc;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?isFullScreen=true
 *
 * <ol>
 *   <li>Each season she maintains a record of her play.</li>
 *   <li>tabulates the number of times she breaks her season record for <b>most</b> points and <b>least</b> points in a game</li>
 * </ol>
 */
public class BreakingTheRecords {

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int lowestCount = 0;
        int highestCount = 0;
        int lowestScore = 0;
        int highestScore = 0;

        for (int i = 0; i < scores.size(); i++) {
            if (i == 0) {
                lowestScore = highestScore = scores.get(i);
            } else {
                var score = scores.get(i);
                if (score < lowestScore) {
                    lowestScore = score;
                    lowestCount++;
                } else if (score > highestScore) {
                    highestScore = score;
                    highestCount++;
                }
            }
        }
        return List.of(highestCount, lowestCount);
    }

}
