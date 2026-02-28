# Proc list
# 	qemu-system-i386 -cpu help

export BOXES_PATH := $(HOME)/boxes
export DISK_PATH := $(BOXES_PATH)/win95.img
export DISK_BOOT=$(BOXES_PATH)/windows95/boot_disk/disk01.img
export DISK_CD=$(BOXES_PATH)/windows95/windows95b.iso

img-create:
	qemu-img create -f raw $(DISK_PATH) 1024M 



win95-boot:
	qemu-system-i386 -drive file=$(DISK_PATH),format=raw \
		-drive file=$(DISK_BOOT),format=raw,if=floppy \
		-cdrom $(DISK_CD) \
		-boot order=a \
		-device es1370 \
		-m 128 \
		-cpu pentium \
		-vga cirrus

win95-start:
	qemu-system-i386 -drive file=$(DISK_PATH),format=raw \
		-boot order=c \
		-cdrom $(DISK_CD) \
		-vga cirrus \
		-icount shift=5,sleep=on \
		-device sb16 \
		-m 128 \
		-cpu pentium \
		-M pc
