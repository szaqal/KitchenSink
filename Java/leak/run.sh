#!/bin/bash
#java -XX:+UseG1GC -Xmx1g -Xms1g -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCDetails -jar target/leak-1.0-SNAPSHOT.jar
#java -XX:+UseParallelOldGC -XX:SurvivorRatio=64 -XX:MaxTenuringThreshold=15 -Xmx1g -Xms1g -XX:+PrintTenuringDistribution -jar target/leak-1.0-SNAPSHOT.jar
#java -XX:+UseParallelOldGC -Xmx1g -Xms1g -XX:+PrintTenuringDistribution -jar target/leak-1.0-SNAPSHOT.jar
time java -XX:+UseParallelOldGC -XX:NewRatio=1 -XX:MaxTenuringThreshold=15 -Xmx256m -Xms256m  -jar target/leak-1.0-SNAPSHOT.jar

