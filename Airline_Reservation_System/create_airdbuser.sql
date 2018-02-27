CREATE USER 'airdbuser'@'localhost' IDENTIFIED BY 'test';

GRANT ALL PRIVILEGES ON airdb.* TO 'airdbuser'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'airdbuser'@'localhost';