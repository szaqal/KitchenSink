package szaqal.alg.demo;

public class StrangeAdvertising {

    public static int viralAdvertising(int n) {
        int shared=5;
        int liked=0;
        int cumlative=0;
        for(int day= 1;day<=n;day++) {
            if(day==1) {
                shared =5;
                liked = (int) Math.floor((double) 5 /2);
            } else {
                shared = liked *3;
                liked = (int) Math.floor((double) shared /2);
            }
            cumlative+=liked;
            System.out.println("%d %d %d %d".formatted(day, shared, liked, cumlative));
        }

        return cumlative;
    }
}
