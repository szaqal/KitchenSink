#!/bin/bash

source commons.sh

set -x

function create_small_vm {
virt-install \
--virt-type kvm \
--name $1 \
--ram ${VM_SMALL_MEM} \
--vcpus ${VM_SMALL_CPU_QTY} \
--network bridge=${BRIDGE_IFACE_NAME} \
--cdrom ${VM_UBUNTU_INSTALLATION_IMAGE} \
--disk path=${VM_PATH}/$1,size=${VM_SMALL_DISK} \
--os-type ${VM_OS_TYPE} \
--os-variant ${VM_CENTOS_OS_VARIANT}
}


create_small_vm $VM_MASTER_NAME;
