package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class RepeatedStringTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(String input, int n, int expected) {
        Assertions.assertEquals(expected, RepeatedString.repeatedString(input, n));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of("aba", 10, 7)
        );
    }
}
