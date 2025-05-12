package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MedianTest {

    @Test
    public void test() {
        var a = new ArrayList<>(List.of(5,3,1,2,4));
        Assertions.assertEquals(Median.findMedian(a), 3);

    }

}
