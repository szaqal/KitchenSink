package szaqal.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ScheduledExecutorServiceTest {



    @Test
    public void testJob() throws ExecutionException, InterruptedException {
        System.out.println(">>>>>>>>>>>>>>");

        Runnable job = () -> System.out.println("Hello");

        var executor = Executors.newScheduledThreadPool(1);
        executor.schedule(job, 1, TimeUnit.SECONDS).get();
        System.out.println("EXIT");
    }


}
