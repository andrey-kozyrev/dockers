FROM java:8

ENV HADOOP_VER 2.7.2

RUN cd /usr/lib \
 && wget -q https://archive.apache.org/dist/hadoop/core/hadoop-$HADOOP_VER/hadoop-$HADOOP_VER.tar.gz \
 && tar -xf hadoop*.tar.gz \
 && rm hadoop*.tar.gz

ENV HADOOP_HOME /usr/lib/hadoop-$HADOOP_VER
ENV HADOOP_CONF_DIR $HADOOP_HOME/etc/hadoop
ENV HADOOP_DAT_DIR /var/dat/hadoop
ENV HADOOP_NAMENODE_DIR $HADOOP_DAT_DIR/namenode
ENV HADOOP_DATANODE_DIR $HADOOP_DAT_DIR/datanode

ENV PATH $HADOOP_HOME/bin:$PATH

RUN mkdir -p $HADOOP_NAMENODE_DIR $HADOOP_DATANODE_DIR

ADD hdfs-site.xml $HADOOP_CONF_DIR/
ADD core-site.xml $HADOOP_CONF_DIR/
ADD yarn-site.xml $HADOOP_CONF_DIR/

RUN hdfs namenode -format
