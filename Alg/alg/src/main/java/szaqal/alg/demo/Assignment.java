package szaqal.alg.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
  public static void main(String[] args) {

    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    //letters number lowercase
    String list = strings.stream()
        .map(x->x.replaceAll("\\W+", ""))
        .map(x->x.replaceAll("\\d+",""))
        .map(String::toLowerCase).collect(Collectors.joining());

    // --->
    List<Character> list1 = list.chars().mapToObj(x -> (char) x).toList();

    Map<Character, Long> collect = list1.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

    for(var x : collect.entrySet()) {
      System.out.println("%s = %s".formatted(x.getKey(), x.getValue()));
    }
  }



}
