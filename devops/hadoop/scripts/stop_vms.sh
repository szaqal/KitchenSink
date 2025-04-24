#!/bin/bash

source commons.sh

set -x

function stop_vm {
  virsh shutdown $1
}

stop_vm $VM_MASTER_NAME
stop_vm mesos-slave-1
stop_vm mesos-slave-2
stop_vm mesos-slave-3
