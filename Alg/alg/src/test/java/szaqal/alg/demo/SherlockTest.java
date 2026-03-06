package szaqal.alg.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SherlockTest {
    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(String input, String expected) {
        assertEquals(expected, Sherlock.isValid(input));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of("abcdefghhgfedecba", "YES"),
                Arguments.of("abc", "YES"),
                Arguments.of("abccc", "NO"),
                Arguments.of("aaabbbcccc", "YES"),
                Arguments.of("aabbccddeefghi", "NO")
        );
    }
}
