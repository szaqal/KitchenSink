package szaqal.alg.demo.misc;

import java.util.Stack;

public class ReverseString {

  //Classic in-place swap - optimal O(n) time, O(1) space
  public static String reverse( String input ) {
    char[] charArray = input.toCharArray();
    for (int i = 0; i < charArray.length / 2; i++) {
      char tmp = charArray[i];
      int i1 = charArray.length - (i + 1);
      charArray[i] = charArray[i1];
      charArray[i1] = tmp;
    }
    return String.valueOf(charArray);
  }

  public static String reverseStack(String input) {
    Stack<Character> charStack = new Stack<>();
    char[] chars = input.toCharArray();
    for(var chr : chars) {
      charStack.add(chr);
    }

    char[] reversed = new char[chars.length];

    int i=0;
    while(!charStack.isEmpty()) {
      reversed[i] = charStack.pop();
      i++;
    }
    return String.valueOf(reversed);

  }
}
