#!/bin/bash
#java -XX:+UseG1GC -Xmx1g -Xms1g -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCDetails -jar target/leak-1.0-SNAPSHOT.jar
#java -XX:+UseParallelOldGC -XX:SurvivorRatio=64 -XX:MaxTenuringThreshold=15 -Xmx1g -Xms1g -XX:+PrintTenuringDistribution -jar target/leak-1.0-SNAPSHOT.jar
#java -XX:+UseParallelOldGC -Xmx1g -Xms1g -XX:+PrintTenuringDistribution -jar target/leak-1.0-SNAPSHOT.jar
time java -XX:+UseParallelOldGC -XX:NewRatio=4 -XX:SurvivorRatio=100 -XX:MaxTenuringThreshold=15 -Xmx8g -Xms8g -verbose:gc -jar target/leak-1.0-SNAPSHOT.jar

