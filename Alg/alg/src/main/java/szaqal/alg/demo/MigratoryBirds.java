package szaqal.alg.demo;

//https://www.hackerrank.com/challenges/migratory-birds/problem?isFullScreen=true

import java.util.List;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MigratoryBirds {

  /**
   * Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type.
   */
  public static int migratoryBirds( List<Integer> arr ) {
    return arr.stream()
        .collect(groupingBy(x -> x, counting()))
        .entrySet()
        .stream()
        .max(comparingByValue()).get()
        .getKey();

  }
}
