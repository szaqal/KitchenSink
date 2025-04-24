#!/bin/bash

# 
# Converts images to PDF file i merges into single PDF document
#
# usage ./img2pdf.sh ~/Desktop/
#


#set -x

FUZZ_FACTOR=${CONV_FUZZ:-30%}
PATTERN=${CONV_PATTERN:-*jpg}
RESIZE=${CONV_RESIZE:-60%}
QUALITY=${CONV_QUALITY:-10}

if which convert >/dev/null; then
    find $1 -iname ${PATTERN} \
	-exec \
	convert {} \
	-fuzz ${FUZZ_FACTOR} \
	-strip \
	-trim \
	-monochrome \
	-quality ${QUALITY} \
	-resize ${RESIZE} \
	-crop +390+140 -crop -390-660 \
	-layers Optimize {}.pdf \;
else
    echo convert does not exist
fi



if which pdfjoin >/dev/null; then
    pdfjoin ${1}*.pdf --outfile ${1}_out.pdf
else
    echo pdfjoin does not exist
fi
