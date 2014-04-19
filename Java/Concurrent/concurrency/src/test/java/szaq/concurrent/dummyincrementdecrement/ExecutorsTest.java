package szaq.concurrent.dummyincrementdecrement;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by pmalczyk on 4/19/14.
 */
public class ExecutorsTest extends AbstractBenchmark {

    private static final Logger LOG = LoggerFactory.getLogger(ExecutorsTest.class);


    @Before
    public void setup() {
        SharedResource.reset();
    }

    @BenchmarkOptions(benchmarkRounds = 10)
    @Test
    public void testIncrementDecrement() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> incrementResult1 = executorService.submit(new IncrementingRunnable(0));
        Future<?> decrementResult1 = executorService.submit(new DecrementingRunnable(0));
        Future<?> incrementResult2 = executorService.submit(new IncrementingRunnable(0));
        Future<?> decrementResult2 = executorService.submit(new DecrementingRunnable(0));


        while (true) {
            if (incrementResult1.isDone() && decrementResult1.isDone() && incrementResult2.isDone() && decrementResult2.isDone()) {
                Assert.assertEquals(0, SharedResource.getValue());
                break;
            }
        }

    }

    @BenchmarkOptions(benchmarkRounds = 10)
    @Test
    public void testIncrementDecrementMultipleThreadFullLock() {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<?> incrementResult1 = executorService.submit(new IncrementingRunnable(2));
        Future<?> decrementResult1 = executorService.submit(new DecrementingRunnable(2));
        Future<?> incrementResult2 = executorService.submit(new IncrementingRunnable(2));
        Future<?> decrementResult2 = executorService.submit(new DecrementingRunnable(2));

        while(true) {

            if(incrementResult1.isDone() && decrementResult1.isDone() && incrementResult2.isDone() && decrementResult2.isDone()) {
                Assert.assertEquals(0, SharedResource.getValue());
                break;
            }
        }

    }

    @BenchmarkOptions(benchmarkRounds = 10)
    @Test
    public void testIncrementDecrementMultipleThreadHalfLock() {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<?> incrementResult1 = executorService.submit(new IncrementingRunnable(1));
        Future<?> decrementResult1 = executorService.submit(new DecrementingRunnable(1));
        Future<?> incrementResult2 = executorService.submit(new IncrementingRunnable(1));
        Future<?> decrementResult2 = executorService.submit(new DecrementingRunnable(1));

        while(true) {

            if(incrementResult1.isDone() && decrementResult1.isDone() && incrementResult2.isDone() && decrementResult2.isDone()) {
                Assert.assertEquals(0, SharedResource.getValue());
                break;
            }
        }

    }

    @BenchmarkOptions(benchmarkRounds = 10)
    @Test
    public void testIncrementDecrementMultipleThreadThreadLocal() {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<?> incrementResult1 = executorService.submit(new IncrementingRunnable(3));
        Future<?> decrementResult1 = executorService.submit(new DecrementingRunnable(3));
        Future<?> incrementResult2 = executorService.submit(new IncrementingRunnable(3));
        Future<?> decrementResult2 = executorService.submit(new DecrementingRunnable(3));

        while(true) {

            if(incrementResult1.isDone() && decrementResult1.isDone() && incrementResult2.isDone() && decrementResult2.isDone()) {
                Assert.assertEquals(0, SharedResource.getValue());
                break;
            }
        }

    }


}
