package com.szaqal.redisson;

import java.util.Optional;

public class Defaults {

    public static final long  MEGABYTE = 1024L * 1024L;

    public static final String getServerAddress() {
        return Optional.ofNullable(System.getenv("SERVER_ADDRESS")).orElse("localhost:50051");
    }


    public static final int threadPoolQueue() {
        return Integer.parseInt(Optional.ofNullable(System.getenv("THREAD_POOL_QUEUE")).orElse("5"));
    }
    public static final int threadPoolSize() {
        return Integer.parseInt(Optional.ofNullable(System.getenv("THREAD_POOL_SIZE")).orElse("5"));
    }

    public static final int threadCount() {
        return Integer.parseInt(Optional.ofNullable(System.getenv("WORKER_POOL_SIZE")).orElse("5"));
    }

    public static final int iterationsCount() {
        return Integer.parseInt(Optional.ofNullable(System.getenv("ITERATIONS_COUNT")).orElse("5"));
    }


}
