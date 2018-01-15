#!/usr/bin/env python
import sys
import csv
from datetime import datetime

for r in csv.reader(iter(sys.stdin.readline, '')):
    userId = int(r[0])
    programId = userId % 10000
    tx = datetime.strptime(r[1], '%Y-%m-%d')
    steps = r[2]
    dist = r[3]
    cals = r[4]
    floors = r[5]
    mets = r[6]
    print('%s|%s|%s|%s|steps:%s,distance:%s,calories:%s,floors:%s,mets:%s|age:%s,alcohol:%s,car:%s,city:%s,department:%s,eyes:%s,gender:%s,hair:%s,race:%s,remote:%s' % (tx.month, tx.date(), programId, userId, steps, dist, cals, floors, mets, r[7], r[8], r[9], r[10], r[11], r[12], r[13], r[14], r[15], r[16]))
