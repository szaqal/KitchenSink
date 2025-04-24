#!/bin/bash

mkdir -p /etc/marathon/conf;
cp /etc/mesos-master/hostname /etc/marathon/conf;
cp /etc/mesos/zk /etc/marathon/conf/master;
