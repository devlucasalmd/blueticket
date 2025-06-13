CREATE TABLE `street` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `street_name` varchar(100) NOT NULL UNIQUE,
    `cep` varchar(10) NOT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
