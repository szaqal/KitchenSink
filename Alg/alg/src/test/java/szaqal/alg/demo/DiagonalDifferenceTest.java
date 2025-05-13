package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static szaqal.alg.demo.DiagonalDifference.diagonalDifference;

public class DiagonalDifferenceTest {

  @Test
  public void test() {
    //1 2 3
    //4 5 6
    //7 8 9
    List<List<Integer>> input = new ArrayList<>();
    input.add(List.of(1,2,3));
    input.add(List.of(4,5,6));
    input.add(List.of(9,8,9));

    Assertions.assertEquals(2, diagonalDifference(input));
  }
}
