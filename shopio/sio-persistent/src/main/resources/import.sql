insert into authority(id, name) values (1, 'ROLE_ADMIN');
insert into authority(id, name) values (2, 'ROLE_USER');

insert into users(id, email, "password", description, timestamp_created, timestamp_modified) values (1, 'admin@gmail.com', '$2a$10$uMTsAJuIUnQlCJEQZs9PE.P5tlqLYihTEcVJtW5sEPHPxGsTIPdri', 'Solution Architure', current_timestamp, current_timestamp);
insert into users(id, email, "password", description, timestamp_created, timestamp_modified) values (2, 'test_01@gmail.com', '$2a$10$uMTsAJuIUnQlCJEQZs9PE.P5tlqLYihTEcVJtW5sEPHPxGsTIPdri', 'Senior', current_timestamp, current_timestamp);

insert into authority_role(user_id, authority_id) values (1, 1);
insert into authority_role(user_id, authority_id) values (2, 2);