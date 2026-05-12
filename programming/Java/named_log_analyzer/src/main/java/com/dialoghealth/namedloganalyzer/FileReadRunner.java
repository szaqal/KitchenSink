package com.dialoghealth.namedloganalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class FileReadRunner {

  private static final Logger log = Logger.getLogger("");
  private static final ExecutorService executorService = Executors.newFixedThreadPool(3);
  private static final CompletionService<List<ParsedQuery>> completionService = new ExecutorCompletionService<>(executorService);

  public List<ParsedQuery> read( List<FileReadJob> jobs ) {
    List<ParsedQuery> results = new ArrayList<>();
    try {
      jobs.forEach(completionService::submit);
      for (int i= jobs.size();i>0;i--) {
        List<ParsedQuery> parsedQueries = completionService.take().get();
        results.addAll(parsedQueries);
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
