package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Test;
import szaqal.alg.demo.misc.Pairs;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairsTest {

    @Test
    public void test() {
        assertEquals(3, Pairs.pairs(2, new ArrayList<>(List.of(1,5,3,4,2))));
    }
}
