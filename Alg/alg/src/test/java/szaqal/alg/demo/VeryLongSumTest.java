package szaqal.alg.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VeryLongSumTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Long> input, long expected) {
        assertEquals(expected, VeryLongSum.aVeryBigSum(input));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(List.of(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L), 5000000015L))
            ;
    }
}
