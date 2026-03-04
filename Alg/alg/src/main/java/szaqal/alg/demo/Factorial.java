package szaqal.alg.demo;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true
 */
public class Factorial {

    public static void extraLongFactorials(int n) {
        System.out.println(factorial(n));
    }

    public static long factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        extraLongFactorials(2);
    }
}
