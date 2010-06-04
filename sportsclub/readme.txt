Sportsclub Spring JBoss Integration example
===========================================

Prerequisites:

A. Maven Repository setup

The Maven project setup does not make any assumptions where the artifacts used
in the project are coming from (which repository), as users may have different
settings for their Maven repositories (direct access to community repositories,
proxies, enterprise repository with approved artifacts). Therefore, the setup
of the repositories is left to the user of the application.

The example is pre-configured with the JBoss community repositories.

The pom.xml can be modified to include references to other repositories, or
equivalent artifact versions (if the build environment uses an enterprise-wide
repository in which the artifacts have different version numbers).

Further instructions on how to set up the community repositories can be
found at: http://community.jboss.org/wiki/MavenGettingStarted-Users.

B. Spring Deployer installed in JBoss AS

For running the application, the Spring Deployer must be installed in JBoss AS.
Please refer to the Snowdrop documentation for details.

For building & running the application:

1. Execute a Maven build from the root folder of the example

mvn clean package

Note: the application can use two different profiles, one for Spring 2.5 and
one for Spring 3. The default profile is Spring 2.5. For building the Spring 3
version of the application, use:

mvn clean package -Pspring-3

2. Setup the data source and JMS destination:

  a) enter the jbossconf directory
     cd jbossconf

  b) modify the jbossconf/jbossas.properties file to indicate the correct location
  of the JBoss AS installation

  c) execute the maven build:

    mvn -Pinstall

3. Initialize the database

   a) enter the database directory

      cd database

   b) execute the maven build

      mvn -Pdb-setup

4. Start the database

   a) execute the database startup script from the database directory (instructions):

      on Linux and other *nix-like systems: ./startdb.sh
      on Windows: ./startdb.bat

5. Deploy the application

   Copy one of the two ears produced by the build to the deploy folder of JBoss AS.

   The deployment folder is: JBOSS_HOME/server/default/deploy

   The two (alternative) build files are:

   sportsclub-ear/target/sportsclub.ear (Hibernate-based implementation)

   sportsclub-jpa-ear/target/sportsclub.ear (JPA-based implementation, using Hibernate as the underlying provider)

6. Start JBoss AS

7. Point the browser at one of:

   http://localhost:8080/sportsclub/invoicing
   http://localhost:8080/sportsclub/reservations
   http://localhost:8080/sportsclub/subscriptions


Steps 1,2,3 need to be executed only once for setting up the runtime environment.

Step 3 can be repeated any time in order to reset the database (with the application stopped).

Steps 5,6 do not need to be executed in a particular order, but the database must be started
before the application is deployed.

8. Special note: JMS integration can be enabled and disabled by commenting and respectively uncommenting
the following line from sportsclub-invoicing-webmvc/src/main/webapp/WEB-INF/spring-business-context.xml :

<import resource="spring-messaging-context.xml"/>

If the line is commented, then JMS integration will not be enabled. This feature allows to run Sportsclub using
the JBoss AS Web Profile.




      
