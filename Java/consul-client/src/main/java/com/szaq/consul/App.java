package com.szaq.consul;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.cache.KVCache;

public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) throws InterruptedException {
    Consul client = Consul.builder().build();
    log.info("client {}", client);
    KeyValueClient kvClient = client.keyValueClient();
    KVCache cache = KVCache.newCache(kvClient, "localdev");
    cache.addListener(map -> {
      log.info("Cache changed");
      map.entrySet().forEach(x->log.info("{} {}", x.getKey(), x.getValue()));
    });

    cache.start();

    Thread.sleep(100_000);
  }
}
