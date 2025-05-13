package szaqal.alg.demo;

public class ReverseString {

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
}
