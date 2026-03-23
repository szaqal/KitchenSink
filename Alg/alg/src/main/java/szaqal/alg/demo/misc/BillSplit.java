package szaqal.alg.demo.misc;

import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem?isFullScreen=true
 */
public class BillSplit {

    /**
     *
     * @param bill
     * @param annaDidntEat an integer representing the zero-based index of the item Anna doesn't eat
     * @param brianCharged the amount of money that Anna contributed to the bill
     * @return
     */
    public static String bonAppetit(List<Integer> bill, int annaDidntEat, int brianCharged) {
        int total = bill.stream().mapToInt(x -> x).sum();
        int subs = bill.get(annaDidntEat);
        int annaToCharge = (total - subs)/2;

        if(annaToCharge == brianCharged) {
            String s = "Bon Appetit";
            System.out.println(s);
            return s;
        }

        String s = String.valueOf(brianCharged - annaToCharge);
        System.out.println(s);
        return s;
    }
}
