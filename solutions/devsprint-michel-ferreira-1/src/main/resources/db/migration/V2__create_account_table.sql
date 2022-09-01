CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_number` bigint(20) NOT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
);