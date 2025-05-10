package szaqal.alg.demo;

import java.util.List;
import java.util.stream.Collectors;

//Hackerrank min-max sum
public class MinMaxSum {
    public static void miniMaxSum(List<Integer> arr) {


        int min = arr.stream().min(Integer::compare).orElse(0);
        int max = arr.stream().max(Integer::compare).orElse(0);
        var sumMin = arr.stream().filter(x -> x < max).mapToLong(x -> x).sum();
        if(sumMin ==0) {
            sumMin = arr.stream().mapToInt(x->x).sum()-arr.get(0);
        }
        var sumMax = arr.stream().filter(x -> x > min).mapToLong(x -> x).sum();
        if(sumMax ==0) {
            sumMax = arr.stream().mapToInt(x->x).sum()-arr.get(0);
        }
        System.out.printf("%d %d", sumMin, sumMax);
    }


    public static void main(String[] args) {
        //miniMaxSum(List.of(1,2,3,4,5));
        miniMaxSum(List.of(769082435,210437958,673982045,375809214,380564127));
    }

}
