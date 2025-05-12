package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairsTest {

    @Test
    public void test() {
        assertEquals(3, Pairs.pairs(2, new ArrayList<>(List.of(1,5,3,4,2))));
    }
}
