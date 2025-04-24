# Hadoop 2.8 #

* Init HDFS

```
$HADOOP_HOME/bin/hdfs namenode -format <cluster_name>
```

```
./hadoop-daemon.sh start namenode
```

```
./hadoop-daemon.sh start datanode
```

```
./yarn-daemon.sh start resourcemanager
```


```
 ./yarn-daemon.sh start nodemanager
```

```
../../../bin/yarn jar ./hadoop-mapreduce-examples-2.8.0.jar wordcount /input /output
```
