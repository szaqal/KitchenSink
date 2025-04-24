#!/bin/bash

# Usage
# ./bulk_unzip.sh /tmp/aaa

#set -x
export EXTR_PATH=${EXTRACT_PATH:-/tmp/extract}

mkdir -p ${EXTR_PATH}

#cd $1 && \
#	for f in *; do mv "$f" `echo $f | tr ' ' '_'`; done

find $1 -iname *zip -exec sh -c 'mkdir -p ${EXTR_PATH}/$(basename {} .zip) && unzip -d ${EXTR_PATH}/$(basename {} .zip) {}' \;
