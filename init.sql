CREATE USER couponuser WITH PASSWORD '123456';
CREATE DATABASE coupondb OWNER couponuser;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO couponuser;

CREATE USER productuser WITH PASSWORD '123456';
CREATE DATABASE productdb OWNER productuser;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO productuser;
