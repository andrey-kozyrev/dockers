SELECT tx, avg(vals['steps']) from metrics WHERE programId = 1 AND mon >= 9 AND tags['car'] = 'BMW' AND tags['remote'] = 'Yes' AND tags['gender'] = 'Male' AND tags['alcohol'] = 'Wine' group by 1 order by 1;

Query 20180118_163500_00005_2753f, FINISHED, 1 node
Splits: 81 total, 81 done (100.00%)
0:48 [122M rows, 1.38GB] [2.53M rows/s, 29.3MB/s]

SELECT tx, avg(vals['steps']) from metrics WHERE programId = 1 AND tags['car'] = 'BMW' AND tags['gender'] = 'Female' group by 1 order by 1;
Query 20180118_163814_00008_2753f, FINISHED, 1 node
Splits: 176 total, 176 done (100.00%)
6:29 [366M rows, 4.14GB] [940K rows/s, 10.9MB/s]



ssh -o ProxyCommand="ssh -W %h:%p ubuntu@ec2-23-21-14-43.compute-1.amazonaws.com" hadoop@ip-10-1-0-193.ec2.internal

ssh -o ProxyCommand="ssh -W %h:%p ubuntu@ec2-23-21-14-43.compute-1.amazonaws.com" hadoop@ip-10-1-0-109.ec2.internal


EMR:

3 nodes

presto:default> select tx, avg(vals['steps']) from metrics_orc where tags['car'] = 'Ford' and tags['remote'] = 'No' group by tx order by tx;
Query 20180123_094844_00022_i8euw, FINISHED, 3 nodes
Splits: 252 total, 252 done (100.00%)
1:53 [366M rows, 4.15GB] [3.25M rows/s, 37.8MB/s]
