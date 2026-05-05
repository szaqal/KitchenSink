package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class DivisibleSumTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Integer> input, int divisor, int expected) {
        Assertions.assertEquals(expected, DivisibleSum.divisibleSumPairs(input.size(),divisor,input));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(new ArrayList<>(List.of(1, 3, 2, 6, 1, 2)), 3, 5)
        );
    }
}
