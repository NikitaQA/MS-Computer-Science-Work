DROP DATABASE IF EXISTS scrabbledb;
CREATE DATABASE scrabbledb;
USE scrabbledb;

CREATE TABLE `scrabbledb`.`register` (
  `reg_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `fname` VARCHAR(45) NULL COMMENT '',
  `lname` VARCHAR(45) NULL COMMENT '',
  `uname` VARCHAR(45) NULL COMMENT '',
  `pwd` VARCHAR(45) NULL COMMENT '',
  `email_id` VARCHAR(45) NULL COMMENT '',
  `gender` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`reg_id`)  COMMENT '',
CONSTRAINT chk_gender CHECK (gender in ( 'male','female')));

CREATE TABLE `scrabbledb`.`login` (
  `login_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `uname` VARCHAR(45) NULL COMMENT '',
  `pwd` VARCHAR(45) NULL COMMENT '',
  `reg_id` INT NULL COMMENT '',
  PRIMARY KEY (`login_id`)  COMMENT '',
  INDEX `reg_id_idx` (`reg_id` ASC)  COMMENT '',
  CONSTRAINT `fk_reg_id`
    FOREIGN KEY (`reg_id`)
    REFERENCES `scrabbledb`.`register` (`reg_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `scrabbledb`.`logs` (
  `log_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `pname` VARCHAR(45) NULL COMMENT '',
  `st_dt_tm` DATETIME NULL COMMENT '',
  `en_dt_tm` DATETIME NULL COMMENT '',
  `word` VARCHAR(45) NULL COMMENT '',
  `result` VARCHAR(45) NULL COMMENT '',
  `login_id` INT NULL COMMENT '',
  PRIMARY KEY (`log_id`)  COMMENT '',
  INDEX `fk_login_id_idx` (`login_id` ASC)  COMMENT '',
  CONSTRAINT `fk_login_id`
    FOREIGN KEY (`login_id`)
    REFERENCES `scrabbledb`.`login` (`login_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


