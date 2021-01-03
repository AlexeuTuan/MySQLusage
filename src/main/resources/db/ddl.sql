CREATE USER 'root'@'localhost' IDENTIFIED BY '143179179AAa';

CREATE SCHEMA MUSICDB;
GRANT ALL PRIVILEGES ON MUSICDB . * TO 'root'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+3:00';