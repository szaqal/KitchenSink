package szaq.mockito.samples;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.internal.verification.VerificationModeFactory.atMost;

/**
 * Created by pmalczyk on 3/14/14.
 */
public class DummyClassTest {



    @Test
    public void dummy() {
        DummyClass mockedClass = Mockito.mock(DummyClass.class);
        int result = mockedClass.positiveOnly(-3);
        assert 0 == result;

        Mockito.verify(mockedClass).positiveOnly(-3);
    }

    @Test
    public void dummy1() {
        DummyClass mockedClass = Mockito.mock(DummyClass.class);
        int result = mockedClass.positiveOnly(-3);
        assert 0 == result;

        Mockito.verify(mockedClass).positiveOnly(anyInt());
    }


    @Test
    public void dummy2() {
        DummyClass mockedClass = Mockito.mock(DummyClass.class);
        int result = mockedClass.positiveOnly(-3);
        assert 0 == result;

        Mockito.verify(mockedClass).positiveOnly(eq(-3));
    }

    @Test
    public void dummy3() {
        DummyClass mockedClass = Mockito.mock(DummyClass.class);
        int result = mockedClass.positiveOnly(-3);
        assert 0 == result;

        Mockito.verify(mockedClass, atMost(1)).positiveOnly(-3);
        Mockito.verify(mockedClass, times(1)).positiveOnly(-3);
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void dummy4() {
        DummyClass mockedClass = Mockito.mock(DummyClass.class);
        doThrow(new IllegalArgumentException()).when(mockedClass).positiveOnly(-6);
        int result = mockedClass.positiveOnly(-6);
        assert 0 == result;
    }

    @Test
    public void dummy5() {
        DummyClass mockedClass = Mockito.mock(DummyClass.class);
        int result = mockedClass.positiveOnly(-3);
        assert 0 == result;

        Mockito.verify(mockedClass, never()).positiveOnly(-6);
    }


}
