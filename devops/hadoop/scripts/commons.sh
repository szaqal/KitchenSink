#!/bin/bash


#Bridge interface name
BRIDGE_IFACE_NAME=br0
BRIDGE_MAC_ADDR=00:0a:e7:2c:44:2a

#Intereface that will be bridged endpoint 
BRIDGE_IFACE=eth0

VM_UBUNTU_INSTALLATION_IMAGE=/VMS/images/ubuntu-16.04.2-server-amd64.iso
VM_CENTOS_INSTALLATION_IMAGE=/VMS/images/CentOS-7-x86_64-Minimal-1611.iso

VM_MASTER_NAME=mesos-master
VM_SMALL_MEM=512
VM_SMALL_CPU_QTY=1
VM_SMALL_DISK=20

#Root dir where VMs are stored
VM_PATH=/VMS/libvirt
VM_OS_TYPE=linux
VM_UBUNTU_OS_VARIANT=ubuntu16.04
VM_CENTOS_OS_VARIANT=rhel7

