package szaqal.demo;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;

public class CompletableExecutorTest {

    Executor executor = Executors.newFixedThreadPool(5);

    @Test
    public void test() throws InterruptedException, ExecutionException {

        var completionService = new ExecutorCompletionService<String>(executor);
        List<Demo> demos = List.of(new Demo(1000), new Demo(1500), new Demo(3000));

        for(var demo:demos) {
            completionService.submit(demo);
        }

        for (int i = demos.size(); i > 0; i--) {
            String r = completionService.take().get();
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
            System.out.println("HERE");
            Thread.sleep(timeout);
            return "Finished";
        }
    }
}
