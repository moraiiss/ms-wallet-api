CREATE TABLE IF NOT EXISTS `consumers` (
     `id` int NOT NULL AUTO_INCREMENT,
     `consumer_document` varchar(255) NOT NULL,
     `email` varchar(255) NOT NULL,
     `name` varchar(255) NOT NULL,
     `password` varchar(255) NOT NULL,
     PRIMARY KEY (`id`),
     UNIQUE KEY `UK_4npa40olrc9xskob8t2po6987` (`consumer_document`),
     UNIQUE KEY `UK_ayhei5rt7ltp0aw86e5fl30tr` (`email`)
)