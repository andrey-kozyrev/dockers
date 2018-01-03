#!/bin/bash
if [ ! "$(ls -A $HADOOP_NAMENODE_DIR)" ]; then
  hdfs namenode -format
fi
exec hdfs namenode
