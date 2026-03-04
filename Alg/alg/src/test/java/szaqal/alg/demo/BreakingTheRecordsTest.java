package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class BreakingTheRecordsTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Integer> input, List<Integer> expected) {
        Assertions.assertEquals(expected, BreakingTheRecords.breakingRecords(input));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of(List.of(10, 5, 20, 20, 4, 5, 2, 25, 1), List.of(2, 4))
        );
    }
}
