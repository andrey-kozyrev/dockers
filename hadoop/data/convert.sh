tar -xOf mf1000K.csv.gz | tail -n +2 | cut -d ',' -f2-4,6,8,12,24,36-100
