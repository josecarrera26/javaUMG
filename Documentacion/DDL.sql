CREATE TABLE "cliente" (
  "idCliente" Serial PRIMARY KEY,
  "nombre_Cliente" varchar,
  "telefono_Cliente" varchar,
  "email_Cliente" varchar,
  "nit" varchar,
  "direccion_Cliente" varchar,
  "dpi" varchar
);

CREATE TABLE "proveedor" (
  "idProveedor" Serial PRIMARY KEY,
  "nombre_Proveedor" varchar,
  "direccion" varchar,
  "telefono" varchar,
  "regimen_Proveedor" varchar,
  "email_Proveedor" varchar
);

CREATE TABLE "cuentaContable" (
  "idCuenta" Serial PRIMARY KEY,
  "nombreCuenta" varchar,
  "idCliente" integer,
  "idProveedor" integer,
  "impuesto_inventario" float,
  "coste" float,
  "margenGanancia" integer,
  "idproducto" integer
);

CREATE TABLE "cargo_empleado" (
  "idCargo" Serial PRIMARY KEY,
  "nombre_Cargo" varchar,
  "salario" float
);

CREATE TABLE "empleado" (
  "idEmpleado" Serial PRIMARY KEY,
  "nombre_Empleado" varchar,
  "apellido_Empleado" varchar,
  "telefono_Empleado" varchar,
  "email_empleado" varchar,
  "password" varchar,
  "idrole" integer,
  "idCargo_empleado" integer
);

CREATE TABLE "role" (
  "idRole" Serial PRIMARY KEY,
  "nombre_Role" varchar,
  "descripcion" varchar
);

CREATE TABLE "marca" (
  "idMarca" Serial PRIMARY KEY,
  "descripcion" varchar,
  "estado" integer
);

CREATE TABLE "linea" (
  "idLinea" Serial PRIMARY KEY,
  "descripcion" varchar,
  "estado" integer
);

CREATE TABLE "inventario" (
  "idProducto" Serial PRIMARY KEY,
  "nombre" varchar,
  "cantidad" varchar,
  "tipo_comercializacion" varchar,
  "modelo" varchar,
  "unidades" VARCHAR,
  "precio" float,
  "idMarca" integer,
  "idLinea" integer,
  "grupo_producto" varchar,
  "idProveedor" integer
);

CREATE TABLE "facturaCab" (
  "idFactura" Serial,
  "fecha_registro" date,
  "plazos_pago" integer,
  "referencia_Factura" varchar,
  "idEmpleado" integer,
  "idTipoCliente" integer,
  "estadoFac" integer,
  "total" float,
  "idTipoPago" integer,
  "nit" varchar,
  "idTipoFactura" integer,
  PRIMARY KEY ("idFactura", "referencia_Factura")
);

CREATE TABLE "facturaDet" (
  "idFactura" serial PRIMARY KEY,
  "cantidad" integer,
  "precio_Unitario" float,
  "iva" float,
  "idProducto" integer
);

CREATE TABLE "pedido" (
  "idPedido" Serial PRIMARY KEY,
  "fecha_pedido" date,
  "nit" varchar,
  "idEmpleado" integer,
  "idProducto" integer,
  "idCliente" integer,
  "estado" varchar
);

CREATE TABLE "banco" (
  "idBanco" Serial PRIMARY KEY,
  "nombreBanco" varchar,
  "idProveedor" integer
);

CREATE TABLE "kardex" (
  "id" Serial PRIMARY KEY,
  "venta_compra" integer,
  "fecha" date,
  "idProducto" integer,
  "unidades_originales" integer,
  "unidades_vendidas" integer,
  "int_out" varchar
);

ALTER TABLE "cuentaContable" ADD FOREIGN KEY ("idCliente") REFERENCES "cliente" ("idCliente");

ALTER TABLE "cuentaContable" ADD FOREIGN KEY ("idProveedor") REFERENCES "proveedor" ("idProveedor");

ALTER TABLE "empleado" ADD FOREIGN KEY ("idCargo_empleado") REFERENCES  "cargo_empleado" ("idCargo");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idProveedor") REFERENCES "proveedor" ("idProveedor");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idMarca") REFERENCES "marca" ("idMarca");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idLinea") REFERENCES "linea" ("idLinea");

ALTER TABLE "facturaCab" ADD FOREIGN KEY ("idEmpleado") REFERENCES "empleado" ("idEmpleado");

ALTER TABLE "facturaCab" ADD FOREIGN KEY  ("idFactura") REFERENCES  "facturaDet" ("idFactura");

ALTER TABLE "facturaDet" ADD FOREIGN KEY ("idProducto") REFERENCES "inventario" ("idProducto");

ALTER TABLE "pedido" ADD FOREIGN KEY ("idEmpleado") REFERENCES "empleado" ("idEmpleado");

ALTER TABLE "pedido" ADD FOREIGN KEY ("idProducto") REFERENCES "inventario" ("idProducto");

ALTER TABLE "pedido" ADD FOREIGN KEY ("idCliente") REFERENCES "cliente" ("idCliente");

ALTER TABLE  "banco" ADD FOREIGN KEY  ("idProveedor") REFERENCES  "proveedor" ("idProveedor");

ALTER TABLE "empleado" ADD FOREIGN KEY ("idrole") REFERENCES "role" ("idRole");

ALTER TABLE "kardex" ADD FOREIGN KEY ("idProducto") REFERENCES "inventario" ("idProducto");

ALTER TABLE "cuentaContable" ADD FOREIGN KEY ("idproducto") REFERENCES "inventario" ("idProducto");