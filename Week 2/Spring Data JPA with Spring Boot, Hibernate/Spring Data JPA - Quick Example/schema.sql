-- Run these commands in MySQL client to set up the database

-- 1. Create schema
CREATE SCHEMA ormlearn;

-- 2. Use the schema
USE ormlearn;

-- 3. Create country table
CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50)
);

-- 4. Insert sample data
INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');
