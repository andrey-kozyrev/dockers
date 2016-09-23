FROM centos:7

MAINTAINER Peter Ericson <pdericson@gmail.com>

# centos
RUN yum update -y \
 && yum install -y wget which

ARG DUMB_INIT_VERSION
ARG MESOS_VERSION
ARG AURORA_VERSION

# dumb-init
RUN curl -fLsS -o /usr/local/bin/dumb-init https://github.com/Yelp/dumb-init/releases/download/v${DUMB_INIT_VERSION}/dumb-init_${DUMB_INIT_VERSION}_amd64 \
 && chmod +x /usr/local/bin/dumb-init

# docker
RUN curl -fLsS https://get.docker.com/ | sh

# mesos 
RUN rpm -i http://repos.mesosphere.io/el/7/noarch/RPMS/mesosphere-el-repo-7-1.noarch.rpm \
 && yum install -y mesos-${MESOS_VERSION}
ENV MESOS_SYSTEMD_ENABLE_SUPPORT false
ENV MESOS_EXECUTOR_REGISTRATION_TIMEOUT 5mins
ENV MESOS_QUORUM 1
ENV MESOS_REGISTRY in_memory
ENV MESOS_LOGGING_LEVEL INFO
ENV MESOS_WORK_DIR /tmp/mesos
ENV MESOS_LOG_DIR /var/log/mesos
ENV MESOS_CONTAINERIZERS docker,mesos
ENV MESOS_SWITCH_USER false 
VOLUME ${MESOS_WORK_DIR}
VOLUME ${MESOS_LOG_DIR}

# aurora
RUN wget -c -q https://apache.bintray.com/aurora/centos-7/aurora-scheduler-${AURORA_VERSION}-1.el7.centos.aurora.x86_64.rpm \
 && yum install -y aurora-scheduler-${AURORA_VERSION}-1.el7.centos.aurora.x86_64.rpm \
 && rm *.rpm
RUN wget -c -q https://apache.bintray.com/aurora/centos-7/aurora-executor-${AURORA_VERSION}-1.el7.centos.aurora.x86_64.rpm \
 && yum install -y aurora-executor-${AURORA_VERSION}-1.el7.centos.aurora.x86_64.rpm \
 && rm *.rpm

RUN mkdir -p /var/lib/aurora/scheduler/db \
 && mesos-log initialize --path=/var/lib/aurora/scheduler/db

RUN sed -i 's/\x27example\x27/$MESOS_CLUSTER/' /etc/sysconfig/aurora-scheduler \
 && sed -i 's/\x27127.0.0.1:2181\x27/$ZK_ENDPOINTS/' /etc/sysconfig/aurora-scheduler \
 && sed -i 's/\x27zk:\/\/127.0.0.1:2181\/mesos\x27/$MESOS_MASTER/' /etc/sysconfig/aurora-scheduler \
 && sed -i 's/\x27127.0.0.1:2181\x27/$ZK_ENDPOINTS/' /etc/sysconfig/aurora-scheduler \
 && sed -i 's/\x27--announcer-ensemble 127.0.0.1:2181\x27/"--announcer-ensemble $ZK_ENDPOINTS"/' /etc/sysconfig/aurora-scheduler \
 && cat /etc/sysconfig/aurora-scheduler
