CREATE TABLE "cliente" (
  "idcliente" Serial PRIMARY KEY,
  "nombre_cliente" varchar,
  "telefono_cliente" varchar,
  "email_cliente" varchar,
  "nit" varchar,
  "direccion_cliente" varchar,
  "dpi" varchar,
  "idcuentacontable" integer
);

CREATE TABLE "proveedor" (
  "idproveedor" Serial PRIMARY KEY,
  "nombre_proveedor" varchar,
  "direccion" varchar,
  "telefono" varchar,
  "regimen_proveedor" varchar,
  "email_proveedor" varchar,
  "idcuentacontable" integer
);

CREATE TABLE "cuentacontable" (
  "idcuentacontable" Serial PRIMARY KEY,
  "nombrecuenta" varchar,
  "tipocuenta" varchar
);

CREATE TABLE "usuario" (
  "idusuario" Serial PRIMARY KEY,
  "username" varchar,
  "password" varchar,
  "idrole" integer,
  "idempleado" integer
);

CREATE TABLE "cargoempleado" (
  "idcargo" Serial PRIMARY KEY,
  "nombre_cargo" varchar,
  "salario" double precision
);

CREATE TABLE "empleado" (
  "idempleado" Serial PRIMARY KEY,
  "nombre_empleado" varchar,
  "apellido_empleado" varchar,
  "telefono_empleado" varchar,
  "email_empleado" varchar,
  "idcargo_empleado" integer
);

CREATE TABLE "roles" (
  "idrole" Serial PRIMARY KEY,
  "nombre_role" varchar,
  "descripcion" varchar,
  "accesos" varchar
);

CREATE TABLE "marca" (
  "idmarca" Serial PRIMARY KEY,
  "descripcion" varchar,
  "estado" integer
);

CREATE TABLE "linea" (
  "idlinea" Serial PRIMARY KEY,
  "descripcion" varchar,
  "estado" integer
);

CREATE TABLE "grupoproducto" (
  "idgrupoproducto" Serial PRIMARY KEY,
  "descripcion" varchar,
  "estado" integer
);

CREATE TABLE "inventario" (
  "idproducto" Serial PRIMARY KEY,
  "nombre" varchar,
  "cantidad" integer,
  "tipo_comercializacion" varchar,
  "modelo" varchar,
  "unidades" VARCHAR,
  "precioventa" double precision,
  "coste" double precision,
  "margenganancia" integer,
  "idmarca" integer,
  "idlinea" integer,
  "idgrupoproducto" integer,
  "idproveedor" integer,
  "estado" integer,
  "impuestoinventario" double precision,
  "idcuentacontable" integer
);

CREATE TABLE "facturacab" (
  "idfactura" Serial PRIMARY KEY,
  "fecha_registro" date,
  "plazos_pago" integer,
  "idempleado" integer,
  "idtipocliente" integer,
  "estadofac" integer,
  "total" double precision,
  "idtipopago" integer,
  "nit" varchar,
  "idtipofactura" integer
);

CREATE TABLE "facturadet" (
  "idtransaccion" Serial PRIMARY key,
  "idfactura" integer,
  "cantidad" integer,
  "preciounitario" double precision,
  "iva" double precision,
  "idproducto" integer
);

CREATE TABLE "pedido" (
  "idpedido" Serial PRIMARY KEY,
  "fecha_pedido" date,
  "nit" varchar,
  "idempleado" integer,
  "idproducto" integer,
  "idcliente" integer,
  "estado" varchar
);


CREATE TABLE "kardex" (
  "id" Serial PRIMARY KEY,
  "venta_compra" integer,
  "fecha" date,
  "idproducto" integer,
  "unidades_originales" integer,
  "unidades_vendidas" integer,
  "int_out" varchar
);






ALTER TABLE  "usuario" ADD FOREIGN KEY ("idempleado") REFERENCES "empleado" ("idempleado");

ALTER TABLE  "usuario" ADD FOREIGN KEY ("idrole") REFERENCES "roles" ("idrole");

ALTER TABLE  "empleado" ADD FOREIGN KEY ("idcargo_empleado") REFERENCES "cargoempleado" ("idcargo");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idproveedor") REFERENCES "proveedor" ("idproveedor");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idmarca") REFERENCES "marca" ("idmarca");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idlinea") REFERENCES "linea" ("idlinea");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idgrupoproducto") REFERENCES "grupoproducto" ("idgrupoproducto");

ALTER TABLE "facturacab" ADD FOREIGN KEY ("idempleado") REFERENCES "empleado" ("idempleado");

ALTER TABLE  "facturadet" ADD FOREIGN KEY ("idfactura") REFERENCES "facturacab" ("idfactura");

ALTER TABLE "facturadet" ADD FOREIGN KEY ("idproducto") REFERENCES "inventario" ("idproducto");

ALTER TABLE "pedido" ADD FOREIGN KEY ("idempleado") REFERENCES "empleado" ("idempleado");

ALTER TABLE "pedido" ADD FOREIGN KEY ("idproducto") REFERENCES "inventario" ("idproducto");

ALTER TABLE "pedido" ADD FOREIGN KEY ("idcliente") REFERENCES "cliente" ("idcliente");

ALTER TABLE "kardex" ADD FOREIGN KEY ("idproducto") REFERENCES "inventario" ("idproducto");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idcuentacontable") REFERENCES "cuentacontable" ("idcuentacontable");

ALTER TABLE "cliente" ADD FOREIGN KEY ("idcuentacontable") REFERENCES "cuentacontable" ("idcuentacontable");

ALTER TABLE "proveedor" ADD FOREIGN KEY ("idcuentacontable") REFERENCES "cuentacontable" ("idcuentacontable");


--drop table cargo_empleado  cascade;
--drop table cliente cascade;
--drop table cuentacontable  cascade;
--drop table empleado  cascade;
--drop table facturacab  cascade;
--drop table facturadet  cascade;
--drop table grupoproducto  cascade;
--drop table inventario  cascade;
--drop table kardex  cascade;
--drop table linea  cascade;
--drop table marca  cascade;
--drop table pedido cascade;
--drop table proveedor  cascade;
--drop table roles  cascade;