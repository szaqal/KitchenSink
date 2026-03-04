package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class KangorooTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(int x1, int v1, int x2, int v2, String expected) {
        Assertions.assertEquals(expected, Kangoroo.kangaroo(x1, v1, x2, v2));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(0, 3, 4, 2, "YES"),
                Arguments.of(0, 2, 5, 3, "NO"),
                Arguments.of(1928, 4306, 5763, 4301, "YES"),
                Arguments.of(43, 2, 70, 2, "NO")
        );
    }
}
