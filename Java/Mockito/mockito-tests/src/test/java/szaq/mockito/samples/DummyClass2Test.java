package szaq.mockito.samples;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by pmalczyk on 3/14/14.
 */
public class DummyClass2Test {

    @Mock
    private DummyClass dummyClass;

    @BeforeTest
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() {

        Mockito.when(dummyClass.positiveOnly(-3)).thenReturn(30);

        int result = dummyClass.positiveOnly(-3);
        assert 30 == result;
    }

}
