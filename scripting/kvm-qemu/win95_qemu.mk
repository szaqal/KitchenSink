# Proc list
# 	qemu-system-i386 -cpu help


img-create:
	qemu-img create -f qcow2 ~/disk.img 1024M 


win95-%: export DISK_PATH=~/win95.img
win95-boot: DISK_BOOT=~/Windows/boot_disk/disk01.img 
win95-boot: DISK_CD=~/Windows/windows95b.iso
win95-boot:
	qemu-system-i386  -hda $(DISK_PATH) \
		-fda $(DISK_BOOT) \
		-cdrom $(DISK_CD) \
		-boot a -soundhw pcspk \
		-soundhw sb16 \
		-m 64 \
		-cpu pentium \
		-vga cirrus

win95-start:
	qemu-system-i386  -hda $(DISK_PATH) \
		-boot a \
		-vga cirrus \
		-soundhw sb16 \
		-m 128 \
		-smp 4 \
		-cpu pentium  
