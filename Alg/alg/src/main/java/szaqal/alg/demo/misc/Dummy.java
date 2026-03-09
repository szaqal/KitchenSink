package szaqal.alg.demo.misc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dummy {

  public static List<Character> characterDups(String aa) {
    char[] chars = aa.toCharArray(); //No Arrays.stream(char[] ) exists
    List<Character> characters = new ArrayList<>();
    for (var chr : chars) {
      characters.add(chr);
    }

    return characters.stream()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(x -> x.getValue() > 1)
        .map(Map.Entry::getKey).toList();
  }

  public static boolean isAnagram(String str1, String str2) {

    Set<Character> chars1 = new HashSet<>();
    Set<Character> chars2 = new HashSet<>();
    if(str1.length() != str2.length()) {
      return false;
    }

    char[] str1Arr = str1.toCharArray();
    char[] str2Arr = str2.toCharArray();

    for (int i=0;i < str1.length();i++) {
      chars1.add(str1Arr[i]);
      chars2.add(str2Arr[i]);
    }
    return chars1.equals(chars2);
  }

  public static int vovelsCount(String message) {
        char[] chars = message.toCharArray(); //No Arrays.stream(char[] ) exists
    List<Character> characters = new ArrayList<>();
    for (var chr : chars) {
      characters.add(chr);
    }

    return (int) characters.stream().filter(x -> Set.of('a', 'e', 'i', 'o', 'u').contains(x)).count();
  }
}
