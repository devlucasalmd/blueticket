CREATE TABLE `parking_session` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) NOT NULL,
    `vehicle_id` bigint(20) NOT NULL,
    `street_id` bigint(20) NOT NULL,
    `duration` int(5) NOT NULL,
    `hora_inicio` DATETIME,
    `hora_fim` DATETIME,
    `status` varchar(20) NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`user_id`) REFERENCES user(id),
    FOREIGN KEY(`vehicle_id`) REFERENCES vehicle(id),
    FOREIGN KEY(`street_id`) REFERENCES street(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
