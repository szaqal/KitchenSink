# HADOOP

## Get distribution

```
node:/opt# wget  http://ftp.ps.pl/pub/apache/hadoop/common/hadoop-3.1.1/hadoop-3.1.1.tar.gz
```

### Set JAVA\_HOME 

```
 export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64 
```

### Add JAVA\_HOME to env file 

```
etc/hadoop/hadoop-env.sh
```


### Passwordless auth

```
$ ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa
$ cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
$ chmod 0600 ~/.ssh/authorized_keys
```

```
bin/hdfs namenode -format
```

### Jdk


Provides ```jps``` tool

```
malczyk@master:~/hadoop/sbin$ sudo apt install openjdk-8-jdk-headless
```


As of Hadoop 3 HDFS UI works ```http://192.168.2.52:9870```

Verification

```
malczyk@master:~/hadoop/sbin$ jps 
9249 SecondaryNameNode
9124 DataNode
8996 NameNode
10053 Jps

```

Start DFS

```
 $HADOOP_HOME/sbin/start-dfs.sh 
```
Start YARN

```
 $HADOOP_HOME/sbin/start-yarn.sh 
```

***Add slaves nodes to $HADOOP_CONF/slaves file***


HDFS UI before hadoop < 3

```
http://192.168.2.52:50070/dfshealth.html#tab-overview
```

HADOOP UI ```http://192.168.2.52:8088```

# Hive

```
malczyk@master:~/hadoop/bin$ ./hadoop fs -mkdir -p /usr/hive/warehouse
malczyk@master:~/hadoop/bin$ ./hadoop fs -chmod g+w /usr/hive/warehouse
```

### Hive server 2

```
./hive --service hiveserver2
http://192.168.2.52:10002/
```

### Beeline

```
malczyk@master:~/hive/bin$ ./beeline -u jdbc:hive2://localhost:10000
```

```
malczyk@master:~$ hdfs dfs -put Crimes.csv /user/

hive> CREATE EXTERNAL TABLE IF NOT EXISTS Crimes(ID INT, Case_Number STRING, daate STRING, Block STRING, IUCR STRING, Primary_Type STRING, Description STRING, Location_Description STRING, Arrest STRING, Domestic STRING, Beat STRING, District STRING, Ward STRING, Community_Area STRING, FBI_Code STRING, X_Coordinate STRING, Y_Coordinate STRING, Year STRING, Updated_On STRING, Latitude STRING, Longitude STRING, Location STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' STORED AS TEXTFILE LOCATION '/user/username/names';

hive> LOAD DATA INPATH '/user/Crimes.csv' INTO TABLE Crimes;
```

