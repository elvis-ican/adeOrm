--drop table users;
--create database if not exists;
--create schema if not exists public;
--GO

-- DDL
create table users(
	first_name varchar (30),
	last_name varchar (30),
	gender varchar (1),
	check (gender = 'M' or gender = 'F'),
	username varchar(30) primary key not null,
	user_password varchar(30) not null
);

create table post(
	post_id serial primary key,
	username varchar(30) references users,
	title varchar(30) not null,
	country varchar(30),
	city varchar(30),
	tag varchar(30),
	rating integer constraint rating_less_than_five check (rating <= 5),
	constraint rating_greater_than_zero check (rating >= 0)
);

create table test_table(
    prim_key varchar(5) primary key
);

-- DML
insert into users values ('Leah', 'Canavan', 'F', 'alpha','password123');
insert into users values ('Richelle', 'Hunt','F','beta','password123');
insert into users values ('Jorge','Olivero','M','charlie','password123');

insert into post values
(default, 'alpha', 'Shrimp Linguini Alfredo','United States','New Orleans',null,0);
insert into post values (default, 'beta', 'Cuban Sandwich', 'United States','Miami','food',5);
insert into post values (default, 'charlie', 'Inception', 'United States','Chicago','movie',3);
insert into post values (default, 'alpha', 'Vanilla Ice Cream', 'United States','Chicago',null,3);


