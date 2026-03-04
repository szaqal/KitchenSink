package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class FactorialTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(int count, int expected) {
        Assertions.assertEquals(expected, Factorial.factorial(count).longValue());
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(10, 3628800)
        );
    }
}
