FROM library/alpine

RUN apk add --update curl \
 && rm -rf /var/cache/apk/*

ADD *.sh /
ADD datasource.json /

ENTRYPOINT ["/init.sh"]
