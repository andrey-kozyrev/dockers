IMG=ak/hadoop
NETWORK=hadoop_default
CORE_SITE=`pwd`/HADOOP/core-site.xml:/usr/lib/hadoop/etc/hadoop/core-site.xml:ro
HDFS_SITE=`pwd`/HADOOP/hdfs-site.xml:/usr/lib/hadoop/etc/hadoop/hdfs-site.xml:ro
YARN_SITE=`pwd`/HADOOP/yarn-site.xml:/usr/lib/hadoop/etc/hadoop/yarn-site.xml:ro
SPARK_ENV=`pwd`/SPARK/spark-env.sh:/usr/lib/spark/conf/spark-env.sh:ro
SPARK_LOG4J=`pwd`/SPARK/log4j.properties:/usr/lib/spark/conf/log4j.properties:ro

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

msq:
	docker-compose up msq

hms:
	docker-compose up hms

bash:
	docker run -ti --network=${NETWORK} -v ${CORE_SITE} -v ${HDFS_SITE} -v ${YARN_SITE} ${IMG} bash

bee:
	docker run -ti --network=${NETWORK} ${IMG} beeline -u jdbc:hive2://hhs:10000 -n hive -p hive

sparks:
	docker run -ti --network=${NETWORK} -v ${CORE_SITE} -v ${HDFS_SITE} -v ${YARN_SITE} -v ${SPARK_ENV} -p "127.0.0.1:4040:4040" ${IMG} spark-shell --master yarn --deploy-mode client
