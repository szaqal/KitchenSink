package com.dialoghealth.namedloganalyzer;

import java.io.*;
import java.util.logging.Logger;

public class FileReadJob implements Runnable {

  private Logger logger = Logger.getLogger("Read");

  private final File file;

  public FileReadJob( File file ) {
    this.file = file;
  }

  @Override
  public void run() {

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line = null;
      while ( (line = reader.readLine()) != null ) {
        logger.info(line);
      }
      logger.info("%s %s".formatted(Thread.currentThread().getName(), "aa"));
    } catch ( IOException e ) {
      throw new RuntimeException(e);
    }
  }
}
