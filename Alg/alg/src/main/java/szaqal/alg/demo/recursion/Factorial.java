package szaqal.alg.demo.recursion;

import java.math.BigInteger;

/**
 * Calculates factorial values for large numbers.
 * 
 * <p>See: <a href="https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true">
 * Extra Long Factorials - HackerRank</a></p>
 * 
 * <p>This implementation uses {@link BigInteger} to handle arbitrarily large results
 * that would overflow primitive types.</p>
 * 
 * @author [Author]
 * @version 1.0
 */
public class Factorial {

    /**
     * Prints the extra long factorial of n to standard output.
     * 
     * <p>Note: This method uses an iterative approach to avoid StackOverflowError
     * for large values of n.</p>
     * 
     * @param n the non-negative integer to calculate factorial for
     * @throws IllegalArgumentException if n is negative
     */
    public static void extraLongFactorials(int n) {
        System.out.println(factorial(n));
    }

    /**
     * Calculates the factorial of a non-negative integer n.
     * 
     * <p>The factorial of n (denoted n!) is the product of all positive integers
     * less than or equal to n. By definition, 0! = 1.</p>
     * 
     * <p>Examples:</p>
     * <ul>
     *   <li>factorial(0) = 1</li>
     *   <li>factorial(1) = 1</li>
     *   <li>factorial(5) = 120</li>
     *   <li>factorial(20) = 2432902008176640000</li>
     * </ul>
     * 
     * <p><b>Implementation notes:</b></p>
     * <ul>
     *   <li>Uses iterative approach to avoid StackOverflowError for large n</li>
     *   <li>Uses {@link BigInteger} to handle results beyond primitive type limits</li>
     *   <li>Time complexity: O(n)</li>
     *   <li>Space complexity: O(1) - constant space excluding the result</li>
     * </ul>
     * 
     * @param n the non-negative integer to calculate factorial for
     * @return the factorial of n as a {@link BigInteger}
     * @throws IllegalArgumentException if n is negative
     */
    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial undefined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Main method for testing the factorial calculation.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        extraLongFactorials(2);
    }
}
