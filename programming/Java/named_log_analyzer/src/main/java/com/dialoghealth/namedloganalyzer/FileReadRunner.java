package com.dialoghealth.namedloganalyzer;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class FileReadRunner {

  private static final Logger log = Logger.getLogger("");
  private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

  public void read( List<FileReadJob> jobs ) {
    try {

      List<Future<List<ParsedQuery>>> list = jobs.stream().map(executorService::submit).toList();
      for (var task : list) {
        List<ParsedQuery> parsedQueries = task.get();
        log.info("Loaded %d".formatted(parsedQueries.size()));
      }

    } catch ( InterruptedException | ExecutionException e ) {
      throw new RuntimeException(e);
    } finally {
      executorService.shutdown();
      log.info("Finished");
    }
  }

}
