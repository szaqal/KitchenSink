package szaqal.alg.demo.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class FibonnachiTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(int count, int expected) {
        Assertions.assertEquals(expected, Fibonnachi.fibonacci(count));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 5),
                Arguments.of(6, 8)
        );
    }
}
