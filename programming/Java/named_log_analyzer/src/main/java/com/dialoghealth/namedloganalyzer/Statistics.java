package com.dialoghealth.namedloganalyzer;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Statistics {
  private final Map<String, Integer> BY_DOMAIN = new TreeMap<>();

  public void aggregate( ParsedQuery parsedQuery ) {
    String query = parsedQuery.query();
    if (BY_DOMAIN.containsKey(query)) {
      Integer i = BY_DOMAIN.get(query);
      BY_DOMAIN.put(query, ++i);
    } else {
      BY_DOMAIN.put(query, 1);
    }


  }

  public void dump() {
    try {
      FileOutputStream ss = new FileOutputStream("/tmp/agg_by_domain");
      BY_DOMAIN.entrySet().stream().sorted(( o1, o2 ) -> o1.getValue().compareTo(o2.getValue()))
          .forEach(x->{
            try {
              ss.write("%s:%s\n".formatted(x.getKey(), x.getValue()).getBytes());
            } catch ( IOException e ) {
              throw new RuntimeException(e);
            }
          });

    } catch ( FileNotFoundException e ) {
      throw new RuntimeException(e);
    } catch ( IOException e ) {
      throw new RuntimeException(e);
    }
  }
}
