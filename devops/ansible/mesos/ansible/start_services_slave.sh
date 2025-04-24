#!/bin/bash

for SERVICES in mesos-slave; do
    systemctl restart $SERVICES
    systemctl enable $SERVICES
    systemctl status $SERVICES
done
