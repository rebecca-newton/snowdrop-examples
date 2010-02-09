Sportsclub Spring JBoss Integration example

For building & running the application:

1. Execute a Maven build from the root folder of the example

mvn clean package

2. Setup the JBoss data source:

cp database/sportsclub-ds.xml <JBOSS_HOME>/server/default/deploy

3. Start the database

database/startdb.sh

4. Reset the database (with the database started)

database/resetdb.sh

