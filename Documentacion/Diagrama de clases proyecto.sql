CREATE TABLE "cliente" (
  "idCliente" integer PRIMARY KEY,
  "nombre_Cliente" varchar,
  "telefono_Cliente" varchar,
  "email_Cliente" varchar,
  "nit" varchar,
  "direccion_Cliente" varchar,
  "dpi" varchar
);

CREATE TABLE "proveedor" (
  "idProveedor" integer PRIMARY KEY,
  "nombre_Proveedor" varchar,
  "direccion" varchar,
  "telefono" varchar,
  "regimen_Proveedor" varchar,
  "email_Proveedor" varchar
);

CREATE TABLE "cuentaContable" (
  "idCuenta" integer PRIMARY KEY,
  "nombreCuenta" varchar,
  "idCliente" integer,
  "idProveedor" integer,
  "impuesto_inventario" double,
  "coste" double,
  "margenGanancia" integer,
  "idproducto" integer
);

CREATE TABLE "cargo_empleado" (
  "idCargo" integer PRIMARY KEY,
  "nombre_Cargo" varchar,
  "salario" double
);

CREATE TABLE "empleado" (
  "idEmpleado" integer PRIMARY KEY,
  "nombre_Empleado" varchar,
  "apellido_Empleado" varchar,
  "telefono_Empleado" varchar,
  "email_empleado" varchar,
  "password" varchar,
  "idrole" integer,
  "idCargo_empleado" integer
);

CREATE TABLE "role" (
  "idRole" integer PRIMARY KEY,
  "nombre_Role" varchar,
  "descripcion" varchar
);

CREATE TABLE "marca" (
  "idMarca" integer PRIMARY KEY,
  "descripcion" varchar,
  "estado" integer
);

CREATE TABLE "linea" (
  "idLinea" integer PRIMARY KEY,
  "descripcion" varchar,
  "estado" integer
);

CREATE TABLE "inventario" (
  "idProducto" integer PRIMARY KEY,
  "nombre" varchar,
  "cantidad" varchar,
  "tipo_comercializacion" varchar,
  "modelo" varchar,
  "unidades" VARCHAR,
  "precio" double,
  "idMarca" integer,
  "idLinea" integer,
  "grupo_producto" varchar,
  "idProveedor" integer
);

CREATE TABLE "facturaCab" (
  "idFactura" integer,
  "fecha_registro" date,
  "plazos_pago" integer,
  "referencia_Factura" varchar,
  "idEmpleado" integer,
  "idTipoCliente" integer,
  "estadoFac" integer,
  "total" double,
  "idTipoPago" integer,
  "nit" varchar,
  "idTipoFactura" integer,
  PRIMARY KEY ("idFactura", "referencia_Factura")
);

CREATE TABLE "facturaDet" (
  "idFactura" integer,
  "cantidad" integer,
  "precio_Unitario" double,
  "iva" double,
  "idProducto" integer
);

CREATE TABLE "pedido" (
  "idPedido" integer PRIMARY KEY,
  "fecha_pedido" date,
  "nit" varchar,
  "idEmpleado" integer,
  "idProducto" integer,
  "idCliente" integer,
  "estado" varachar
);

CREATE TABLE "banco" (
  "idBanco" integer PRIMARY KEY,
  "nombreBanco" varchar,
  "idProveedor" integer
);

CREATE TABLE "kardex" (
  "id" integer PRIMARY KEY,
  "venta_compra" integer,
  "fecha" date,
  "idProducto" integer,
  "unidades_originales" integer,
  "unidades_vendidas" integer,
  "int_out" varchar
);

ALTER TABLE "cuentaContable" ADD FOREIGN KEY ("idCliente") REFERENCES "cliente" ("idCliente");

ALTER TABLE "cuentaContable" ADD FOREIGN KEY ("idProveedor") REFERENCES "proveedor" ("idProveedor");

ALTER TABLE "cargo_empleado" ADD FOREIGN KEY ("idCargo") REFERENCES "empleado" ("idCargo_empleado");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idProveedor") REFERENCES "proveedor" ("idProveedor");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idMarca") REFERENCES "marca" ("idMarca");

ALTER TABLE "inventario" ADD FOREIGN KEY ("idLinea") REFERENCES "linea" ("idLinea");

ALTER TABLE "facturaCab" ADD FOREIGN KEY ("idEmpleado") REFERENCES "empleado" ("idEmpleado");

ALTER TABLE "facturaDet" ADD FOREIGN KEY ("idFactura") REFERENCES "facturaCab" ("idFactura");

ALTER TABLE "facturaDet" ADD FOREIGN KEY ("idProducto") REFERENCES "inventario" ("idProducto");

ALTER TABLE "pedido" ADD FOREIGN KEY ("idEmpleado") REFERENCES "empleado" ("idEmpleado");

ALTER TABLE "pedido" ADD FOREIGN KEY ("idProducto") REFERENCES "inventario" ("idProducto");

ALTER TABLE "pedido" ADD FOREIGN KEY ("idCliente") REFERENCES "cliente" ("idCliente");

ALTER TABLE "proveedor" ADD FOREIGN KEY ("idProveedor") REFERENCES "banco" ("idProveedor");

ALTER TABLE "empleado" ADD FOREIGN KEY ("idrole") REFERENCES "role" ("idRole");

ALTER TABLE "kardex" ADD FOREIGN KEY ("idProducto") REFERENCES "inventario" ("idProducto");

ALTER TABLE "cuentaContable" ADD FOREIGN KEY ("idproducto") REFERENCES "inventario" ("idProducto");
