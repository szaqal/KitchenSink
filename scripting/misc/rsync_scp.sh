#!/bin/bash

set -x

function pull {
 	rsync -P -rsh=ssh $1 $2
}
pull $1 $2
