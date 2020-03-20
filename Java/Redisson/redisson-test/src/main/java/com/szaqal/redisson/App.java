package com.szaqal.redisson;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.connection.ConnectionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    private static final Logger LOG = LoggerFactory.getLogger("REDISSON");

    public static void main(String[] args) throws Exception {
        InputStream resourceAsStream = App.class.getClassLoader().getResourceAsStream("redisson.json");
        Config config = Config.fromJSON(resourceAsStream);
        RedissonClient redissonClient = Redisson.create(config);
        redissonClient.getNodesGroup().addConnectionListener(new ConnectionListener() {
            @Override
            public void onConnect(InetSocketAddress inetSocketAddress) {
                LOG.info("Connected");
            }

            @Override
            public void onDisconnect(InetSocketAddress inetSocketAddress) {
                LOG.info("Disconnected");
            }
        });

        ExecutorService workerExecutor = Threads.buildWorkerExecutor();

        for (int i = 1; i < Defaults.threadCount()+1; i++) {
            workerExecutor.submit(new Worker(redissonClient, i));
            Thread.sleep(15_000/i);

        }

        try {
            workerExecutor.shutdown();
            if (!workerExecutor.awaitTermination(1, TimeUnit.HOURS)) {
                workerExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            workerExecutor.shutdownNow();
        }


    }
}
