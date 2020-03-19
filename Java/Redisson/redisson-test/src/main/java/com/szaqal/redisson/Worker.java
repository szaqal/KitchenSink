package com.szaqal.redisson;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger("REDISSON");

    private static final int VALUE_SIZE = 1048576*10;//1MB

    private RedissonClient redissonClient;

    private long start;

    private Random random = new Random();

    public Worker(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
        this.start = System.currentTimeMillis();
    }

    @Override
    public void run() {
        long jobStart = System.currentTimeMillis();
        for (int i = 0; i < Defaults.iterationsCount(); i++) {
            String key = UUID.randomUUID().toString();
            RBucket<byte[]> bucket = redissonClient.getBucket(key);

            if (!bucket.isExists()) {
                bucket.set(generate(), 3, TimeUnit.SECONDS);
                byte[] andDelete = bucket.getAndDelete();
                LOG.trace("{}",andDelete.length);
            }

        }
        LOG.info("DONE in [{}] [{}] ms",System.currentTimeMillis() - start, System.currentTimeMillis() - jobStart);
    }

    private byte[] generate() {
        byte[] bytes = new byte[VALUE_SIZE];
        random.nextBytes(bytes);
        return bytes;
    }
}
