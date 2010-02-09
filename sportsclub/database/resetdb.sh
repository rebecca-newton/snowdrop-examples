if [ "x$HSQLDB_JAR_LOCATION" = "x" ]; then
   if [ "x$HSQLDB_HOME" = "x" ]; then
     HSQLDB_JAR_LOCATION=$HOME/.m2/repository/hsqldb/hsqldb/1.8.0.10/hsqldb-1.8.0.10.jar
   else
     HSQLDB_JAR_LOCATION=$HSQLDB_HOME/lib/hsqldb.jar
   fi
fi
java -jar $HSQLDB_JAR_LOCATION --inlineRc URL=jdbc:hsqldb:hsql://localhost/sportsclubdb,USER=sa,PASSWORD=  db-setup.sql