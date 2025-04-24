#!/bin/bash

PACKET_LOSS=2%
LATENCY=1
IFACE=eth0
BANDWIDTH=5000000


 ./comcast --packet-loss=${PACKET_LOSS} \
	 --latency=${LATENCY} \
	 --device=${IFACE} \
	 --target-bw=${BANDWIDTH} \
	 --target-proto=tcp,udp,icmp \
