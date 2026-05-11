package com.dialoghealth.namedloganalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FileBrowser {

  public static List<File> listFiles(String dir) throws FileNotFoundException {
    Objects.requireNonNull(dir, "Directory needs to be provided");

    File path = Paths.get(String.join(FileSystems.getDefault().getSeparator(), System.getProperty("user.home"), dir)).toFile();
    if (!path.exists()) {
      throw new FileNotFoundException("Unable to find directory [%s]".formatted(path));
    }

    return Arrays.stream(Optional.of(path).map(File::listFiles).orElseGet(()-> new File[]{})).toList();
  }
}
