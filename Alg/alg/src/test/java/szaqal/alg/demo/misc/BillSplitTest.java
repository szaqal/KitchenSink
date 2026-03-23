package szaqal.alg.demo.misc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillSplitTest {
    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test(List<Integer> input,int n, int k, String expected) {
        assertEquals(expected, BillSplit.bonAppetit(input ,n,k));
    }

    private static List<Arguments> argumentsList () {
        return List.of(
                Arguments.of(List.of(3,10,2,9), 1, 12, "5"),
                Arguments.of(List.of(3,10,2,9), 1, 7, "Bon Appetit")
        );
    }
}
