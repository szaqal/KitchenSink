#!/bin/bash

source commons.sh

set -x

function create_snapshot {
  virsh snapshot-create  $1
}

create_snapshot mesos-slave-1
create_snapshot mesos-slave-2
create_snapshot mesos-slave-3
