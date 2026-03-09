package szaqal.alg.demo.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class BinarySearchTest {

    private static final int[] SORTED_ARRAY = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    @ParameterizedTest
    @MethodSource("findArguments")
    public void testFind(int[] values, int target, int low, int high, boolean expected) {
        Assertions.assertEquals(expected, BinarySearch.find(values, target, low, high));
    }

    private static List<Arguments> findArguments() {
        return List.of(
                Arguments.of(SORTED_ARRAY, 9, 0, SORTED_ARRAY.length-1, true),
                Arguments.of(SORTED_ARRAY, 1, 0, SORTED_ARRAY.length-1, true),
                Arguments.of(SORTED_ARRAY, 19, 0, SORTED_ARRAY.length-1, true),
                Arguments.of(SORTED_ARRAY, 0, 0, SORTED_ARRAY.length-1, false),
                Arguments.of(SORTED_ARRAY, 20, 0, SORTED_ARRAY.length-1, false),
                Arguments.of(SORTED_ARRAY, 8, 0, SORTED_ARRAY.length-1, false)
        );
    }
}
