package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static szaqal.alg.demo.BirthDayCandle.birthdayCakeCandles;
import static szaqal.alg.demo.BirthDayCandle.birthdayCakeCandlesOptimized;

public class BirthDayCandleTest {

  @Test
  public void test() {
    Assertions.assertEquals(2, birthdayCakeCandles(List.of(3,2,1,3))); ;
    Assertions.assertEquals(2, birthdayCakeCandlesOptimized(List.of(3,2,1,3)));
  }
}
