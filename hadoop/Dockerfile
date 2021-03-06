FROM java:8

ARG HADOOP_VER
ARG HIVE_VER
ARG PRESTO_VER
ARG PIG_VER
ARG SPARK_VER

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update \
 && apt-get install -y apt-utils \
 && apt-get install -y less libmysql-java

WORKDIR /usr/lib

RUN wget -q https://archive.apache.org/dist/hadoop/core/hadoop-$HADOOP_VER/hadoop-$HADOOP_VER.tar.gz
RUN wget -q https://archive.apache.org/dist/hive/hive-$HIVE_VER/apache-hive-$HIVE_VER-bin.tar.gz
RUN wget -q https://archive.apache.org/dist/pig/pig-$PIG_VER/pig-$PIG_VER.tar.gz
RUN wget -q https://archive.apache.org/dist/spark/spark-$SPARK_VER/spark-$SPARK_VER-bin-without-hadoop.tgz
RUN wget -q https://repo1.maven.org/maven2/com/facebook/presto/presto-server/$PRESTO_VER/presto-server-$PRESTO_VER.tar.gz
RUN wget -q https://repo1.maven.org/maven2/com/facebook/presto/presto-cli/$PRESTO_VER/presto-cli-$PRESTO_VER-executable.jar

ENV HADOOP_HOME /usr/lib/hadoop
ENV HADOOP_CONF_DIR $HADOOP_HOME/etc/hadoop
ENV YARN_CONF_DIR $HADOOP_CONF_DIR
ENV HADOOP_DAT_DIR /var/dat/hadoop
ENV HADOOP_NAMENODE_DIR $HADOOP_DAT_DIR/namenode
ENV HADOOP_DATANODE_DIR $HADOOP_DAT_DIR/datanode
ENV PATH $PATH:$HADOOP_HOME/bin
ENV LD_LIBRARY_PATH=$HADOOP_HOME/lib/native/:$LD_LIBRARY_PATH

ENV HIVE_HOME /usr/lib/hive
ENV HIVE_CONF_DIR $HIVE_HOME/conf
ENV HCAT_HOME $HIVE_HOME/hcatalog
ENV PATH $PATH:$HIVE_HOME/bin:$HCAT_HOME/bin:$HCAT_HOME/sbin

ENV PRESTO_HOME /usr/lib/presto
ENV PRESTO_CONF_DIR $PRESTO_HOME/etc
ENV PATH $PATH:$PRESTO_HOME/bin

ENV PIG_HOME /usr/lib/pig
ENV PATH $PATH:$PIG_HOME/bin

ENV SPARK_HOME /usr/lib/spark
ENV SPARK_CONF_DIR $SPARK_HOME/conf
ENV PATH $PATH:$SPARK_HOME/bin

RUN tar -xf hadoop*.tar.gz \
 && rm hadoop*.tar.gz \
 && mv hadoop-$HADOOP_VER hadoop \
 && mkdir -p $HADOOP_NAMENODE_DIR $HADOOP_DATANODE_DIR

RUN tar -xf apache-hive*.tar.gz \
 && rm apache-hive*.tar.gz \
 && mv apache-hive-$HIVE_VER-bin hive \
 && rm /usr/lib/hive/lib/log4j-slf4j-impl-2.6.2.jar \
 && ln -s /usr/share/java/mysql-connector-java.jar $HIVE_HOME/lib/mysql-connector-java.jar

RUN tar -xf pig*.tar.gz \
 && rm pig*.tar.gz \
 && mv pig-$PIG_VER pig

RUN tar -xf spark*.tgz \
 && rm spark*.tgz \
 && mv spark-$SPARK_VER-bin-without-hadoop spark

 RUN tar -xf presto*.tar.gz \
  && rm presto*.tar.gz \
  && mv presto-server-$PRESTO_VER presto \
  && mv presto-cli-$PRESTO_VER-executable.jar presto/bin/presto-cli.jar \
  && chmod +x presto/bin/presto-cli.jar \
  && mkdir -p /var/dat/presto

#RUN group add hadoop \
# && useradd -g hadoop hive
