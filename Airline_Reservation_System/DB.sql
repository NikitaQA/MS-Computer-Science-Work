DROP SCHEMA IF EXISTS `airdb`;
CREATE SCHEMA  airdb;
use airdb;


CREATE TABLE airdb.location (
	ID INT(3) NOT NULL AUTO_INCREMENT,
	CODE VARCHAR(5) NOT NULL,
	NAME VARCHAR(64) NOT NULL,
	CITY VARCHAR(64) NOT NULL,
	COUNTRY VARCHAR(10) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE airdb.flights
	(ID INT(3) NOT NULL AUTO_INCREMENT,
	AIRLINE	VARCHAR(25) NOT NULL,
	START_AIRPORT VARCHAR(25) NOT NULL,
	START_TIME VARCHAR(25) NOT NULL,
	END_AIRPORT VARCHAR(25) NOT NULL,
	END_TIME VARCHAR(25) NOT NULL,
	STOPS SMALLINT NOT NULL,
	RETURN_START_AIRPORT VARCHAR(25) NOT NULL,
	RETURN_START_TIME VARCHAR(25) NOT NULL,
	RETURN_END_AIRPORT VARCHAR(25) NOT NULL,
	RETURN_END_TIME VARCHAR(25) NOT NULL,
	RETURN_STOPS SMALLINT NOT NULL,	
	PRICE INT(10) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE airdb.deals
	(ID INT(3) NOT NULL,
	LOCATION_CODE VARCHAR(5),
	PRICE INTEGER NOT NULL,
	DISCOUNT INTEGER NOT NULL,
	EVENT VARCHAR(256) NOT NULL,
	DATES VARCHAR(256) NOT NULL,
	PLACE VARCHAR(256) NOT NULL,	
	constraint fk_id foreign key(id) references location(id));

	
SELECT * FROM airdb.deals;

insert into airdb.location values (2,'JFK','John F Kennedy Intl','New York', 'USA');

insert into airdb.location values (3,'LHR','London Heathrow','London', 'UK');


SELECT * FROM airdb.location;

insert into airdb.deals values (2,'LHR', 299, 25, "Athletics", "August 3 to August 12", "London");

insert into airdb.flights values(2,'DELTA', 'JFK', '9.35AM', 'LHR', '1.35PM', 1, 'LHR', '9.35AM', 'JFK', '1.35PM', 0,1200);
select * from airdb.flights;
SELECT * FROM airdb.flights WHERE id=2;

insert into airdb.deals values (3,'SFO', 249, 26, "Athletic", "August 4 to August 12", "Londons");
select * from airdb.flights where start_airport='JFK' and end_airport='LHR';
insert into airdb.flights values(3,'DELTA','JFK','9.00AM','LHR','1.00PM',2,'LHR','9.00AM','JFK','1.00PM',1,1100);
insert into airdb.flights values(4,'DELTA','JFK','8.00AM','LHR','12.00PM',1,'LHR','8.00AM','JFK','12.00PM',1,1000);
delete from airdb.deals where id=4;
insert into airdb.flights  values (5,'DELTA', 'SFO', '9.35AM', 'LHR', '1.35PM', 1, 'LHR', '9.35AM', 'SFO', '1.35PM', 0,1110);
insert into airdb.flights  values (6,'US AIR','SFO', '11.35AM', 'LHR','3.35PM', 1, 'LHR', '11.35AM', 'SFO', '1.35PM', 0,1220);






