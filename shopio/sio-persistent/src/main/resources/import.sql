insert into authority(id, name) values (1, 'ROLE_ADMIN');
insert into authority(id, name) values (2, 'ROLE_USER');

insert into users(id, email, "password", description, timestamp_created, timestamp_modified) values (1, 'admin@gmail.com', '$2a$10$uMTsAJuIUnQlCJEQZs9PE.P5tlqLYihTEcVJtW5sEPHPxGsTIPdri', 'Suppervisor', current_timestamp, current_timestamp);
insert into users(id, email, "password", description, timestamp_created, timestamp_modified) values (2, 'test01@gmail.com', '$2a$10$uMTsAJuIUnQlCJEQZs9PE.P5tlqLYihTEcVJtW5sEPHPxGsTIPdri', 'User for test', current_timestamp, current_timestamp);

insert into authority_role(user_id, authority_id) values (1, 1);
insert into authority_role(user_id, authority_id) values (2, 2);

insert into category(id, "name", timestamp_created, timestamp_modified) values (1, 'Wodden Toy', current_timestamp, current_timestamp);
insert into category(id, "name", timestamp_created, timestamp_modified) values (2, 'Plastic Toy', current_timestamp, current_timestamp);