package szaqal.alg.demo.misc;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1/problem?isFullScreen=true
 */
public class Caesar {
    public static String caesarCipher(String s, int k) {
        char[] alphabeth = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] input = s.toCharArray();
        char[] result = new char[input.length];
        for (int j = 0; j < input.length; j++) {
            int foundIdx = -1;
            for (int i = 0; i < alphabeth.length; i++) {
                if (alphabeth[i] == input[j] || alphabeth[i] == Character.toLowerCase(input[j])) {
                    foundIdx = i;
                    break;
                }
            }

            if (foundIdx != -1) {
                int newIdx = foundIdx + k;
                if (newIdx >= alphabeth.length) {
                    newIdx = newIdx % alphabeth.length;
                }

                result[j] = Character.isUpperCase(input[j]) ? Character.toUpperCase(alphabeth[newIdx]): alphabeth[newIdx];
            } else {
                result[j] = input[j];
            }
        }
        return String.valueOf(result);
    }
}
