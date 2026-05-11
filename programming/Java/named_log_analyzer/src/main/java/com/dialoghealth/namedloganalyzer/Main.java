package com.dialoghealth.namedloganalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {

  private static final Logger log = Logger.getLogger("READ");
  private static final FileReadRunner fileReadRunner = new FileReadRunner();

    public static void main(String[] args) throws FileNotFoundException {
      long start = System.currentTimeMillis();
      List<File> files = FileBrowser.listFiles("SAMBA/Data");
      fileReadRunner.read(files.stream().map(FileReadJob::new).toList());
      long end = System.currentTimeMillis();
      log.info("Completed in %s s".formatted(TimeUnit.MILLISECONDS.toSeconds(end - start)));
    }
}
