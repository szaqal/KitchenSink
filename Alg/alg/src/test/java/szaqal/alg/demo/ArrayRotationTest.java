package szaqal.alg.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static szaqal.alg.demo.ArrayRotation.circularArrayRotation;

public class ArrayRotationTest {

    @Disabled
    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test( List<Integer> input, int count, List<Integer> queries, List<Integer> expected) {
        assertEquals(expected, circularArrayRotation(input, count, queries));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(new ArrayList<>(){{
                  add(1);
                  add(2);
                  add(3);
                }}, 2, List.of(0,1,2), List.of(2,3,1))
        )
            ;
    }
}
