package szaq.mockito.samples;

/**
 * Created by pmalczyk on 3/14/14.
 */
public class DummyClass {

    public int positiveOnly(int a) {
        return a < 0 ? 0 : a;
    }

    public void testSleep() {
        System.out.print("SSS");
    }
}
