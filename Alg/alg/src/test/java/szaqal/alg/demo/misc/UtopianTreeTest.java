package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class UtopianTreeTest {
    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(Integer input, Integer expected) {
        Assertions.assertEquals(expected, UtopianTree.utopianTree(input));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(0,1),
                Arguments.of(1,2),
                Arguments.of(2,3),
                Arguments.of(3,6),
                Arguments.of(4,7)
        );
    }
}
