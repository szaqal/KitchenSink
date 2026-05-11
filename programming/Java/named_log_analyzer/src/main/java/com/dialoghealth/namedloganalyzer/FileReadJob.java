package com.dialoghealth.namedloganalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class FileReadJob implements Callable<List<ParsedQuery>> {

  private List<ParsedQuery> queries = new ArrayList<>();

  private static final Logger logger = Logger.getLogger("Read");

  private final File file;

  public FileReadJob( File file ) {
    this.file = file;
  }

  @Override
  public List<ParsedQuery> call() {

    int linesCompleted = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line = null;
      while ( (line = reader.readLine()) != null ) {
        //logger.finest(line);
        if (linesCompleted % 10_000 == 0) {
          logger.info("%s %s lines completed".formatted(Thread.currentThread().getName(), linesCompleted));
          queries.add(parse(line));
        }
        linesCompleted++;
      }

      return queries;
    } catch ( IOException e ) {
      throw new RuntimeException(e);
    }
  }

  static ParsedQuery parse(String logEntry) {
    String[] split = logEntry.split("\\s+");
    String[] timeStamp = Arrays.copyOfRange(split, 0, 1);
    return new ParsedQuery(String.join(" ", timeStamp), split[6].substring(0, split[6].indexOf("#")), split[9]);
  }

}
