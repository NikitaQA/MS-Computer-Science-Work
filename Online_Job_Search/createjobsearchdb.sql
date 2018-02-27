CREATE SCHEMA `jobsearch` ;

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employer` (
  `id` int(11) NOT NULL,
  `companyName` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `ph_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `jobseeker_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `skill` varchar(45) DEFAULT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `ph_no` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;



vacancy	CREATE TABLE `vacancy` (
  `id` int(11) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `skill_required` varchar(45) DEFAULT NULL,
  `no_of_seats` varchar(45) DEFAULT NULL,
  `jobCategory` varchar(45) DEFAULT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_id_idx` (`emp_id`),
  CONSTRAINT `emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



