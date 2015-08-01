CREATE USER bookmanager@localhost identified BY '123123';
GRANT usage ON *.* TO bookmanager@localhost identified BY '123123';
create database if not exists bookmanager;
grant all privileges on bookmanager.* to bookmanager@localhost;
use bookmanager;
create table books
(
id int primary key auto_increment,
name varchar(200),
author varchar(200),
year int,
genre varchar(100),
about varchar(3000),
rating int,
count int
);


create table comments
(
id int primary key auto_increment,
idBook int,
author varchar(200),
text varchar(3000)
);