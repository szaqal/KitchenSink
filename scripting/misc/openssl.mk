CERT_PATH?=/tmp
ROOT_KEY=$(CERT_PATH)/rootCA.key
ROOT_CERT=$(CERT_PATH)/rootCA.crt
ROOT_VALIDITY=1024
ROOT_SUBJECT?="/C=PL/ST=MA/O=Dummy Inc./CN=dummy.com"
CLNT_SUBJECT?="/C=US/ST=CA/O=MyOrg, Inc./CN=client.com"

clean:
	@rm -frv $(CERT_PATH)

init: clean
	@mkdir -p $(CERT_PATH)


gen-root-selfsigned: init
	@openssl genrsa -out $(ROOT_KEY) 4096
	@openssl req -x509 -new -nodes -key $(ROOT_KEY)  -subj $(ROOT_SUBJECT) -sha256 -days $(ROOT_VALIDITY) -out $(ROOT_CERT)

# gen-root-selfsigned need first
gen-client: KEY_FILE=$(CERT_PATH)/client.key
gen-client: CSR_FILE=$(CERT_PATH)/client.csr
gen-client: CRT_FILE=$(CERT_PATH)/client.crt
gen-client:
	@openssl genrsa -out $(KEY_FILE) 2048
	@openssl req -new -sha256 -key $(KEY_FILE) -subj $(CLNT_SUBJECT) -out $(CSR_FILE)
	@openssl x509 -req -in $(CSR_FILE) -CA $(ROOT_CERT) -CAkey $(ROOT_KEY) -CAcreateserial -out $(CRT_FILE) -days 500 -sha256


show-root:
	@openssl x509 -in $(ROOT_CERT) -text -noout

show-client: CRT_FILE=$(CERT_PATH)/client.crt
show-client:
	@openssl x509 -in $(CRT_FILE) -text -noout

hash-sha256:
	@openssl dgst -sha256 /etc/passwd
