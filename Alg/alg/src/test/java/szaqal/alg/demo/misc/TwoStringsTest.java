package szaqal.alg.demo.misc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoStringsTest {
    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test( String s1, String s2, String expected) {
        assertEquals(expected, TwoStrings.twoStrings(s1, s2));
        assertEquals(expected, TwoStrings.tooSlow(s1, s2));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of("and", "arg", "YES")
        );
    }
}
