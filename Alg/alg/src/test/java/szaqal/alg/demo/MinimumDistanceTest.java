package szaqal.alg.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDistanceTest {

  @Test
  public void testMinimumDistance() {
    assertEquals(3, MinimumDistance.minimumDistances(List.of(7, 1, 3, 4, 1, 7)));
  }
}
