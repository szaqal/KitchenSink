package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class JumpingTheCloudsTest {


    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Integer> input, int expected) {
        Assertions.assertEquals(expected, JumpingTheClouds.jumpingOnClouds(input));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of(List.of(0,0,1,0,0,1,0), 4),
                Arguments.of(List.of(0, 0, 0, 1, 0, 0), 3)
        );
    }
}
