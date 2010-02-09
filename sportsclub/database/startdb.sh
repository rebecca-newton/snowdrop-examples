if [ "x$HSQLDB_JAR_LOCATION" = "x" ]; then
   if [ "x$HSQLDB_HOME" = "x" ]; then
     HSQLDB_JAR_LOCATION=$HOME/.m2/repository/hsqldb/hsqldb/1.8.0.10/hsqldb-1.8.0.10.jar
   else
     HSQLDB_JAR_LOCATION=$HSQLDB_HOME/lib/hsqldb.jar
   fi
fi
java -cp $HSQLDB_JAR_LOCATION org.hsqldb.Server -database.0 file:data/sportsclubdb -dbname.0 sportsclubdb db-setup.sql