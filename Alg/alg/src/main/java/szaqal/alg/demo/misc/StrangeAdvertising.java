package szaqal.alg.demo.misc;

/**
 * https://www.hackerrank.com/challenges/strange-advertising/problem?isFullScreen=true
 */
public class StrangeAdvertising {

    public static int viralAdvertising(int n) {
        int shared = 5;
        int liked = 0;
        int cumlative = 0;
        for (int day = 1; day <= n; day++) {
            shared = (day == 1) ? shared : liked * 3;
            liked = (int) (double) shared / 2;
            cumlative += liked;
            //System.out.println("%d %d %d %d".formatted(day, shared, liked, cumlative));
        }

        return cumlative;
    }
}
