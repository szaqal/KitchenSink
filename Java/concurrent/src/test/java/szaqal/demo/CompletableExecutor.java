package szaqal.demo;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class CompletableExecutor {

    @Test
    public void test() throws InterruptedException, ExecutionException {
        var executor = Executors.newFixedThreadPool(5);
        var completionService = new ExecutorCompletionService<>(executor);
        List<Demo> demos = List.of(new Demo(1000), new Demo(1200), new Demo(4000));
        demos.forEach(executor::submit);
        for (int i = demos.size(); i > 0; i--) {
            var r = completionService.take().get();
            if (r != null) {
                System.out.println(r);
            }
        }
    }


    private static class Demo implements Callable<String> {

        private final int timeout;
        public Demo(int timeout) {
            this.timeout = timeout;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(timeout);
            return "Finished";
        }
    }
}
