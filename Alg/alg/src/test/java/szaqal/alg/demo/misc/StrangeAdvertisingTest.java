package szaqal.alg.demo.misc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import szaqal.alg.demo.misc.StrangeAdvertising;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrangeAdvertisingTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(int count, int expected) {
        assertEquals(expected, StrangeAdvertising.viralAdvertising(count));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(1, 2),
                Arguments.of(2, 5),
                Arguments.of(3, 9),
                Arguments.of(4, 15),
                Arguments.of(5, 24)
        );
    }
}
