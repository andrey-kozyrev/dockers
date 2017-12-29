FROM hadoop_hnn

ENV HIVE_VER 2.3.2

RUN cd /usr/lib \
 && wget -q https://archive.apache.org/dist/hive/hive-$HIVE_VER/apache-hive-$HIVE_VER-bin.tar.gz \
 && tar -xf apache-hive*.tar.gz \
 && rm *.tar.gz

ENV HIVE_HOME /usr/lib/apache-hive-$HIVE_VER-bin
ENV HIVE_CONF_DIR $HIVE_HOME/conf

RUN apt-get update \
 && apt-get install libmysql-java \
 && ln -s /usr/share/java/mysql-connector-java.jar $HIVE_HOME/lib/mysql-connector-java.jar

RUN ls $HIVE_HOME/lib

ENV PATH $HIVE_HOME/bin:$PATH

ADD hive-site.xml $HIVE_CONF_DIR/

#RUN hdfs namenode -format

#RUN $HADOOP_HOME/bin/hadoop fs -mkdir /tmp /user/hive/warehouse
#RUN $HADOOP_HOME/bin/hadoop fs -mkdir /user/hive/warehouse
