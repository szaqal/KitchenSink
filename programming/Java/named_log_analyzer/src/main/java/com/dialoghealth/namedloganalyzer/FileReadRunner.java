package com.dialoghealth.namedloganalyzer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileReadRunner {

  private static final ExecutorService executorService = Executors.newFixedThreadPool(1);
  public void read( List<FileReadJob> jobs) {
    jobs.forEach(executorService::submit);
  }

}
