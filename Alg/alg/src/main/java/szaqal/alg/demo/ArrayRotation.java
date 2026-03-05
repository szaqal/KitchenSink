package szaqal.alg.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayRotation {

  /**
   * https://www.hackerrank.com/challenges/circular-array-rotation/problem?isFullScreen=true
   */
  public static List<Integer> circularArrayRotation(
      List<Integer> list,
      int k,
      List<Integer> queries ) {
    int size = list.size();
    int lastIdx = size - 1;
    int[] answer = list.stream().mapToInt(i -> i).toArray();  //perfomance requirement using list.get list.set was to slow

    //1,2,3
    //3,1,2
    //2,3,1
    for (int i = 0; i < k; i++) {
      int last = answer[lastIdx];
      for (int idx = size - 1; idx > 0; idx--) {
        answer[idx] = answer[idx - 1];
      }
      answer[0] = last;
    }

    List<Integer> list1 = new ArrayList<>();
    for (int i = 0; i < queries.size(); i++) {
      list1.add(answer[queries.get(i)]);
    }
    return list1;
  }
}
