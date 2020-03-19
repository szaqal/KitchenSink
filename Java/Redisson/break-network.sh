#!/bin/bash

PACKET_LOSS=10%
LATENCY=350
IFACE=eth0


 ./comcast --packet-loss=${PACKET_LOSS} \
	 --latency=${LATENCY} \
	 --device=${IFACE} \
	 --target-proto=tcp,udp,icmp \
