CREATE TABLE `vehicle` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) NOT NULL,
    `placa` varchar(20) NOT NULL,
    `modelo` varchar(50) NOT NULL,
    `categoria` varchar(50) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`user_id`) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
