# Proc list
# 	qemu-system-i386 -cpu help


img-create:
	qemu-img create -f qcow2 ~/win2k.img 8192M 


win2k-%: export DISK_PATH=~/win2k.img
win2k-boot: DISK_CD=~/Pobrane/EN_WIN2000_PRO_SP4.ISO
win2k-boot:
	qemu-system-i386  -hda $(DISK_PATH) \
		-cdrom $(DISK_CD) \
		-boot a -soundhw pcspk \
		-soundhw sb16 \
		-m 64 \
		-cpu pentium \
		-vga cirrus

win2k-start:
	qemu-system-i386  -hda $(DISK_PATH) \
		-boot a \
		-enable-kvm \
		-vga cirrus \
		-cpu host \
		-soundhw ac97 \
		-m 1024
