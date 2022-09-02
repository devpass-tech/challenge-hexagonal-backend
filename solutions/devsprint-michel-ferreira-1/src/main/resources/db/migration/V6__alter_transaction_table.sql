ALTER TABLE `transaction`
    ADD `location_id` bigint(20),
	ADD FOREIGN KEY (`location_id`) REFERENCES `location`(`id`);