CREATE DATABASE todo_store;
CREATE TABLE IF NOT EXISTS todo (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    completed BOOLEAN
);