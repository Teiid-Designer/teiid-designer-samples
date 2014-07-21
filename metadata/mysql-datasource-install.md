# What's this

This documents supply 2 ways to install Mysql datasource to JBoss EAP 6.x.

> Note that we have mysql database **customer** and `jdv_user/jdv_pass` have full rights to access the database.

# Create a datasource from the JBoss CLI

~~~
module add --name=com.mysql --resources=/home/kylin/work/tools/jars/mysql-connector-java-5.1.6.jar --dependencies=javax.api,javax.transaction.api
/subsystem=datasources/jdbc-driver=mysql:add(driver-module-name=com.mysql, driver-name=mysql, driver-xa-datasource-class-name=com.mysql.jdbc.jdbc2.optional.MysqlXADataSource)
/subsystem=datasources/data-source=mysql:add(jndi-name=java:/accounts-ds, enabled=true, use-java-context=true, driver-name=mysql, connection-url="jdbc:mysql://localhost:3306/customer", user-name=jdv_user, password=jdv_pass)
/subsystem=datasources/data-source=mysql:enable
/:reload
~~~

# Create a datasource via modifing the datasource file

* Create a directory under $JBOSS_HOME/modules

For example, we create `$JBOSS_HOME/modules/com/mysql/main`

* Put the the JDBC driver jar (mysql-connector-java-5.1.6.jar) to this directory

* Create a module configuration file module.xml:

~~~
<?xml version="1.0" ?>

<module xmlns="urn:jboss:module:1.1" name="com.mysql">

    <resources>
        <resource-root path="mysql-connector-java-5.1.6.jar"/>
    </resources>

    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>
~~~

* Add datasource configuration as bellow:

~~~
                <datasource jndi-name="java:/accounts-ds" pool-name="mysql" enabled="true" use-java-context="true">
                    <connection-url>jdbc:mysql://localhost:3306/customer</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>jdv_user</user-name>
                        <password>jdv_pass</password>
                    </security>
                </datasource>
~~~

* Add drivers configures as below:

~~~
                    <driver name="mysql" module="com.mysql">
                        <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
                    </driver>
~~~
