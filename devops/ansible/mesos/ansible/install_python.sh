#!/bin/bash

set -x

for x in 192.168.2.52 192.168.2.53 192.168.2.54 192.168.2.55 192.168.2.56 192.168.2.57
do 
	ssh  malczyk@$x 'sudo apt-get -y install python'
done
