CREATE TABLE IF NOT EXISTS post
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    description TEXT,
    visible     BOOLEAN,
    created     timestamp,
    city_id     INTEGER
);