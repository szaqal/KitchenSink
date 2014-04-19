package szaq.concurrent.dataset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by pmalczyk on 4/19/14.
 */
public class ComputeData implements Callable<Map<String,Integer>> {

    private static final Logger LOG = LoggerFactory.getLogger(ComputeData.class);

    private List<String> dataToProcess;


    public ComputeData(List<String> data) {
        dataToProcess = data;
    }


    @Override
    public Map<String, Integer> call() throws Exception {
        Map<String,Integer> result = new HashMap<>();

        for(String line : dataToProcess) {
            String [] data = line.split(",");
            String firstName = data[3];
            if(result.containsKey(firstName)) {
                Integer count = result.get(firstName);
                if (count == null) {
                    result.put(firstName, 1);
                } else {
                    result.put(firstName, count+1);
                }
            } else {
                result.put(firstName, 1);
            }
        }

        LOG.debug("Done " + Thread.currentThread().getId());
        return result;
    }
}
