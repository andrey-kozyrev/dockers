CREATE EXTERNAL TABLE IF NOT EXISTS metrics_csv1000Ks (
  userId BIGINT,
  tx DATE,
  steps INT,
  distance INT,
  calories INT,
  floors INT,
  mets INT,
  age STRING,
  alcohol STRING,
  car STRING,
  cluster STRING,
  department STRING,
  eyes STRING,
  gender STRING,
  hair STRING,
  race STRING,
  remote STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
LOCATION '/data/mf1000K';

CREATE EXTERNAL TABLE IF NOT EXISTS metrics_csv (
  mon INT,
  tx DATE,
  programId BIGINT,
  userId BIGINT,
  vals map<STRING, BIGINT>,
  tags map<STRING, STRING>
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '|'
COLLECTION ITEMS TERMINATED BY ','
MAP KEYS TERMINATED BY ':'
LINES TERMINATED BY '\n'
LOCATION 'hdfs://namenode/dat/metrics_csv';

CREATE TABLE IF NOT EXISTS metrics (
  tx DATE,
  programId BIGINT,
  userId BIGINT,
  vals map<STRING, BIGINT>,
  tags map<STRING, STRING>
)
PARTITIONED BY(mon INT)
CLUSTERED BY (programId) SORTED BY (tx) INTO 32 BUCKETS
STORED AS ORC;

set hive.exec.reducers.max=4
set mapreduce.job.reduces=4

CREATE TABLE IF NOT EXISTS metrics_mon_tx (
  tx DATE,
  programId BIGINT,
  userId BIGINT,
  vals map<STRING, BIGINT>,
  tags map<STRING, STRING>
)
PARTITIONED BY (mon INT)
CLUSTERED BY (tx) SORTED BY (programId) INTO 31 BUCKETS
STORED AS ORC;


CLUSTERED BY (programId) SORTED BY (tx) INTO 16 BUCKETS


INSERT INTO metrics SELECT * FROM metrics_csv;
