Simple Java EE 7 Demo Application EAR 
==============================================================================================
Author: Pawel Malczyk

Test Environment
-------------------

1. Maven 3.1
2. Java 1.8
3. WildFly 8.2.0

Preconditions
---------------

1. Running mySQL server
2. Created database user that has granted administrative rights (create database)
3. Running WildFly server


Running Demo
---------------


1. In case when there is a  plain WildFly server that doesn't have mySQL driver configured/installed (otherwise this step can be skipped)

        Edit:   ${PROJECT_HOME}/install_jdbc.sh 

        Set WILDFLY_HOME variable in script file to match you installation directory

2. Edit simple-app/application.properties file and set appropriate values
3. Run maven build script
	
        mvn clean package  wildfly:deploy

Build Script
---------------

Build script will take care of all steps that may be needed

1. Compile and pakage application
2. Create JNDI WildFly data source
3. Initialize database schema using liquibase tool

Verification
--------------- 

Once all setps are completed navigate to  http://localhost:8080/simple-app-web
