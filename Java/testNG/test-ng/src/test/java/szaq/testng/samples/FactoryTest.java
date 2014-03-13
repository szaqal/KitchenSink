package szaq.testng.samples;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pmalczyk on 3/13/14.
 */
public class FactoryTest {

    private String [] letters = new String[] {"a","b","c"};

    @Factory
    public Object[] createInstances() {

        List<Object> result = new ArrayList<Object>();
        for (String letter : letters) {
           result.add(new TestedClass(letter));
        }

        Object[] finalResult = result.toArray(new Object[result.size()]);
        return finalResult;
    }

    public class TestedClass {

        private final String arg;

        public TestedClass(String arg) {
            this.arg = arg;
        }

        @Test(groups = {"willRun"})
        public void doTest() {
            System.out.println(getClass() + " " +arg);
        }
    }
}
