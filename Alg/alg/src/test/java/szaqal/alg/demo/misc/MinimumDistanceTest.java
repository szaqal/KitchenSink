package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Test;
import szaqal.alg.demo.misc.MinimumDistance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDistanceTest {

  @Test
  public void testMinimumDistance() {
    assertEquals(3, MinimumDistance.minimumDistances(List.of(7, 1, 3, 4, 1, 7)));
    assertEquals(3, MinimumDistance.minimumDistancesOriginal(List.of(7, 1, 3, 4, 1, 7)));
  }
}
