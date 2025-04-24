#https://github.com/etcd-io/etcd/releases/

DOWNLOAD_DIR=/tmp/etcd-download-test
CERT_PATH=certs

IP_ADDR=192.168.1.155

download: GOOGLE_URL=https://storage.googleapis.com/etcd
download: GITHUB_URL=https://github.com/etcd-io/etcd/releases/download
download: ETCD_VER=v3.4.14
download: DOWNLOAD_URL=$(GOOGLE_URL)
download:
	rm -f /tmp/etcd-$(ETCD_VER)-linux-amd64.tar.gz
	rm -rf $(DOWNLOAD_DIR)  && mkdir -p $(DOWNLOAD_DIR)
	curl -L $(DOWNLOAD_URL)/$(ETCD_VER)/etcd-$(ETCD_VER)-linux-amd64.tar.gz -o /tmp/etcd-$(ETCD_VER)-linux-amd64.tar.gz
	tar xzvf /tmp/etcd-$(ETCD_VER)-linux-amd64.tar.gz -C /tmp/etcd-download-test --strip-components=1
	rm -f /tmp/etcd-$(ETCD_VER)-linux-amd64.tar.gz

ctl-member-list:
	@$(DOWNLOAD_DIR)/etcdctl --endpoints=$(IP_ADDR):2371,$(IP_ADDR):2372,$(IP_ADDR):2373 \
		--cacert=$(CERT_PATH)/ca.pem \
		--cert=$(CERT_PATH)/node.pem \
		--key=$(CERT_PATH)/node-key.pem \
		member list -w table

ctl-status:
	@$(DOWNLOAD_DIR)/etcdctl --endpoints=$(IP_ADDR):2371,$(IP_ADDR):2372,$(IP_ADDR):2373 \
		--cacert=$(CERT_PATH)/ca.pem \
		--cert=$(CERT_PATH)/node.pem \
		--key=$(CERT_PATH)/node-key.pem \
		endpoint status -w table

keys:
	@$(DOWNLOAD_DIR)/etcdctl --endpoints=$(IP_ADDR):2371,$(IP_ADDR):2372,$(IP_ADDR):2373 \
		--cacert=$(CERT_PATH)/ca.pem \
		--cert=$(CERT_PATH)/node.pem \
		--key=$(CERT_PATH)/node-key.pem \
		get --prefix f

ctl-perf:
	@$(DOWNLOAD_DIR)/etcdctl --endpoints=$(IP_ADDR):2371,$(IP_ADDR):2372,$(IP_ADDR):2373 \
		--cacert=$(CERT_PATH)/ca.pem \
		--cert=$(CERT_PATH)/node.pem \
		--key=$(CERT_PATH)/node-key.pem \
		check perf

# Doesn't seem to work with TLS
ctl-datascale:
	@$(DOWNLOAD_DIR)/etcdctl --endpoints=$(IP_ADDR):2371,$(IP_ADDR):2372,$(IP_ADDR):2373 \
		--cacert=$(CERT_PATH)/ca.pem \
		--cert=$(CERT_PATH)/node.pem \
		--key=$(CERT_PATH)/node-key.pem \
		--insecure-transport=true \
		check datascale

ctl-cluster-health:
	@$(DOWNLOAD_DIR)/etcdctl --endpoints=$(IP_ADDR):2371,$(IP_ADDR):2372,$(IP_ADDR):2373 \
		--cacert=$(CERT_PATH)/ca.pem \
		--cert=$(CERT_PATH)/node.pem \
		--key=$(CERT_PATH)/node-key.pem \
		endpoint --cluster health

put: KEY=foo
put: VAL=bar
put:
	@$(DOWNLOAD_DIR)/etcdctl --endpoints=$(IP_ADDR):2371,$(IP_ADDR):2372,$(IP_ADDR):2373 \
		--cacert=$(CERT_PATH)/ca.pem \
		--cert=$(CERT_PATH)/node.pem \
		--key=$(CERT_PATH)/node-key.pem \
		put $(KEY) $(VAL)


clean: DATA_DIR=/tmp/etcd
clean:
	rm -frv  $(DATA_DIR)-?
	rm -frv  ./certs

#
# Shared instance variables
#
instance-%: DATA_DIR=/tmp/etcd
instance-run-%: export ETCD_INITIAL_CLUSTER=node1=https://$(IP_ADDR):2381,node2=https://$(IP_ADDR):2382,node3=https://$(IP_ADDR):2383
instance-run-%: export ETCD_NAME=node$(INSTANCE)
instance-run-%: export ETCD_INITIAL_CLUSTER_STATE=new
instance-run-%: export ETCD_INITIAL_CLUSTER_TOKEN=etcd-cluster-1
instance-run-%: export ETCD_DATA_DIR=$(DATA_DIR)-$(INSTANCE)/data 
instance-run-%: export ETCD_WAL_DIR=$(DATA_DIR)-$(INSTANCE)/wal

# CLIENT
instance-run-%: export ETCD_LISTEN_CLIENT_URLS=https://$(IP_ADDR):237$(INSTANCE)
instance-run-%: export ETCD_ADVERTISE_CLIENT_URLS=$(ETCD_LISTEN_CLIENT_URLS)

instance-run-%: export ETCD_CERT_FILE=$(CERT_PATH)/node.pem
instance-run-%: export ETCD_KEY_FILE=$(CERT_PATH)/node-key.pem


# PEER
instance-run-%: export ETCD_PEER_TRUSTED_CA_FILE=$(CERT_PATH)/ca.pem
instance-run-%: export ETCD_PEER_CERT_FILE=$(CERT_PATH)/node.pem
instance-run-%: export ETCD_PEER_KEY_FILE=$(CERT_PATH)/node-key.pem
instance-run-%: export ETCD_LISTEN_PEER_URLS=https://$(IP_ADDR):238$(INSTANCE)
instance-run-%: export ETCD_INITIAL_ADVERTISE_PEER_URLS=https://$(IP_ADDR):238$(INSTANCE)

instance-run-1: INSTANCE=1
instance-run-1:
	mkdir -p $(DATA_DIR)-$(INSTANCE)/data
	mkdir -p $(DATA_DIR)-$(INSTANCE)/wal
	$(DOWNLOAD_DIR)/etcd

instance-run-2: INSTANCE=2
instance-run-2:
	mkdir -p $(DATA_DIR)-$(INSTANCE)/data
	mkdir -p $(DATA_DIR)-$(INSTANCE)/wal
	$(DOWNLOAD_DIR)/etcd

instance-run-3: INSTANCE=3
instance-run-3:
	mkdir -p $(DATA_DIR)-$(INSTANCE)/data
	mkdir -p $(DATA_DIR)-$(INSTANCE)/wal
	$(DOWNLOAD_DIR)/etcd

 
#apt install golang-cfssl
ca:
	mkdir certs
	cfssl gencert -initca ca-csr.json | cfssljson -bare $(CERT_PATH)/ca
	openssl verify -purpose crlsign -CAfile certs/ca.pem $(CERT_PATH)/ca.pem

req:
	cfssl gencert -ca $(CERT_PATH)/ca.pem  -ca-key certs/ca-key.pem -config ca-config.json  ca-csr.json | cfssljson -bare $(CERT_PATH)/node

req-show:
	openssl x509 -in $(CERT_PATH)/node.pem -text -noout

ca-show:
	openssl x509 -in $(CERT_PATH)/ca.pem -text -noout
