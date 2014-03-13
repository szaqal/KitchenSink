package szaq.testng.samples;

import org.testng.annotations.Test;

/**
 * Created by pmalczyk on 3/13/14.
 */
@Test(groups = "willRun")
public class ClassLevelTest {

    public void testA() {
        assert  "A".equals("A");
    }

    public void testB() {
        assert true==true;
    }
}
