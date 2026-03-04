package szaqal.alg.demo;

import java.util.List;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/birthday-cake-candles
public class BirthDayCandle {

  /**
   * candles = [4,4,1,3]
   * 4 => 2 .
   */
  public static int birthdayCakeCandles( List<Integer> candles ) {

    return candles.stream()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .values()
            .stream()
            .max(Long::compareTo)
            .map(Long::intValue)
            .orElseThrow();
  }
}
