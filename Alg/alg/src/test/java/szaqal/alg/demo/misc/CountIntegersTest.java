package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static szaqal.alg.demo.misc.CountIntegers.simpleArraySum;
import static szaqal.alg.demo.misc.CountIntegers.simpleArraySum2;

public class CountIntegersTest {

    @Test
    public void test() {
        Assertions.assertEquals(simpleArraySum(List.of(2,3,4)), 9);
        Assertions.assertEquals(simpleArraySum2(List.of(2,3,4)), 9);
        assertEquals(simpleArraySum(new int[]{2,3,4}), 9);
    }
}
