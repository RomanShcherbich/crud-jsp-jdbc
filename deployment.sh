#!/bin/bash
cd /d/git/TMS/crud-jsp-jdbc
mvn clean package -Dmaven.test.skip=true
/d/IDE/apache-tomcat-9.0.37/bin/shutdown.sh
rm -rf /d/IDE/apache-tomcat-9.0.37/webapps/crud-jsp-jdbc*
cp /d/git/TMS/crud-jsp-jdbc/target/crud-jsp-jdbc.war /d/IDE/apache-tomcat-9.0.37/webapps/crud-jsp-jdbc.war
/d/IDE/apache-tomcat-9.0.37/bin/startup.sh