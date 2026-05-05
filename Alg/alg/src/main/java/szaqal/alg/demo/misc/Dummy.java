package szaqal.alg.demo.misc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dummy {

  /**
   * Character duplicates
   */
  public static List<Character> characterDups(String input) {
    return input.chars().mapToObj(x-> (char) x)
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(x -> x.getValue() > 1)
        .map(Map.Entry::getKey).toList();
  }

  // ----------------- Reverse string

  public static String reverse(String str1) {
    Stack<Character> charStack = new Stack<>();
    str1.chars().mapToObj(x->(char)x).forEach(charStack::push);
    StringBuilder builder = new StringBuilder();

    while(!charStack.isEmpty()) {
      builder.append(charStack.pop());
    }
    return builder.toString();
  }

  public static String reverse2(String str1) {
    Deque<Character> charStack = new ArrayDeque<>();
    str1.chars().mapToObj(x->(char)x).forEach(charStack::push);
    return charStack.stream().map(String::valueOf).collect(Collectors.joining());
  }

  public static String reverse3(String str1) {
    return str1.chars().mapToObj(x->(char)x)
        .collect(ArrayDeque::new, ArrayDeque::push, ArrayDeque::addAll)
        .stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  // ------------------- Anagram

  public static boolean isAnagram(String str1, String str2) {

    if(str1.length() != str2.length()) {
      return false;
    }

    Map<Character, Long> chars1 = str1
            .chars()
            .mapToObj(x->(char)x)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    Map<Character, Long> chars2 = str2
            .chars()
            .mapToObj(x->(char)x)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


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

  // -------------------

  public static int vovelsCount(String message) {
    return (int) message.chars()
            .mapToObj(x->(char)x)
            .filter(x -> Set.of('a', 'e', 'i', 'o', 'u').contains(x))
            .count();
  }
}
