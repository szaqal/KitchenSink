package szaqal.alg.demo.misc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static szaqal.alg.demo.misc.Caesar.caesarCipher;

public class CaesarTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(String input, int shift, String expected) {
        assertEquals(expected, caesarCipher(input, shift));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of("abc",1,"bcd"),
                Arguments.of("a-c",1,"b-d"),
                Arguments.of("z",1,"a"),
                Arguments.of("middle-Outz", 2, "okffng-Qwvb")
        );
    }
}
