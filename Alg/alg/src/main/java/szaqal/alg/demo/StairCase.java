package szaqal.alg.demo;

//https://www.hackerrank.com/challenges/staircase
public class StairCase {
    public static void staircase(int n) {

        for(int i=0;i<n;i++) {
            int spaceCount = n - i -1;
            int hashCount = i + 1;
            System.out.println(" ".repeat(spaceCount) + "#".repeat(hashCount));
        }
    }
}
