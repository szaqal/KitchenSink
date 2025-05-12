package szaqal.alg.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingNumberTest {

    @Test
    public void test1() {
        var arr =  new ArrayList<>(List.of(203,204, 205, 206, 207, 208, 203, 204, 205, 206));
        var brr =  new ArrayList<>(List.of(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204));
        Assertions.assertEquals(List.of(204,205,206),MissingNumbers.missingNumbers(arr, brr));
    }

    @Test
    public void test2() {
        var arr = new ArrayList<>(List.of(7,2,5,3,5,3));
        var brr = new ArrayList<>(List.of(7,2,5,4,6,3,5,3));
        Assertions.assertEquals(List.of(4,6),MissingNumbers.missingNumbers(arr, brr));
    }
}
