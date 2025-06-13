CREATE TABLE permission (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission (
	id_user BIGINT(20) NOT NULL,
	id_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (id_user, id_permission),
	FOREIGN KEY (id_user) REFERENCES user(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (id, name, mail, password, cpf, birth_date, phone, active) 
	values (3, 'Administrador', 'admin@ifsp.edu.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', '502.336.328-77', '1975-11-16', '12991701609', 1);
	
INSERT INTO permission (id, description) values (1, 'ROLE_REGISTER_USER');
INSERT INTO permission (id, description) values (2, 'ROLE_REMOVE_USER');
INSERT INTO permission (id, description) values (3, 'ROLE_SEARCH_USER');

INSERT INTO permission (id, description) values (4, 'ROLE_REGISTER_VEHICLE');
INSERT INTO permission (id, description) values (5, 'ROLE_REMOVE_VEHICLE');
INSERT INTO permission (id, description) values (6, 'ROLE_SEARCH_VEHICLE');

INSERT INTO permission (id, description) values (7, 'ROLE_REGISTER_PARKING_SESSION');
INSERT INTO permission (id, description) values (8, 'ROLE_REMOVE_PARKING_SESSION');
INSERT INTO permission (id, description) values (9, 'ROLE_SEARCH_PARKING_SESSION');

INSERT INTO permission (id, description) values (10, 'ROLE_REGISTER_INSPECTOR');
INSERT INTO permission (id, description) values (11, 'ROLE_REMOVE_INSPECTOR');
INSERT INTO permission (id, description) values (12, 'ROLE_SEARCH_INSPECTOR');

INSERT INTO permission (id, description) values (13, 'ROLE_REGISTER_STREET');
INSERT INTO permission (id, description) values (14, 'ROLE_REMOVE_STREET');
INSERT INTO permission (id, description) values (15, 'ROLE_SEARCH_STREET');


INSERT INTO user_permission (id_user, id_permission) values (3, 10);
INSERT INTO user_permission (id_user, id_permission) values (3, 11);
INSERT INTO user_permission (id_user, id_permission) values (3, 12);
INSERT INTO user_permission (id_user, id_permission) values (3, 13);
INSERT INTO user_permission (id_user, id_permission) values (3, 14);
INSERT INTO user_permission (id_user, id_permission) values (3, 15);


INSERT INTO user_permission (id_user, id_permission) values (1, 1);
INSERT INTO user_permission (id_user, id_permission) values (1, 2);
INSERT INTO user_permission (id_user, id_permission) values (1, 3);
INSERT INTO user_permission (id_user, id_permission) values (1, 4);
INSERT INTO user_permission (id_user, id_permission) values (1, 5);
INSERT INTO user_permission (id_user, id_permission) values (1, 6);
INSERT INTO user_permission (id_user, id_permission) values (1, 7);
INSERT INTO user_permission (id_user, id_permission) values (1, 8);
INSERT INTO user_permission (id_user, id_permission) values (1, 9);

	