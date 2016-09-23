CREATE TABLE IF NOT EXISTS flights.flights_by_carrier_num (
    carrier text,
    number text,
    year int,
    month int,
    day int,
    tail text,
    departed int,
    arrived int,
    elapsed int,
    air int,
    arrival_delay int,
    departure_delay int,
    origin text,
    destination text,
    distance int,
    cancelled boolean,
    PRIMARY KEY ((carrier, number), year, month, day)
)