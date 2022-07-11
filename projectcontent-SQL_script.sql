drop database project_content_2;

create database project_content_2;
use project_content_2;

create table project (
project_id int auto_increment not null primary key ,
project_name varchar(255) not null,
project_description varchar(255),
project_date_of_create date
);

insert into project(project_name, project_description, project_date_of_create) values ('Lviv', 'Project in Lviv', '2020-12-15');
insert into project(project_name, project_description, project_date_of_create) values ('Kiev', 'Project in Kiev', '2020-11-10');
insert into project(project_name, project_description, project_date_of_create) values ('Odessa', 'Project in Odessa', '2019-08-11');
insert into project(project_name, project_description, project_date_of_create) values ('Dnepr', 'Project in Dnepr', '2020-06-05');
insert into project(project_name, project_description, project_date_of_create) values ('Chernigiv', 'Project in Chernigiv', '2018-12-15');
insert into project(project_name, project_description, project_date_of_create) values ('Vinnitsa', 'Project in Vinnitsa', '2020-10-15');

create table components (
component_id int auto_increment not null primary key ,
component_name varchar(255),
component_quantity int not null,
component_description varchar(255),
component_date_of_create date,
project_id int,
foreign key(project_id) references project(project_id)
);

insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Linear Conveyour', 2,'c1',1,'2020-10-15');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Roller Conveyour', 3,'c2',1,'2020-9-15');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Vertical Conveyour', 10,'c3',1,'2020-11-15');

insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Linear Conveyour', 2,'c1',2,'2020-12-12');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Roller Conveyour', 3,'c2',2,'2020-12-13');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Vertical Conveyour', 10,'c3',2,'2020-12-11');

insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Linear Conveyour', 2,'c1',3,'2020-06-11');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Roller Conveyour', 3,'c2',3,'2020-06-14');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Vertical Conveyour', 10,'c3',3,'2020-06-12');

insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Linear Conveyour', 2,'c1',4,'2018-12-16');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Roller Conveyour', 3,'c2',4,'2018-12-17');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Vertical Conveyour', 10,'c3',4,'2018-12-15');

insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Linear Conveyour', 2,'c1',5,'2020-10-15');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Roller Conveyour', 3,'c2',5,'2020-10-16');
insert into components(component_name,component_quantity, component_description, project_id, component_date_of_create) values ('Vertical Conveyour', 10,'c3',5,'2020-10-17');

create table user (
user_id int auto_increment not null primary key ,
user_name varchar(255),
user_password varchar(255),
user_enabled tinyint default null
);

create table role(
role_id int auto_increment not null primary key,
role_name varchar(255)
);

create table user_role(
user_id int,
role_id int,
foreign key(user_id) references user(user_id),
foreign key(role_id) references role(role_id)
);

insert into user(user_name, user_password, user_enabled) value ('admin', '$2a$12$4ZLf1JY92M8a7Ux8LZAL6.sYXZxyq/eqfcU.r.EPzqmtsx6PpKUhW', '1');
insert into user(user_name, user_password, user_enabled) value ('user', '$2a$12$LajnAaMzaE9JBkgC8Gkx/ebrJ1A8NI4pIhaw02Tsq9OrJeL/2qp4u', '1');

insert into role(role_name) value('ADMIN');
insert into role(role_name) value('USER');

insert into user_role(user_id, role_id) value (1,1);
insert into user_role(user_id, role_id) value (1,2);
insert into user_role(user_id, role_id) value (2,2);





