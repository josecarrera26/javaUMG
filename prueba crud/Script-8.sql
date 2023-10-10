create database pruebaConexion

create schema erp

create table registropaciente(
    idpaciente serial primary key,
	nombrepaciente varchar not null,
	direccion varchar, 
	telefono integer,
	enfermedad varchar,
	estado varchar,
	fechaalta date

)


select *from  registropaciente

insert into registropaciente ("nombrepaciente","direccion" ,"telefono" ,"enfermedad","estado", "fechaalta" ) values('lucas','san jose','454545', 'fiebre','mal','10/8/20223')