#!/bin/bash
#
# Use only if wildfly doesn't have JDBC driver installed already
#
# THIS SCRIPT WILL REINSTALL module
#

set -x


WILDFLY_HOME=/home/malczyk/Devel/tools/wildfly-8.2.0.Final
MODULES_HOME=$WILDFLY_HOME/modules/system/layers/base
MYSQL_MODULE_HOME=$MODULES_HOME/com/mysql/main


if [  -d $MYSQL_MODULE_HOME ]; then
	echo "Driver already exists reinstalling"
	$WILDFLY_HOME/bin/jboss-cli.sh   --connect '--command=/subsystem=datasources/jdbc-driver=mysql:remove'
	rm -fr $MYSQL_MODULE_HOME
fi

mkdir -p $MODULES_HOME/com/mysql/main
cp module.xml $MYSQL_MODULE_HOME 
wget -P $MYSQL_MODULE_HOME http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.34/mysql-connector-java-5.1.34.jar

$WILDFLY_HOME/bin/jboss-cli.sh --connect --command="/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql, driver-module-name=com.mysql, driver-class-name=com.mysql.jdbc.Driver)"
