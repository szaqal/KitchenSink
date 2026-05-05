package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class CutTheSticksTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Integer> input, List<Integer> expected) {
        Assertions.assertEquals(expected, CutTheSticks.cutTheSticks(input));
    }


    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test2(List<Integer> input, List<Integer> expected) {
        Assertions.assertEquals(expected, CutTheSticks.cutTheSticks2(input));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(new ArrayList<>(List.of(1,2,3)), List.of(3,2,1)),
                Arguments.of(new ArrayList<>(List.of(5, 4, 4, 2, 2, 8)), List.of(6,4,2,1)),
                Arguments.of(new ArrayList<>(List.of(1,2,3,4,3,3,2,1)), List.of(8,6,4,1))
        );
    }
}
