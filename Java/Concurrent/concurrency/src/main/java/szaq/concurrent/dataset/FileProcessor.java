package szaq.concurrent.dataset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by pmalczyk on 4/19/14.
 */
public class FileProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(FileProcessor.class);

    public static Map<String, Integer> processSingleThread() {
        boolean jobDone = false;
        List<Future<Map<String, Integer>>> tasks = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(FileProcessor.class.getClassLoader().getResourceAsStream("sample_dataset.csv")));
            int count = 0;
            List<String> dataToProcess = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                count++;
                dataToProcess.add(line);
                if (count % 1000 == 0) {
                    tasks.add(executorService.submit(new ComputeData(dataToProcess)));
                    dataToProcess = new ArrayList<>();
                    count = 0;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            jobDone = true;

        }

        LOG.debug("Tasks size {} ", tasks.size());

        while (!jobDone) {
            for (Future<?> task : tasks) {
                if (!task.isDone()) {
                    continue;
                }
            }
            jobDone = true;

        }

        return aggregateData(tasks);
    }


    public static Map<String, Integer> processMultitThread(int threadCount) {
        boolean jobDone = false;
        List<Future<Map<String, Integer>>> tasks = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        String line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(FileProcessor.class.getClassLoader().getResourceAsStream("sample_dataset.csv")));
            int count = 0;
            List<String> dataToProcess = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                count++;
                dataToProcess.add(line);
                if (count % 100 == 0) {
                    tasks.add(executorService.submit(new ComputeData(dataToProcess)));
                    dataToProcess = new ArrayList<>();
                    count = 0;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            jobDone = true;

        }

        LOG.debug("Tasks size {} ", tasks.size());


        while (!jobDone) {
            for (Future<?> task : tasks) {
                if (!task.isDone()) {
                    continue;
                }
            }
            jobDone = true;
        }

       return aggregateData(tasks);


    }

    private static  Map<String, Integer> aggregateData(List<Future<Map<String, Integer>>> tasks) {
        Map<String, Integer> aggregatedResults = new HashMap<>();
        for (Future<Map<String, Integer>> task : tasks) {
            try {
                Map<String, Integer> taskResut = task.get();
                for (String key : taskResut.keySet()) {

                    if (aggregatedResults.containsKey(key)) {
                        aggregatedResults.put(key, aggregatedResults.get(key) + taskResut.get(key));
                    } else {
                        aggregatedResults.put(key, taskResut.get(key));
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }



        LOG.debug("{}", aggregatedResults);
        return aggregatedResults;
    }
}
