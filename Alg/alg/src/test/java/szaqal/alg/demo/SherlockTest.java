package szaqal.alg.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SherlockTest {
    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(String input, String expected) {
        assertEquals(expected, Sherlock.isValid(input));
    }

    @Test
    public void test2() throws Exception {
        String longString = Files.readString(Paths.get("src/test/resources/sherlock.txt"));
        assertEquals("YES", Sherlock.isValid(longString));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of("abcdefghhgfedecba", "YES"),
                Arguments.of("abc", "YES"),
                Arguments.of("abccc", "NO"),
                Arguments.of("aaabbbcccc", "YES"),
                Arguments.of("aabbccddeefghi", "NO")
        );
    }
}
