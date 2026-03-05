package szaqal.alg.demo;

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
    int lastIdx = size -1;


    //1,2,3
    //3,1,2
    //2,3,1
    for (int i=0;i<k;i++) {
      int last = list.get(lastIdx);
      for(int idx = size-1;idx>0;idx--) {
        list.set(idx, list.get(idx-1));
      }
      list.set(0, last);
    }


    return queries.stream().map(list::get).collect(Collectors.toList());
  }
}
