#!/bin/bash

#export DATA_LENGTH=1048576
export DATA_LENGTH=1000
export ITERATIONS_COUNT=1000
export THREAD_POOL_QUEUE=5000
export THREAD_POOL_SIZE=50
export WORKER_POOL_SIZE=2000
time java -jar redisson-test/target/redisson-test-1.0-SNAPSHOT-jar-with-dependencies.jar
