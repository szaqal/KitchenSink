#!/bin/bash

source commons.sh

set -x

function start_vm {
  virsh start  $1
}

start_vm $VM_MASTER_NAME
start_vm mesos-slave-1
start_vm mesos-slave-2
start_vm mesos-slave-3
