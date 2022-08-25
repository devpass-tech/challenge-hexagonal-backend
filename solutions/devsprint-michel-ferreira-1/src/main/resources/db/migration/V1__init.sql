CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `balance` decimal(19,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) DEFAULT NULL,
  `merchant` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id_fk` (`client_id`),
  CONSTRAINT `client_id_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
);

insert into client (`name`, `balance`) values ('Rachel Sanchez', 500.12);
insert into client (`name`, `balance`) values ('Donald Duncan', 5155.91);
insert into client (`name`, `balance`) values ('Kerry Woodcock', 2500.00);
