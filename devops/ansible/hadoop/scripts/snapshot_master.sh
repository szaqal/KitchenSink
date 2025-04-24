#!/bin/bash

source commons.sh

set -x

function create_snapshot {
  virsh snapshot-create  $1
}

create_snapshot $VM_MASTER_NAME
