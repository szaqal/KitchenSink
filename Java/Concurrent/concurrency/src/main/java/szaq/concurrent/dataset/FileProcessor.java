package szaq.concurrent.dataset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by pmalczyk on 4/19/14.
 */
public class FileProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(FileProcessor.class);

    public static void processSingleThread() {
        boolean jobDone = false;
        List<Future<?>> tasks = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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

        while(!jobDone) {
            for(Future<?> task : tasks) {
                if(!task.isDone()) {
                    continue;
                }
            }
            jobDone = true;

        }


    }


    public static void processMultitThread() {
        boolean jobDone = false;
        List<Future<?>> tasks = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
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

        while(!jobDone) {
            for(Future<?> task : tasks) {
                if(!task.isDone()) {
                    continue;
                }
            }
            jobDone = true;

        }


    }
}
