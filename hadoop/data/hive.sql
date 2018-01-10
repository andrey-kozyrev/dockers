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

CREATE EXTERNAL TABLE IF NOT EXISTS metrics_csv2 (
  programId BIGINT,
  mon INT,
  userId BIGINT,
  tx DATE,
  tags map<STRING, STRING>,
  vals map<STRING, BIGINT>
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '|'
COLLECTION ITEMS TERMINATED BY ','
MAP KEYS TERMINATED BY ':'
LINES TERMINATED BY '\n'
LOCATION '/data/mf1000K2';


CREATE TABLE IF NOT EXISTS metrics (
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
STORED AS ORC;

CLUSTERED BY (programId) SORTED BY (tx) INTO 16 BUCKETS
