package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CountIntegersTest {

    @Test
    public void test() {
        Assertions.assertEquals(CountIntegers.simpleArraySum(List.of(2,3,4)), 9);
    }
}
