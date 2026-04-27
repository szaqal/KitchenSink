package szaqal.alg.demo.stack;

class Stack {
  private int size;
  private char[] arr;
  private int top;

  public Stack( int size ) {
    arr = new char[size];
    top = 0;
    this.size = size;
  }

  public void push( char value ) {
    arr[++top] = value;
  }

  public char pop() {
    return arr[top--];
  }

  public char peek() {
    return arr[top];
  }

  public boolean isEmpty() {
    return (top == -1);
  }
}

public class BracketChecker {

  private String input;
  private Stack stack;

  public BracketChecker( String input ) {
    stack = new Stack(input.length());
    this.input = input;
  }

  public boolean check() {
    char[] chars = input.toCharArray();
    for (char chr : chars) {
      switch (chr) {
        case '{', '[', '(' -> stack.push(chr);
        case '}', ']', ')' -> {
          if (!stack.isEmpty()) {
            char chx = stack.pop();
            if ((chr == '}' && chx != '{') ||
                (chr == ']' && chx != '[') ||
                (chr == ')' && chx != '('))
              return false;
          }
        }
        default -> {}
      }
    }
    return true;
  }

}
