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

    private static final int VALUE_SIZE = 1048576;//1MB

    private RedissonClient redissonClient;

    private Random random = new Random();

    public Worker(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
        LOG.info("START");
    }

    @Override
    public void run() {
        for (int i = 0; i < Defaults.iterationsCount(); i++) {
            String key = UUID.randomUUID().toString();
            RBucket<Object> bucket = redissonClient.getBucket(key);

            if (!bucket.isExists()) {
                bucket.set(generate(), 5, TimeUnit.SECONDS);
            }
        }

        LOG.info("DONE");
    }

    private byte[] generate() {
        byte[] bytes = new byte[VALUE_SIZE];
        random.nextBytes(bytes);
        LOG.info("bbb");
        return bytes;
    }
}
