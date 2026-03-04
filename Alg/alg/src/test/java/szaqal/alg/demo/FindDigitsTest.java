package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class FindDigitsTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(int input, int expected) {
        Assertions.assertEquals(expected, FindDigits.findDigits(input));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of(124, 3)
        );
    }
}
