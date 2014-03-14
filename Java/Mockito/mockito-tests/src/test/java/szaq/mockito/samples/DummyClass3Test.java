package szaq.mockito.samples;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;

/**
 * Created by pmalczyk on 3/14/14.
 */
public class DummyClass3Test {
    //RESET MOCK

    DummyClass mockedClass = Mockito.mock(DummyClass.class);



    @Test(invocationCount = 3)
    public void dummy() {
        int result = mockedClass.positiveOnly(-3);
        assert 0 == result;

        Mockito.verify(mockedClass, times(1)).positiveOnly(-3);

        reset(mockedClass);
    }
}
