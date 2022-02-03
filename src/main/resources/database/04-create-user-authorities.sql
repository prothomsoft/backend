--liquibase formatted sql
--changeset tprokop:4
create table user(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username varchar (50) not null UNIQUE,
                      password varchar (100) not null,
                      enabled boolean not null
);

--changeset tprokop:5
insert into user (id, username, password, enabled)
values (1, 'admin', '$2a$10$TeGt7zKYb9y6sX9/ZNahKeiLaG7DiXwbsLVOrdmAlFuNdAbYbU6wy', true);
insert into user (id, username, password, enabled)
values (2, 'user', '$2a$10$TeGt7zKYb9y6sX9/ZNahKeiLaG7DiXwbsLVOrdmAlFuNdAbYbU6wy', true);

--changeset tprokop:6
create table user_roles(
                     user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     roles varchar (255)  not null
);

alter table user_roles
    add constraint user_roles_id
        foreign key (user_id) references user(id);

--changeset tprokop:7
insert into user_roles (user_id, roles)
values (1, 'ROLE_ADMIN');
insert into user_roles (user_id, roles)
values (2, 'ROLE_USER');