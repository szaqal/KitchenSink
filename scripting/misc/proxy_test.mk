test-squid: export http_proxy=$(PROXY_HOST)
test-squid:
	wget http://centos.wielun.net/8.3.2011/isos/x86_64/CentOS-8.3.2011-x86_64-boot.iso

ifndef PROXY_HOST
$(error PROXY_HOST is required)
endif
