package szaqal.alg.demo;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/birthday-cake-candles
public class BirthDayCandle {
  public static int birthdayCakeCandles( List<Integer> candles ) {

    Optional<Long> max = candles.stream()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .values().stream().max(Long::compareTo);
    return max.map(Long::intValue).orElseThrow();
  }
}
