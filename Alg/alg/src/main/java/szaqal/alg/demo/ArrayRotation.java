package szaqal.alg.demo;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayRotation {

  public static List<Integer> circularArrayRotation(
      List<Integer> a,
      int k,
      List<Integer> queries ) {
    int size = a.size();

    //1,2,3
    //3,1,2
    //2,3,1
    for (int i=0;i<k;i++) {
      for (int j=0;j<size;j++) {

      }
    }


    return queries.stream().map(a::get).collect(Collectors.toList());
  }
}
