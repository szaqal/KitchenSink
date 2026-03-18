package szaqal.alg.demo.misc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dummy {

  public static List<Character> characterDups(String aa) {
    return aa.chars().mapToObj(x-> (char) x)
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(x -> x.getValue() > 1)
        .map(Map.Entry::getKey).toList();
  }

  public static boolean isAnagram(String str1, String str2) {

    if(str1.length() != str2.length()) {
      return false;
    }

    Map<Character, Long> chars1 = str1
            .chars()
            .mapToObj(x->(char)x)
            .collect(Collectors.groupingBy(x->x, Collectors.counting()));

    Map<Character, Long> chars2 = str2
            .chars()
            .mapToObj(x->(char)x)
            .collect(Collectors.groupingBy(x->x, Collectors.counting()));


    return chars1.equals(chars2);
  }

  public static boolean isAnagram2(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    int[] count = new int[256];
    for (int i = 0; i < str1.length(); i++) {
      count[str1.charAt(i)]++;
      count[str2.charAt(i)]--;
    }

    for (int c : count) {
      if (c != 0) {
        return false;
      }
    }
    return true;
  }

  public static int vovelsCount(String message) {
    return (int) message.chars()
            .mapToObj(x->(char)x)
            .filter(x -> Set.of('a', 'e', 'i', 'o', 'u').contains(x))
            .count();
  }
}
