FROM java:8

ENV HADOOP_VER 2.7.2
ENV HIVE_VER 2.3.2

RUN cd /usr/lib \
 && wget -q https://archive.apache.org/dist/hadoop/core/hadoop-$HADOOP_VER/hadoop-$HADOOP_VER.tar.gz \
 && tar -xf hadoop*.tar.gz \
 && rm hadoop*.tar.gz \
 && mv hadoop-$HADOOP_VER hadoop

ENV HADOOP_HOME /usr/lib/hadoop
ENV HADOOP_CONF_DIR $HADOOP_HOME/etc/hadoop
ENV HADOOP_DAT_DIR /var/dat/hadoop
ENV HADOOP_NAMENODE_DIR $HADOOP_DAT_DIR/namenode
ENV HADOOP_DATANODE_DIR $HADOOP_DAT_DIR/datanode

RUN mkdir -p $HADOOP_NAMENODE_DIR $HADOOP_DATANODE_DIR

RUN cd /usr/lib \
 && wget -q https://archive.apache.org/dist/hive/hive-$HIVE_VER/apache-hive-$HIVE_VER-bin.tar.gz \
 && tar -xf apache-hive*.tar.gz \
 && rm *.tar.gz \
 && mv apache-hive-$HIVE_VER-bin hive

ENV HIVE_HOME /usr/lib/hive
ENV HIVE_CONF_DIR $HIVE_HOME/conf

RUN apt-get update \
 && apt-get install libmysql-java \
 && ln -s /usr/share/java/mysql-connector-java.jar $HIVE_HOME/lib/mysql-connector-java.jar

ENV PATH $HIVE_HOME/bin:$HADOOP_HOME/bin:$PATH

ADD hdfs-site.xml $HADOOP_CONF_DIR/
ADD core-site.xml $HADOOP_CONF_DIR/
ADD yarn-site.xml $HADOOP_CONF_DIR/
ADD hive-site.xml $HIVE_CONF_DIR/

RUN hdfs namenode -format

#RUN $HADOOP_HOME/bin/hadoop fs -mkdir /tmp /user/hive/warehouse
#RUN $HADOOP_HOME/bin/hadoop fs -mkdir /user/hive/warehouse
