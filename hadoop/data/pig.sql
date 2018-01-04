csv = LOAD '/data/mf1K.csv.gz' USING PigStorage(',') AS (programId:long, userId:long, date:datetime, steps:int, steps_consolidated:int, distance:int, distance_consolidated:int, calories:int, calories_consolidated:int, activity_calories:int, activity_calories_consolidated:int, floors:int, floors_consolidated:int, min_active_very:int, min_active_very_consolidated:int, min_active_moderately:int, min_active_moderately_consolidated:int, min_active_total:int, min_active_total_consolidated:int, min_active_lightly:int, min_active_lightly_consolidated:int, min_active_very_and_moderate:int, min_active_very_and_moderate_consolidated:int, mets:int, mets_consolidated:int, activity_mets:int, activity_mets_consolidated:int, manual_activities:int, min_in_sleep_period:int, woken_up_count:int, min_asleep:int, sleep_start_time:int, sleep_end_time:int, min_to_fall_asleep:int, min_after_wakeup:int, age:chararray, alcohol:chararray, car:chararray, cluster:chararray, department:chararray, eyes:chararray, gender:chararray, hair:chararray, race:chararray, remote:chararray);

csv = FOREACH csv GENERATE programId, userId, date, steps, distance, calories, floors, mets, age, alcohol, car, cluster, department, eyes, gender, hair, race, remote;

csv = FILTER csv BY userId IS NOT NULL;

csv = ORDER csv BY programId, date;

STORE csv INTO '/data/metrics1K.csv' USING PigStorage(',');
