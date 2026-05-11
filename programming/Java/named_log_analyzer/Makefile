JAR := target/named-log-analyzer-1.0-SNAPSHOT.jar

.PHONY: build run

build:
	mvn package -DskipTests

run: build
	java -jar $(JAR)
