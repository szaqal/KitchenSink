#!/bin/bash

for SERVICES in zookeeper mesos-master marathon; do
    systemctl restart $SERVICES
    systemctl enable $SERVICES
done
