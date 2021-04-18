--liquibase formatted sql
--changeset tprokop:4
create table user(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username varchar ( 50 ) not null UNIQUE,
                      password varchar ( 100 ) not null,
                      roles varchar  (100)  not null,
                      enabled boolean not null
);

--changeset tprokop:5
insert into user (id, username, password, roles, enabled)
values (1, 'test', '$2a$10$upzXFsFUOClFRR69OMKF8eajGMRs0vhcSHqvNDKy9yfW45w7o9z6O', "USER", true);