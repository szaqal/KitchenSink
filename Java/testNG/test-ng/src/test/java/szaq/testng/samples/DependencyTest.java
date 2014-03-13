package szaq.testng.samples;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by pmalczyk on 3/13/14.
 */
public class DependencyTest {


    private String msg = null;

    @Test(groups = {"willRun"})
    public void init() {
        msg = "xxx";
    }

    @Test(dependsOnMethods = {"init"}, groups = {"willRun"})
    public void testInit() {
        Assert.assertNotNull(msg);
    }
}
