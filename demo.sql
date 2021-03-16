drop database expensetrackerdb;
drop user expensetracker;
create user expensetracker with password 'password';



create database vente;
create role zotoavina login password '123456';
alter database vente owner to zotoavina
psql -U zotoavina vente;
mdp=123456

create table users(
	idUser  serial primary key,
	firstName varchar(20) not null,
	lastName varchar(20) not null,
	email varchar(30) not null,
	password text not null
);

create table categories(
	idCategorie integer primary key not null,
	idUser integer not null,
	title varchar(20) not null,
	description varchar(50) not null
);

create table tokens(
	token varchar(50) not null,
    expiration timestamp not null,
);


alter table categories add foreign key(idUser) references users(idUser);

create sequence seqUser increment 1 start 1;
