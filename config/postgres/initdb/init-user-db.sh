#!/usr/bin/env bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    \c $POSTGRES_DB
     SELECT 'Database initialized';
    CREATE USER keycloak WITH PASSWORD 'keycloak';
    SELECT '######### User keycloak created successfully.';
    GRANT ALL PRIVILEGES ON DATABASE "$POSTGRES_DB" TO keycloak;
    GRANT ALL PRIVILEGES ON DATABASE "$POSTGRES_DB" TO postgres;
    
    CREATE SCHEMA IF NOT EXISTS keycloak AUTHORIZATION keycloak;
    CREATE SCHEMA IF NOT EXISTS certifications AUTHORIZATION postgres;
    SELECT 'Schemas initialized';
   
   
    SELECT 'Initialization complete';

EOSQL