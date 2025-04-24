#!/bin/bash

source commons.sh

set -x

function create_clone {
	virt-clone --auto-clone --original $VM_MASTER_NAME --name $1 
}

create_clone mesos-slave-1
create_clone mesos-slave-2
create_clone mesos-slave-3
