
Create a database in PostgreSQL called notebooksdb.

Create a connection pool by putting in the following commands in the command window (Don't close it even after writing the commands):
>asadmin

>create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGSimpleDataSource --restype javax.sql.XADataSource --property portNumber=5432:password=postgres:user=postgres:serverName=localhost:databaseName=notebooksdb jpa_notebooksdb_postgresql_pool

Go to localhost:4848 > Look at the Common Tasks box > Resources > JDBC > JDBC Connection Pools > click jpa_person_postgresql_pool > press the ping button and pray it will work.

Go back to the command window and put in:
>create-jdbc-resource --connectionpoolid jpa_notebooksdb_postgresql_pool jdbc/notebooksdb

If all of those above steps were completed then they don't need to be done again.

Example data for the database will be generated when the application runs.
