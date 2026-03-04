package szaqal.alg.demo;

/**
 * https://www.hackerrank.com/challenges/find-digits/problem?isFullScreen=true
 */
public class FindDigits {

    public static int findDigits(int n) {
        int found = 0;

        char[] charArray = String.valueOf(n).toCharArray();
        for (char x : charArray) {

            int i = Integer.parseInt(String.valueOf(x));
            if (i!=0 && n % i == 0) {
                found++;
            }
        }
        return found;
    }
}
