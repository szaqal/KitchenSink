package szaqal.guava.test;

import com.google.common.base.Converter;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by pmalczyk on 3/15/14.
 */
public class ConverterTest {

    @Test
    public void test1() {
        assertEquals(30.0, new StringParser().convert("30"));
    }

    @Test
    public void test2() {
        assertEquals("30.0", new StringParser().reverse().convert(30.0));
    }

    public class StringParser extends Converter<String, Double> {

        @Override
        protected Double doForward(String s) {
            return Double.valueOf(s);
        }

        @Override
        protected String doBackward(Double aDouble) {
            return aDouble.toString();
        }
    }
}
