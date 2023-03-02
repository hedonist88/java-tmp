--DROP TABLE IF EXISTS event_stat;

CREATE TABLE IF NOT EXISTS event_stat (
    id SERIAL PRIMARY KEY,
    app VARCHAR(100) NOT NULL,
    entity VARCHAR(1000) NOT NULL,
    iid VARCHAR(100) NOT NULL,
    prop VARCHAR(1000) NOT NULL,
    meta VARCHAR(1000) NOT NULL,
    ip VARCHAR(15),
    timestamp TIMESTAMP DEFAULT (now())
);

CREATE INDEX IF NOT EXISTS unique_index_app_entity_iid_data ON event_stat (app, entity, iid, prop);