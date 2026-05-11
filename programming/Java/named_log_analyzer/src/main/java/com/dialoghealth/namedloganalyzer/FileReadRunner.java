package com.dialoghealth.namedloganalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class FileReadRunner {

  private static final Logger log = Logger.getLogger("");
  private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

  public List<ParsedQuery> read( List<FileReadJob> jobs ) {
    List<ParsedQuery> results = new ArrayList<>();
    try {

      List<Future<List<ParsedQuery>>> list = jobs.stream().map(executorService::submit).toList();
      for (var task : list) {
        results.addAll(task.get()) ;
      }

      return results;
    } catch ( InterruptedException | ExecutionException e ) {
      throw new RuntimeException(e);
    } finally {
      executorService.shutdown();
      log.info("Finished");
    }
  }

}
