create database prograproyecto;

create schema ERP;

create table erp.usuarios (
	ID serial primary key,
	username varchar(50) unique not null,
	password varchar(50) not null,
	email varchar(50) not null,
	roll integer not null
);