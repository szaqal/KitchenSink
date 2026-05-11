package com.dialoghealth.namedloganalyzer;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileReadJob implements Runnable {

  private Logger logger = Logger.getLogger("Read");

  private final File file;

  public FileReadJob( File file ) {
    this.file = file;
  }

  @Override
  public void run() {

    int linesCompleted = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line = null;
      while ( (line = reader.readLine()) != null ) {
        //logger.finest(line);
        if (linesCompleted % 200 == 0) {
          logger.info("%s %s lines completed".formatted(Thread.currentThread().getName(), linesCompleted));
        }
        linesCompleted++;
      }

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
