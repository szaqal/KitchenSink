package com.dialoghealth.namedloganalyzer;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Statistics {
  private final Map<String, Integer> BY_DOMAIN = new TreeMap<>();
  private final Map<String, Integer> BY_CLIENT = new TreeMap<>();

  public void aggregate( ParsedQuery parsedQuery ) {
    String query = parsedQuery.query();

    var count = BY_DOMAIN.computeIfAbsent(query, x -> 0);
    BY_DOMAIN.put(query, ++count);

    var client = parsedQuery.client();
    count = BY_CLIENT.computeIfAbsent(client, x -> 0);
    BY_CLIENT.put(client, ++count);

  }

  void dumpByDomain() {
    dump("/tmp/agg_by_domain", BY_DOMAIN);
  }

  void dumpByClient() {
    dump("/tmp/agg_by_client", BY_CLIENT);
  }

  private void dump(String fileName, Map<String, Integer> repository) {
    try(FileOutputStream ss = new FileOutputStream(fileName)) {
      repository.entrySet().stream().sorted(Map.Entry.comparingByValue())
          .forEach(x->{
            try {
              ss.write("%s:%s\n".formatted(x.getKey(), x.getValue()).getBytes());
            } catch ( IOException e ) {
              throw new RuntimeException(e);
            }
          });

    } catch ( IOException e ) {
      throw new RuntimeException(e);
    }
  }
}
