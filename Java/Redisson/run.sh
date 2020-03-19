#!/bin/bash

export ITERATIONS_COUNT=1000
export THREAD_POOL_QUEUE=500
export THREAD_POOL_SIZE=50
export WORKER_POOL_SIZE=500
time java -jar redisson-test/target/redisson-test-1.0-SNAPSHOT-jar-with-dependencies.jar
