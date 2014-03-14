package szaq.mockito.samples;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Mockito.timeout;

/**
 * Created by pmalczyk on 3/14/14.
 */
public class DummyClass4Test {

    DummyClass mockedClass = Mockito.mock(DummyClass.class);


    @Test
    public void dummy() {
        mockedClass.testSleep();
        Mockito.verify(mockedClass, timeout(10)).testSleep();
    }
}
