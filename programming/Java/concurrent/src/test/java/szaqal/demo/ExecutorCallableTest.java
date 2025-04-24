package szaqal.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExecutorCallableTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        var future = executor.submit(new DemoResult());
        System.out.println(future.get());
    }

    private static class DemoResult implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            return "Hello World";
        }
    }
}
