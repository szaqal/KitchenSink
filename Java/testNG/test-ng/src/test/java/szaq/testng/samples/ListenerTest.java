package szaq.testng.samples;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by pmalczyk on 3/13/14.
 */
@Listeners({TestListener.class})
public class ListenerTest {

    @Test(groups = {"willRun"})
    public void testMethod() {
        assert true == true;
    }



}
