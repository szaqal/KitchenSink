package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CountingValleysTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(String path, int expected) {
        Assertions.assertEquals(expected, CountingValleys.countingValleys(path.length(), path));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of("UDDDUDUU", 1),
                Arguments.of("DDUUDDUDUUUD", 2)
        );
    }
}
