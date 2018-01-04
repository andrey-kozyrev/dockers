IMG=ak/hadoop
NETWORK=hadoop_default
CORE_SITE=`pwd`/HADOOP/core-site.xml:/usr/lib/hadoop/etc/hadoop/core-site.xml:ro
HDFS_SITE=`pwd`/HADOOP/hdfs-site.xml:/usr/lib/hadoop/etc/hadoop/hdfs-site.xml:ro
YARN_SITE=`pwd`/HADOOP/yarn-site.xml:/usr/lib/hadoop/etc/hadoop/yarn-site.xml:ro
SPARK_ENV=`pwd`/SPARK/spark-env.sh:/usr/lib/spark/conf/spark-env.sh:ro
SPARK_LOG4J=`pwd`/SPARK/log4j.properties:/usr/lib/spark/conf/log4j.properties:ro
DATA=`pwd`/DATA:/var/dat/data:ro
WORKDIR=/var/dat/data

.PHONY: build up halt rm logs init bash pig hive spark presto

build:
	docker build --build-arg HADOOP_VER=2.7.2 --build-arg HIVE_VER=2.3.2 --build-arg PRESTO_VER=0.191 --build-arg PIG_VER=0.17.0 --build-arg SPARK_VER=2.2.1 --tag ak/hadoop .

up:
	docker-compose up

halt:
	docker-compose stop

rm:
	docker-compose rm -fv

logs:
	docker-compose logs -f

init:
	docker-compose up mysql

bash:
	docker run -ti --network=${NETWORK} -v ${CORE_SITE} -v ${HDFS_SITE} -v ${YARN_SITE} -v ${DATA} -w ${WORKDIR} ${IMG} bash

pig:
	docker run -ti --network=${NETWORK} -v ${CORE_SITE} -v ${HDFS_SITE} -v ${YARN_SITE} -v ${DATA} -w ${WORKDIR} ${IMG} pig -x mapreduce

hive:
	docker run -ti --network=${NETWORK} -v ${DATA} -w ${WORKDIR} ${IMG} beeline -u jdbc:hive2://hive:10000 -n hive -p hive

spark:
	docker run -ti --network=${NETWORK} -v ${CORE_SITE} -v ${HDFS_SITE} -v ${YARN_SITE} -v ${SPARK_ENV} -v ${DATA} -w ${WORKDIR} -p "127.0.0.1:4040:4040" ${IMG} spark-shell --master yarn --deploy-mode client

presto:
	docker run -ti --network=${NETWORK} -v ${DATA} -w ${WORKDIR} ${IMG} presto-cli.jar --server presto:8080 --catalog hive --schema default
