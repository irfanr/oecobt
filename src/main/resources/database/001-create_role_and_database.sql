-- kill session
SELECT pg_terminate_backend(pg_stat_activity.procpid)
FROM pg_stat_activity
WHERE 
pg_stat_activity.datname IN ( 'oecobt');

-- drop object owned by role
DROP OWNED BY oecobt CASCADE;

-- drop before create
DROP DATABASE IF EXISTS "oecobt";
DROP ROLE IF EXISTS oecobt;

-- Role: oecobt

-- DROP ROLE oecobt;

CREATE ROLE oecobt LOGIN
  ENCRYPTED PASSWORD 'md573f733916f0b929e625d8cfe651902d1'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;


-- create database with owner just created
CREATE DATABASE "oecobt"
WITH OWNER = oecobt
ENCODING = 'UTF8'
TABLESPACE = pg_default
LC_COLLATE = 'en_US.UTF-8'
LC_CTYPE = 'en_US.UTF-8'
CONNECTION LIMIT = -1; 
