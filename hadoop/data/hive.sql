CREATE TABLE IF NOT EXISTS metrics_csv (
  programId BIGINT,
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
STORED AS TEXTFILE
LOCATION '/data/metrics1K.csv';

CREATE TABLE IF NOT EXISTS metrics (
  programId BIGINT,
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
