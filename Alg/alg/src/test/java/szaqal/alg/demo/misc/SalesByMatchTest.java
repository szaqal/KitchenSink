package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class SalesByMatchTest {
    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Integer> input, int expected) {
        Assertions.assertEquals(expected, SalesByMatch.sockMerchant(input.size(), input));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(List.of(10,20,20,10,10,30,50,10,20), 3)
        );
    }
}
