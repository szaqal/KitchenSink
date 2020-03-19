#!/bin/sh

DIRECTORY_SOMAX="/writable-proc/sys/net/core/somaxconn"

if [ -f "${DIRECTORY_SOMAX}" ]; then
    echo "65535" > /writable-proc/sys/net/core/somaxconn
    echo "1" > /writable-proc/sys/vm/overcommit_memory
fi

exec "$@"

