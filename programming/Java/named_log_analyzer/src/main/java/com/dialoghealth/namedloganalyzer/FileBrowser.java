package com.dialoghealth.namedloganalyzer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FileBrowser {

  public static List<String> listFiles(String dir) {
    Objects.requireNonNull(dir, "Directory needs to be provided");

    Path path = Paths.get(String.join(System.lineSeparator(), System.getProperty("user.home"), dir));
    File[] files = Optional.of(path).map(Path::toFile).map(File::listFiles).orElse(new File[]{});
    for(var file: files) {
      System.out.println(file);
    }

    return List.of();
  }
}
