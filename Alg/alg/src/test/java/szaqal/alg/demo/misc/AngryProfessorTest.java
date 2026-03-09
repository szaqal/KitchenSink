package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AngryProfessorTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Integer> input, Integer expectedCount, String expectedResult) {
        Assertions.assertEquals(expectedResult, AngryProfessor.angryProfessor(expectedCount, input));
        assertEquals(expectedResult, AngryProfessor.angryProfessorOptimized(expectedCount, input));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of(List.of(-1, -3, 4, 2), 3, "YES"),
                Arguments.of(List.of(0, -1, 2, 1), 2, "NO"),
                Arguments.of(List.of(-2, -1, 0, 1, 2), 3, "NO")
        );
    }
}
