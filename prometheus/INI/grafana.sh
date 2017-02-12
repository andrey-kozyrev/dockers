#!/bin/sh
until curl --user admin:admin http://grf:3000/api/datasources -X GET -fs -o /dev/null
do
  sleep 1
done
if curl --user admin:admin http://grf:3000/api/datasources/name/pms -X GET -fs -o /dev/null
then
  true
else
  curl --user admin:admin http://grf:3000/api/datasources -X POST -s -o /dev/null -H 'Content-Type: application/json' --data-binary "@datasource.json"
fi
