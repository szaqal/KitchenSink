package szaqal.alg.demo;

import java.util.List;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/birthday-cake-candles
public class BirthDayCandle {
  public static int birthdayCakeCandles( List<Integer> candles ) {

    return candles.stream()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .values().stream().max(Long::compareTo).map(Long::intValue).orElseThrow();
  }
}
