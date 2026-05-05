package szaqal.alg.demo.misc;

/**
 * Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count the number of divisors occurring within the integer.
 * https://www.hackerrank.com/challenges/find-digits/problem?isFullScreen=true
 */
public class FindDigits {

  public static int findDigits( int n ) {
    int found = 0;

    char[] charArray = String.valueOf(n).toCharArray();
    for (char x : charArray) {
            /*
            This creates unnecessary object allocations:
                - char → String → Integer.parseInt()
             */
      int i = Character.getNumericValue(x);
      if (i != 0 && n % i == 0) {
        found++;
      }
    }
    return found;
  }

  public static int findDigits2( int n ) {
    int found = 0;

    while ( n > 0 ) {
      int i = Character.getNumericValue(n % 10);
      if (i != 0 && n % i == 0) {
        found++;
      }
      n /= 10;

    }
    return found;
  }
}
