#!/bin/bash

#
# Creates network bridge to be used by VMs
# using properties from common.sh file
#
# pawel@ionate.io
#

BRIDGE_IFACE_NAME=br0
BRIDGE_MAC_ADDR=00:0a:e7:2c:44:2a
BRIDGE_IFACE=eth0

echo "Creating Bridge ${BRIDGE_IFACE_NAME}"


brctl addbr ${BRIDGE_IFACE_NAME} 
ifconfig ${BRIDGE_IFACE_NAME} hw ether ${BRIDGE_MAC_ADDR}
brctl addif ${BRIDGE_IFACE_NAME} ${BRIDGE_IFACE} 
dhclient ${BRIDGE_IFACE_NAME}
brctl show ${BRIDGE_IFACE_NAME}
