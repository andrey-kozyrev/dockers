#!/usr/bin/env python
import sys
import csv
from datetime import datetime

for r in csv.reader(iter(sys.stdin.readline, ''), delimiter = '|'):
    mon = int(r[0])
    if mon == 1:
        print('%s|%s|%s|%s|%s|%s' % (r[0], r[1], r[2], r[3], r[4], r[5]))
