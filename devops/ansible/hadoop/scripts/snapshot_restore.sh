#!/bin/bash

source commons.sh

set -x

function revert_snapshot {
  virsh snapshot-revert $1 --current
}


revert_snapshot $VM_MASTER_NAME
revert_snapshot mesos-slave-1
revert_snapshot mesos-slave-2
revert_snapshot mesos-slave-3
