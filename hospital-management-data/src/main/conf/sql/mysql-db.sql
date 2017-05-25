CREATE TABLE IF NOT EXISTS doctor (
	personId int(20) NOT NULL AUTO_INCREMENT,
 	firstname varchar(32) NOT NULL,
 	lastname varchar(32) NOT NULL,
 	dateOfBirth timestamp NOT NULL,
 	email varchar(32) DEFAULT NULL,
 	mobileNumber varchar(10) DEFAULT NULL,
 	pagerNumber varchar(256) DEFAULT NULL,
 	PRIMARY KEY (personId)
);

CREATE TABLE IF NOT EXISTS patient (
	personId int(20) NOT NULL AUTO_INCREMENT,
 	firstname varchar(32) NOT NULL,
 	lastname varchar(32) NOT NULL,
 	dateOfBirth timestamp NOT NULL,
 	email varchar(32) DEFAULT NULL,
 	mobileNumber varchar(10) DEFAULT NULL,
 	insuranceType varchar(32) NOT NULL,
 	PRIMARY KEY (personId)
);
