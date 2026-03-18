package szaqal.alg.demo.misc;

public class UtopianTree {

    public static int utopianTree(int cycles) {
        if(cycles==0) {
            return 1;
        }

        int height=1;
        for(int i=0;i<cycles;i++) {
            if(i%2==1) {
                height +=1;
            } else {
                height = 2* height;
            }
        }

        return height;
    }
}
