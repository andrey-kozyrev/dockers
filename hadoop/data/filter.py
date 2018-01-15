#!/usr/bin/env python
import sys
import csv
from datetime import datetime

for r in csv.reader(iter(sys.stdin.readline, ''), delimiter = '|'):
    userId = int(r[3])
    if userId < 1010000:
        print('%s|%s|%s|%s|%s|%s' % (r[0], r[1], r[2], r[3], r[4], r[5]))
