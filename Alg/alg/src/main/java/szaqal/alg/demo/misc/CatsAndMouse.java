package szaqal.alg.demo.misc;

/**
 * Determines which cat will catch the mouse or if both cats reach the mouse at the same time.
 * 
 * <p>Given two cats at positions x and y, and a mouse at position z, the cat closer to the mouse wins.
 * If both cats are at the same distance, the mouse escapes.</p>
 * 
 * <h2>Code Review Notes:</h2>
 * <ul>
 *   <li><b>Magic Strings:</b> The return values "Cat A", "Cat B", "Mouse C" are hardcoded.
 *     Consider using constants or an enum for better maintainability:
 *     <pre>
 *     enum Winner { CAT_A, CAT_B, MOUSE_C }
 *     </pre></li>
 *   
 *   <li><b>Unnecessary Variables:</b> The local variables {@code catA}, {@code catB}, {@code mouseC}
 *     are assigned but never modified. They can be replaced with inline string literals or
 *     constants to reduce verbosity.</li>
 *   
 *   <li><b>No Input Validation:</b> No bounds checking on parameters. While acceptable for
 *     challenge code, consider adding validation for production use.</li>
 * </ul>
 * 
 * @param x position of Cat A
 * @param y position of Cat B
 * @param z position of Mouse C
 * @return "Cat A" if Cat A is closer, "Cat B" if Cat B is closer, "Mouse C" if equidistant
 * @see <a href="https://www.hackerrank.com/challenges/cats-and-a-mouse/problem">Cats and a Mouse - HackerRank</a>
 */
public class CatsAndMouse {

    public static String catAndMouse(int x, int y, int z) {
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
