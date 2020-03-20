package com.szaqal.redisson;

import java.util.Optional;

public class Defaults {

    public static final int dataLength() {
        return Integer.parseInt(Optional.ofNullable(System.getenv("DATA_LENGTH")).orElse("1048576"));
    }

    public static final int threadPoolQueue() {
        return Integer.parseInt(Optional.ofNullable(System.getenv("THREAD_POOL_QUEUE")).orElse("100"));
    }
    public static final int threadPoolSize() {
        return Integer.parseInt(Optional.ofNullable(System.getenv("THREAD_POOL_SIZE")).orElse("20"));
    }

    public static final int threadCount() {
        return Integer.parseInt(Optional.ofNullable(System.getenv("WORKER_POOL_SIZE")).orElse("100"));
    }

    public static final int iterationsCount() {
        return Integer.parseInt(Optional.ofNullable(System.getenv("ITERATIONS_COUNT")).orElse("50"));
    }


}
