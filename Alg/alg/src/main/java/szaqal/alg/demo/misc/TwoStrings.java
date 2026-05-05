package szaqal.alg.demo.misc;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/two-strings/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
      Set<Character> aaa = s1.chars().mapToObj(x->(char)x).collect(Collectors.toSet());
      for(char y: s2.toCharArray()) {
        if(aaa.contains(y)) {
          return "YES";
        }
      }
      return "NO";
    }


    public static String tooSlow(String s1, String s2) {
      for(char x : s1.toCharArray()) {
        for(char y: s2.toCharArray()) {
          if(x==y) {
            return "YES";
          }
        }
      }
      return "NO";
    }
}
