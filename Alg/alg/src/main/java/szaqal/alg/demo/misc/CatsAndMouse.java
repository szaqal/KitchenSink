package szaqal.alg.demo.misc;

/**
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/problem?isFullScreen=true
 */
public class CatsAndMouse {

    static String catAndMouse(int x, int y, int z) {
        var catA = "Cat A";
        var catB = "Cat B";
        var mouseC = "Mouse C";

        int distA = Math.abs(x - z);
        int distB = Math.abs(y - z);
        if(distA == distB) {
            return mouseC;
        } else if(distA > distB) {
            return catB;
        } else {
            return catA;
        }
    }
}
