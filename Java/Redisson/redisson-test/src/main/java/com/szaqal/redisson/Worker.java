package com.szaqal.redisson;

import org.redisson.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger("REDISSON");

    private static final int VALUE_SIZE = Defaults.dataLength();

    private RedissonClient redissonClient;

    private long start;

    private int jobId;

    private Random random = new Random();

    public Worker(RedissonClient redissonClient, int jobId) {
        this.redissonClient = redissonClient;
        this.start = System.currentTimeMillis();
        this.jobId = jobId;
    }

    @Override
    public void run() {
        LOG.info("[{}] START", toString());
        int keyCount = 0;
        long jobStart = System.currentTimeMillis();
        RMap<Object, Object> map = redissonClient.getMap("Some-map");
        RKeys keys = redissonClient.getKeys();
        Map<Object, Object> all = null;

        for (int i = 0; i < Defaults.iterationsCount(); i++) {
            String key = UUID.randomUUID().toString();

            byte[] generate = generate();
            RBucket<byte[]> bucket = redissonClient.getBucket(key);
            if (!bucket.isExists()) {
                bucket.set(generate, 120, TimeUnit.SECONDS);
                byte[] andDelete = bucket.get();
                LOG.trace("{}", andDelete.length);
            }

            map.fastPutIfAbsent(key, generate);

            if (i % 100 == 0) {
                // --- HEAVY STUFF
                for (String keyExistng : keys.getKeys()) {
                    keyCount++;
                }
                RFuture<Map<Object, Object>> allAsync = map.getAllAsync(map.readAllKeySet());
                try {
                    Map<Object, Object> objectObjectMap = allAsync.await().get();
                    for(Map.Entry<Object, Object> entry: objectObjectMap.entrySet()) {
                        LOG.trace("",entry);
                    }

                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

        }

        LOG.info("MAP size :[{}]", all.keySet().size());
       // map.deleteAsync();

        LOG.info("[{}] DONE in [{}] [{}] ms / [{}] keys", toString(), System.currentTimeMillis() - start, System.currentTimeMillis() - jobStart, keyCount);
    }

    private byte[] generate() {
        byte[] bytes = new byte[VALUE_SIZE];
        random.nextBytes(bytes);
        return bytes;
    }


    @Override
    public String toString() {
        return "job-" + jobId;
    }
}
