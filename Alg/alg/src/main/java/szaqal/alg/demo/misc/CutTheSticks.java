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
            Integer min = Collections.min(arr); //At each iteration you will determine the length of the shortest stick remaining
            Iterator<Integer> iterator = arr.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next - min <= 0) { //cut that length from each of the longer sticks
                    iterator.remove();
                }
            }
        }
        return result;
    }

    public static List<Integer> cutTheSticks2(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();

        while(!arr.isEmpty()) {
            result.add(arr.size());
            Integer min = Collections.min(arr); //At each iteration you will determine the length of the shortest stick remaining
            arr.removeIf(next -> next - min <= 0); //cut that length from each of the longer sticks
        }
        return result;
    }
}
