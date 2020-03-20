package com.szaqal.redisson;

import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;
import java.util.UUID;
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
        int keyCount =0;
        long jobStart = System.currentTimeMillis();
        RMap<Object, Object> map = redissonClient.getMap(UUID.randomUUID().toString());
        Map<Object, Object> all = null;
        for (int i = 0; i < Defaults.iterationsCount(); i++) {
            String key = UUID.randomUUID().toString();

            byte[] generate = generate();
            RBucket<byte[]> bucket = redissonClient.getBucket(key);
            if (!bucket.isExists()) {
                bucket.set(generate, 15, TimeUnit.SECONDS);
                byte[] andDelete = bucket.get();
                LOG.trace("{}",andDelete.length);
            }

            map.fastPutIfAbsent(key, generate);

            if( i%10==0 ) {
                // --- HEAVY STUFF
                for(String keyExistng :redissonClient.getKeys().getKeys()) {
                    keyCount++;
                }
                all = map.getAll(map.readAllKeySet());
            }


        }


        LOG.info("MAP size :[{}]", all.keySet().size());
        map.deleteAsync();

        LOG.info("[{}] DONE in [{}] [{}] ms / [{}] keys", toString(), System.currentTimeMillis() - start, System.currentTimeMillis() - jobStart, keyCount);
    }

    private byte[] generate() {
        byte[] bytes = new byte[VALUE_SIZE];
        random.nextBytes(bytes);
        return bytes;
    }


    @Override
    public String toString() {
        return "job-"+jobId;
    }
}
