package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CatsAndMouseTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(int catA, int catB, int mouseC, String expected) {
        Assertions.assertEquals(expected, CatsAndMouse.catAndMouse(catA, catB, mouseC));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of(2, 5, 4, "Cat B"),
                Arguments.of(3, 5, 4, "Mouse C")
        );
    }
}
