install-compiler:
	@sudo apt install gnucobol

objects := $(wildcard *cob)

compile: $(objects)
	cobc -x $(objects)
