SHELL=/bin/bash


BRIDGE_IFACE_NAME=br0
VM_PATH=/data/disk1/vmachines


vm-view: 
	@virt-viewer --connect=$(QEMU_URL)


vm-create-ubuntu: export VM_OS_VARIANT=ubuntu18.04
vm-create-ubuntu: export VM_CPUS=2
vm-create-ubuntu: export VM_RAM=4096
vm-create-ubuntu: export VM_DISK=10
vm-create-ubuntu: export VM_IMAGE_LOCATION=$(ISO_URL)/ubuntu-18.04.3-live-server-amd64.iso
vm-create-ubuntu: 
	@virt-install --connect=$(QEMU_URL) \
		--virt-type kvm \
		--name $(VM_NAME) \
		--ram $(VM_RAM) \
		--vcpus $(VM_CPUS) \
		--network bridge=$(BRIDGE_IFACE_NAME) \
		--cdrom $(VM_IMAGE_LOCATION) \
		--disk path=$(VM_PATH)/$(VM_NAME).img,size=$(VM_DISK) \
		--graphics vnc \
		--os-type linux \
		--os-variant $(VM_OS_VARIANT)


vm-create-centos7: export VM_OS_VARIANT=rhel7
vm-create-centos7: export VM_CPUS=2
vm-create-centos7: export VM_RAM=4096
vm-create-centos7: export VM_DISK=10
vm-create-centos7: export VM_IMAGE_LOCATION=$(ISO_URL)/CentOS-7-x86_64-Minimal-1611.iso
vm-create-centos7: 
	@virt-install --connect=$(QEMU_URL) \
		--virt-type kvm \
		--name $(VM_NAME) \
		--ram $(VM_RAM) \
		--vcpus $(VM_CPUS) \
		--network bridge=$(BRIDGE_IFACE_NAME) \
		--cdrom $(VM_IMAGE_LOCATION) \
		--disk path=$(VM_PATH)/$(VM_NAME).img,size=$(VM_DISK) \
		--graphics vnc \
		--os-type linux \
		--os-variant $(VM_OS_VARIANT)

vm-create-rhel8: export VM_OS_VARIANT=rhel7
vm-create-rhel8: export VM_CPUS=2
vm-create-rhel8: export VM_RAM=4096
vm-create-rhel8: export VM_DISK=50
vm-create-rhel8: export VM_IMAGE_LOCATION=$(ISO_URL)/rhel-8.3-x86_64-dvd.iso
vm-create-rhel8: 
	@virt-install --connect=$(QEMU_URL) \
		--virt-type kvm \
		--name $(VM_NAME) \
		--ram $(VM_RAM) \
		--vcpus $(VM_CPUS) \
		--cdrom $(VM_IMAGE_LOCATION) \
		--disk path=$(VM_PATH)/$(VM_NAME).img,size=$(VM_DISK) \
		--graphics vnc \
		--os-type linux \
		--os-variant $(VM_OS_VARIANT)


vm-clone:
	@virt-clone --auto-clone --original $(VM_SOURCE) --name $(VM_TARGET)


vm-snapshot:
	@virsh snapshot-create-as --domain  $(VM_NAME) --name "$(VM_SNAP_NAME)"


ifndef VM_NAME
$(error VM_NAME is required)
endif

ifndef QEMU_URL
$(error QEMU_URL is required)
endif

ifndef ISO_URL
$(error ISO_URL is required)
endif
