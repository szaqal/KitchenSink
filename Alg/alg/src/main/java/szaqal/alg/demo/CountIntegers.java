package szaqal.alg.demo;

import java.util.List;
import java.util.stream.Collectors;

//Hacker rank count integers
public class CountIntegers {

    public static int simpleArraySum(List<Integer> ar) {
        return ar.stream().mapToInt(x -> x).sum();
    }

}
