CREATE TABLE `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `zip_code`  varchar(255) DEFAULT NULL,
  `street`  varchar(255) DEFAULT NULL,
  `state`  varchar(255) DEFAULT NULL,
  `city`  varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);