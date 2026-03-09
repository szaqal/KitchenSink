package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static szaqal.alg.demo.CamelCase.*;

public class CamelCaseTest {

    @ParameterizedTest
    @MethodSource("camelCaseArguments")
    public void testCamelCase(String input, int expected) {
        Assertions.assertEquals(expected, camelCase(input));
    }

    @ParameterizedTest
    @MethodSource("camelCase3Arguments")
    public void testCamelCase3(String input, int expected) {
        Assertions.assertEquals(expected, camelCase3(input));
    }

    @ParameterizedTest
    @MethodSource("camelCase2Arguments")
    public void testCamelCase2(String input, int expected) {
        Assertions.assertEquals(expected, camelCase2(input));
    }

    @ParameterizedTest
    @MethodSource("camelCase4Arguments")
    public void testCamelCase4(String input, int expected) {
        Assertions.assertEquals(expected, camelCase4(input));
    }

    @ParameterizedTest
    @MethodSource("camelCaseOptimizedArguments")
    public void testCamelCaseOptimized(String input, int expected) {
        Assertions.assertEquals(expected, camelCaseOptimized(input));
    }

    private static List<Arguments> camelCaseArguments() {
        return List.of(
                Arguments.of("saveChangesInTheEditor", 5)
        );
    }

    private static List<Arguments> camelCase3Arguments() {
        return List.of(
                Arguments.of("saveChangesInTheEditor", 5)
        );
    }

    private static List<Arguments> camelCase2Arguments() {
        return List.of(
                Arguments.of("saveChangesInTheEditor", 5)
        );
    }

    private static List<Arguments> camelCase4Arguments() {
        return List.of(
                Arguments.of("saveChangesInTheEditor", 5)
        );
    }

    private static List<Arguments> camelCaseOptimizedArguments() {
        return List.of(
                Arguments.of("saveChangesInTheEditor", 5)
        );
    }
}
