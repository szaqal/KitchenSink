package szaqal.alg.demo.misc;

/**
 * https://www.hackerrank.com/challenges/find-digits/problem?isFullScreen=true
 */
public class FindDigits {

    public static int findDigits(int n) {
        int found = 0;


        char[] charArray = String.valueOf(n).toCharArray();
        for (char x : charArray) {
            //Integer.parseInt(String.valueOf(x)) is expensive
            int i = Character.getNumericValue(x);
            if (i!=0 && n % i == 0) {
                found++;
            }
        }
        return found;
    }
}
