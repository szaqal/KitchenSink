package szaqal.alg.demo.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseTest {

    @Test
    public void test() {
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] expected = new int[]{5, 4, 3, 2, 1};
        assertArrayEquals(expected, Reverse.reverse(input, 0, input.length));
    }
}
