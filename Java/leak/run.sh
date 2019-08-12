#!/bin/bash
#java -XX:+UseG1GC -Xmx1g -Xms1g -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCDetails -jar target/leak-1.0-SNAPSHOT.jar
java -Xmx1g -Xms1g -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCDetails -jar target/leak-1.0-SNAPSHOT.jar

