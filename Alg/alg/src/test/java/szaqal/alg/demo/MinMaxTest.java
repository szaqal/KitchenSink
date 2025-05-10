package szaqal.alg.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

public class MinMaxTest {

    @Test
    public void test() {
        MinMaxSum.miniMaxSum(List.of(1,2,3,4,5));
        MinMaxSum.miniMaxSum(List.of(769082435,210437958,673982045,375809214,380564127));
    }
}
