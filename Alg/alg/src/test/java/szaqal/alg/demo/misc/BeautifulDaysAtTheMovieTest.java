package szaqal.alg.demo.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static szaqal.alg.demo.misc.BeautifulDaysAtTheMovie.beautifulDays;

public class BeautifulDaysAtTheMovieTest {

    @ParameterizedTest
    @MethodSource("argumentsList")
    public void test( int startingDay, int endingDay, int divisor, int expectedResult) {
        Assertions.assertEquals(expectedResult, beautifulDays(startingDay, endingDay, divisor));
    }

    private static List<Arguments> argumentsList() {
        return List.of(
                Arguments.of(20, 23, 6, 2),
                Arguments.of(13, 45, 3, 33)

        );
    }
}
