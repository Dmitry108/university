DROP SCHEMA IF EXISTS university CASCADE;
CREATE SCHEMA IF NOT EXISTS university;

DROP TABLE IF EXISTS university.students;
CREATE TABLE IF NOT EXISTS university.students (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    age INT);