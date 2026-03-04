package szaqal.alg.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PickingNumbersTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Integer> input, int expected) {
        assertEquals(expected, PickingNumbers.pickingNumbers(input));
    }

    private static List<Arguments> argumentsList () {
        return List.of(Arguments.of(List.of(4, 6, 5, 3, 3, 1), 3));
    }
}
