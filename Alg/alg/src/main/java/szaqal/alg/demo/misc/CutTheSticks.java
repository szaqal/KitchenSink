package szaqal.alg.demo.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks/problem?isFullScreen=true
 */
public class CutTheSticks {

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();

        while(!arr.isEmpty()) {
            result.add(arr.size());
            Integer min = Collections.min(arr);
            Iterator<Integer> iterator = arr.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next - min <= 0) {
                    iterator.remove();
                }
            }
        }
        return result;
    }
}
