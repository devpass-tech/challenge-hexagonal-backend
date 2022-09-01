ALTER TABLE `transaction`
	DROP COLUMN `amount`,
    DROP COLUMN `merchant`,
    DROP COLUMN time,
    DROP FOREIGN KEY `client_id_fk`,
    DROP COLUMN `client_id`,
    ADD `value` decimal(19,2),
    ADD `establishment` varchar(255) DEFAULT NULL,
    ADD `transaction_date` TIMESTAMP,
    ADD `time` datetime DEFAULT NULL,
    ADD `account_id` bigint(20),
	ADD FOREIGN KEY (`account_id`) REFERENCES `account`(`id`);