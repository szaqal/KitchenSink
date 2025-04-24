package szaq.concurrent.dummyincrementdecrement;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;
import szaq.concurrent.dataset.FileProcessor;

import java.util.Map;
import java.util.Random;

import static junit.framework.Assert.assertEquals;


/**
 * Created by pmalczyk on 4/19/14.
 */
public class DatasetTest extends AbstractBenchmark {

    @BenchmarkOptions(benchmarkRounds = 100)
    @Test
    public void testSingleThread() {
        Map<String,Integer> aggregatedResults = FileProcessor.processSingleThread();
        assertEquals(Integer.valueOf(3), aggregatedResults.get("SHARON MARIE"));
    }

    @BenchmarkOptions(benchmarkRounds = 100)
    @Test
    public void testMultiThread2Threads() {
        Map<String,Integer> aggregatedResults = FileProcessor.processMultitThread(2);
        assertEquals(Integer.valueOf(3), aggregatedResults.get("SHARON MARIE"));
    }

    @BenchmarkOptions(benchmarkRounds = 100)
    @Test
    public void testMultiThread4Threads() {
        Map<String,Integer> aggregatedResults = FileProcessor.processMultitThread(4);
        assertEquals(Integer.valueOf(3), aggregatedResults.get("SHARON MARIE"));
    }

    @BenchmarkOptions(benchmarkRounds = 100)
    @Test
    public void testMultiThread6Threads() {
        Map<String,Integer> aggregatedResults = FileProcessor.processMultitThread(6);
        assertEquals(Integer.valueOf(3), aggregatedResults.get("SHARON MARIE"));
    }
}
