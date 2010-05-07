if "x%HSQLDB_JAR_LOCATION%" == "x" (
   if "x%HSQLDB_HOME%" == "x" (
     HSQLDB_JAR_LOCATION=%USERPROFILE%/.m2/repository/hsqldb/hsqldb/1.8.0.10/hsqldb-1.8.0.10.jar
   )
   else (
     HSQLDB_JAR_LOCATION=%HSQLDB_HOME%/lib/hsqldb.jar
   )
)
java -cp %HSQLDB_JAR_LOCATION% org.hsqldb.Server -database.0 file:data/sportsclubdb -dbname.0 sportsclubdb