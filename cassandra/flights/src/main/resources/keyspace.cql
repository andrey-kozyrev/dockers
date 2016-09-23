CREATE KEYSPACE IF NOT EXISTS flights
WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 2 }