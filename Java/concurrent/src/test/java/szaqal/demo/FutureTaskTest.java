package szaqal.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        var executor = Executors.newFixedThreadPool(1);
        FutureTask<String> task = new FutureTask<>(new Demo());
        executor.submit(task);

        while(task.isDone()) {
        }

        System.out.println(task.get());

    }

    public static class Demo implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            System.out.println("Hello");
            Thread.sleep(2000);
            System.out.println("World");
            return "RESULT";
        }
    }
}
