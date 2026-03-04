package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountIntegersTest {

    @Test
    public void test() {
        assertEquals(CountIntegers.simpleArraySum(List.of(2,3,4)), 9);
        assertEquals(CountIntegers.simpleArraySum(new int[]{2,3,4}), 9);
    }
}
