package szaqal.alg.demo.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class BalancedBrackets {

  public static String isBalanced( String s ) {
    char[] chars = s.toCharArray();

    Deque<Character> charStack = new ArrayDeque<>();

    for (var chr : chars) {
      if (chr == '{' || chr == '[' || chr == '(') {
        charStack.push(chr);
      } else {
        try {
          char pop = charStack.pop();
          if (chr == '}') {
            if (pop != '{') {
              return "NO";
            }
          } else if (chr == ']') {
            if (pop != '[') {
              return "NO";
            }
          } else if (chr == ')') {
            if (pop != '(') {
              return "NO";
            }
          }
        } catch ( NoSuchElementException e ) {
          // testcase "]()"
          return "NO";
        }
      }
    }
    if(!charStack.isEmpty()) {
      // test case "["
      return "NO";
    }
    return "YES";
  }
}
