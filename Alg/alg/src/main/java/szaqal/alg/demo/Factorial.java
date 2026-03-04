package szaqal.alg.demo;

import java.math.BigInteger;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true
 */
public class Factorial {

    public static void extraLongFactorials(int n) {
        System.out.println(factorial(n));
    }

    public static BigInteger factorial(int n) {
        if(n == 1) {
            return BigInteger.ONE;
        }


        return factorial(n-1).multiply(BigInteger.valueOf(n));
    }

    public static void main(String[] args) {
        extraLongFactorials(2);
    }
}
