package szaq.testng.samples;

import org.testng.annotations.Test;

/**
 * Created by pmalczyk on 3/12/14.
 */
public class DummyClassTest {

    private DummyClass dummyClass = new DummyClass();

    @Test
    public void testClass() {
        assert "dummy".equals(dummyClass.getText());
    }
}

