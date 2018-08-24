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
