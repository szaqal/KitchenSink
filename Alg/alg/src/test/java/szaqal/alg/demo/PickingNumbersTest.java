package szaqal.alg.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PickingNumbersTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Integer> input, int expected) {
        assertEquals(expected, PickingNumbers.pickingNumbers(input));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(List.of(4, 6, 5, 3, 3, 1), 3),
                Arguments.of(fromStr1(), 30),
                Arguments.of(fromStr2(), 22)
        );

    }

    private static List<Integer> fromStr1() {
        String[] split = "7 12 13 19 17 7 3 18 9 18 13 12 3 13 7 9 18 9 18 9 13 18 13 13 18 18 17 17 13 3 12 13 19 17 19 12 18 13 7 3 3 12 7 13 7 3 17 9 13 13 13 12 18 18 9 7 19 17 13 18 19 9 18 18 18 19 17 7 12 3 13 19 12 3 9 17 13 19 12 18 13 18 18 18 17 13 3 18 19 7 12 9 18 3 13 13 9 7".split("\\s+");
        return Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList());
    }

    private static List<Integer> fromStr2() {
        String[] split = "4 2 3 4 4 9 98 98 3 3 3 4 2 98 1 98 98 1 1 4 98 2 98 3 9 9 3 1 4 1 98 9 9 2 9 4 2 2 9 98 4 98 1 3 4 9 1 98 98 4 2 3 98 98 1 99 9 98 98 3 98 98 4 98 2 98 4 2 1 1 9 2 4".split("\\s+");
        return Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList());
    }
}
