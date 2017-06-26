CREATE TABLE `doctors` (
  `doctor_id` int(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(32) NOT NULL,
  `last_name` varchar(32) NOT NULL,
  `date_of_birth` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `email` varchar(32) NOT NULL,
  `mobile_number` varchar(10) DEFAULT NULL,
  `pager_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
ALTER TABLE `doctor` ADD UNIQUE KEY `UC_Doctor` (`last_name`,`first_name`,`email`) USING BTREE;

CREATE TABLE `patients` (
  `patient_id` int(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(32) NOT NULL,
  `last_name` varchar(32) NOT NULL,
  `date_of_birth` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `email` varchar(32) NOT NULL,
  `mobile_number` varchar(10) DEFAULT NULL,
  `insurance_type` varchar(32) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
ALTER TABLE `patient` ADD UNIQUE KEY `UC_Doctor` (`last_name`,`first_name`,`email`) USING BTREE;

CREATE TABLE `users` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;
ALTER TABLE `user` ADD UNIQUE KEY `UC_Doctor` (`user_name`) USING BTREE;

CREATE TABLE `doctors_patients` (
  `doctor_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  PRIMARY KEY (`patient_id`,`patient_id`),
  KEY `fk_doctor` (`doctor_id`),
  KEY `fk_patient` (`patient_id`),
  CONSTRAINT `fk_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`doctor_id`),
  CONSTRAINT `fk_patient` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`)
);
