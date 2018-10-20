DROP SCHEMA IF EXISTS `creall_CRM`;

CREATE SCHEMA `creall_CRM`;

use `creall_CRM`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `customer_detail`;

CREATE TABLE `customer_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_of_birth` date DEFAULT NULL,
  `phone_number`varchar(20) DEFAULT NULL,
  `city`varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;




DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `customer_detail_id` int(11) DEFAULT NULL,
  `account_manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  
  KEY `FK_DETAIL_idx` (`customer_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`customer_detail_id`) 
  REFERENCES `customer_detail` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  KEY `FK_ACCOUNTMAN_idx` (`account_manager_id`),
  CONSTRAINT `FK_ACCOUNTMAN` FOREIGN KEY (`account_manager_id`) 
  REFERENCES `account_manager` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;




DROP TABLE IF EXISTS `account_manager`;

CREATE TABLE `account_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;




DROP TABLE IF EXISTS `loyalty_program`;

CREATE TABLE `loyalty_program` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TITLE_UNIQUE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;




DROP TABLE IF EXISTS `customer_loyalty_program`;

CREATE TABLE `customer_loyalty_program` (
  `customer_id` int(11) NOT NULL,
  `loyalty_program_id` int(11) NOT NULL,
  
  PRIMARY KEY (`customer_id`,`loyalty_program_id`),
  
  KEY `FK_CUSTOMER_idx` (`customer_id`),
  CONSTRAINT `FK_CUSTOMER` FOREIGN KEY (`customer_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  KEY `FK_LOYALTY_idx` (`loyalty_program_id`),
  CONSTRAINT `FK_LOYALTY` FOREIGN KEY (`loyalty_program_id`) 
  REFERENCES `loyalty_program` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

SET FOREIGN_KEY_CHECKS = 1;




INSERT INTO account_manager(`first_name`, `last_name`) VALUES
  ('Jan', 'Weso³y'),
  ('Adam', 'Smutny'),
  ('Olaf', 'Ponury'),
  ('Renata', 'Pogodna');




INSERT INTO customer_detail(`date_of_birth`, `phone_number`, `city`) VALUES
  ('2000-11-24', '123123123', 'Bia³ystok'),
  ('2003-05-30', '159323123', 'Warszawa'),
  ('1987-02-10', '123123123', 'Gdañsk'),
  ('1983-07-12', '124562323', 'Kraków'),
  ('1990-11-09', '123147923', 'Poznañ'),
  ('1991-01-14', '123123123', 'Olsztyn'),
  ('2004-04-28', '116823123', 'Bydgoszczk'),
  ('1975-06-08', '116823123', 'Zielona Góra');



INSERT INTO `customer`
VALUES(null, 'Aleksandra', 'Podlaska', 'a.podlaska@o2.pl', 1, null);
INSERT INTO `customer`
VALUES(null, 'Zenon', 'Mazowiecki', 'z.mazowiecki@gmail.com', 2, 1);
INSERT INTO `customer`
VALUES(null, 'Paulina', 'Pomorska', 'p.pomorska@poczta.pl', 3, 2);
INSERT INTO `customer`
VALUES(null, 'Aleksandra', 'Ma³opolska', 'a.ma³opolska@gmail.pl', 4, 4);
INSERT INTO `customer`
VALUES(null, 'Robert', 'Wielkopolski', 'r.wielkopolski@o3.pl', 5,  4);
INSERT INTO `customer`
VALUES(null, 'Szymon', 'Mazurski', 'sz.mazurski@woda.pl', 6, 2);
INSERT INTO `customer`
VALUES(null, 'Katarzyna', 'Kujawska', 'katarzyna@ka-kujawska.edu', 7, 4);
INSERT INTO `customer`
VALUES(null, 'Bogdan', 'Lubuski', null, 8, 4);



INSERT INTO `loyalty_program` VALUES
  (null, 'Zbieraj punkty'),
  (null, 'Karta skarbonka'),
  (null, 'Z³oty partner');


INSERT INTO `customer_loyalty_program` (`customer_id`,`loyalty_program_id`) VALUES
  (5,1),
  (2,1),
  (8,1),
  (2,2),
  (1,2),
  (6,2),
  (8,2),
  (5,3),
  (2,3),
  (1,3),
  (4,3),
  (7,3),
  (6,3);
