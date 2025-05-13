package szaqal.alg.demo;

//https://www.hackerrank.com/challenges/migratory-birds/problem?isFullScreen=true

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MigratoryBirds {

  public static int migratoryBirds( List<Integer> arr ) {
    return arr.stream()
        .collect(groupingBy(x -> x, counting()))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue()).get()
        .getKey();

  }
}
