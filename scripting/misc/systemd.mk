list-units:
	systemctl list-units

# systemctl list-units net*
# *.service
list-units:
	systemctl list-units-files

status: name=docker
status:
	systemctl status $(name)

is-enabled: name=docker
is-enabled:
	systemctl is-enabled $(name)

show-props: name=docker
show-props:
	sudo systemctl show --property=Environment $(name)

show:
	systemctl show

journal-out-json:
	journalctl -o json


#-S, --since=, -U, --until=
journal-unit: name=docker
journal-unit:
	journalctl -u $(name)

#--vacuum-size=, --vacuum-time=, --vacuum-files=
journal-disk-usage:
	journalctl --disk-usage

