package szaqal.alg.demo.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSwapsTest {

  @Test
  public void test() {
    assertEquals(3, MinimumSwaps.minimumSwaps(new int[]{4,3,1,2})); ;
  }
}
