package szaq.concurrent.dummyincrementdecrement;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;
import szaq.concurrent.dataset.FileProcessor;

/**
 * Created by pmalczyk on 4/19/14.
 */
public class DatasetTest extends AbstractBenchmark {

    @BenchmarkOptions(benchmarkRounds = 20)
    @Test
    public void testSingleThread() {
        FileProcessor.processSingleThread();
    }

    @BenchmarkOptions(benchmarkRounds = 20)
    @Test
    public void testMultiThread() {
        FileProcessor.processMultitThread();
    }
}
