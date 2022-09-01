ALTER TABLE `client`
    DROP COLUMN `balance`,
    ADD COLUMN `birth_date` DATE DEFAULT NULL,
    ADD `account_id` bigint(20),
    ADD CONSTRAINT `account_id_fk` FOREIGN KEY (`account_id`) REFERENCES `account`(`id`);