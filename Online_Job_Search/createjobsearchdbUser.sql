CREATE USER 'job1'@'localhost' IDENTIFIED BY '1234';



GRANT ALL PRIVILEGES ON jobsearch.* TO 'job1'@'localhost' WITH GRANT OPTION;



SHOW GRANTS FOR 'job1'@'localhost';