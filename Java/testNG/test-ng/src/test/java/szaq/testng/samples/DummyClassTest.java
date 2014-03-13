package szaq.testng.samples;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pmalczyk on 3/12/14.
 */
public class DummyClassTest {

    private DummyClass dummyClass = new DummyClass();

    @Test(groups = "willRun")
    public void testClass() {
        assert "dummy".equals(dummyClass.getText());
        Assert.assertEquals("dummy", dummyClass.getText());
        Assert.assertSame("dummy", dummyClass.getText());
    }


    @Test(groups = "willNotRun")
    public void testClassNotRun() {
        assert "dummy".equals(dummyClass.getText());
        Assert.assertEquals("dummy", dummyClass.getText());
        Assert.assertSame("dummy", dummyClass.getText());
    }


}

