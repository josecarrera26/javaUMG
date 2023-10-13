--modulo usuario
--cargos
INSERT INTO public.cargo_empleado
(nombre_cargo, salario)
VALUES('Administrador', 10101010.00);
INSERT INTO public.cargo_empleado
(nombre_cargo, salario)
VALUES('Analista de Recursos Humanos', 20202020.00);
INSERT INTO public.cargo_empleado
(nombre_cargo, salario)
VALUES('Vendedor', 30303030.00);
INSERT INTO public.cargo_empleado
(nombre_cargo, salario)
VALUES('Recolector', 40404040.00);
INSERT INTO public.cargo_empleado
(nombre_cargo, salario)
VALUES('Cajero', 50505050.00);
--roles
INSERT INTO public.roles
(nombre_role, descripcion)
VALUES('admin', 'desarrollo');
INSERT INTO public.roles
(nombre_role, descripcion)
VALUES('rrhh', 'Acceso a recursos humanos');
INSERT INTO public.roles
(nombre_role, descripcion)
VALUES('ventas', 'Accesos a ventas');
INSERT INTO public.roles
(nombre_role, descripcion)
VALUES('recolectores', 'Acceso a recolectores');
INSERT INTO public.roles
(nombre_role, descripcion)
VALUES('cajeros', 'Acceso a cajeros');
--empleados
INSERT INTO public.empleado
(nombre_empleado, apellido_empleado, telefono_empleado, email_empleado, "password", idrole, idcargo_empleado)
VALUES('Jose', 'Carrera', '1234567', 'test@test.com', 'password1', 1, 1);
INSERT INTO public.empleado
(nombre_empleado, apellido_empleado, telefono_empleado, email_empleado, "password", idrole, idcargo_empleado)
VALUES('Miguel', 'Coloma', '1234567', 'test@test.com', 'password2', 2, 2);
INSERT INTO public.empleado
(nombre_empleado, apellido_empleado, telefono_empleado, email_empleado, "password", idrole, idcargo_empleado)
VALUES('Madelin', 'Robles', '1234567', 'test@test.com', 'password3', 3, 3);
INSERT INTO public.empleado
(nombre_empleado, apellido_empleado, telefono_empleado, email_empleado, "password", idrole, idcargo_empleado)
VALUES('Hector', 'Contrera', '1234567', 'test@test.com', 'password4', 4, 4);
INSERT INTO public.empleado
(nombre_empleado, apellido_empleado, telefono_empleado, email_empleado, "password", idrole, idcargo_empleado)
VALUES('Pedro', 'Chial', '1234567', 'test@test.com', 'password5', 5, 5);
INSERT INTO public.empleado
(nombre_empleado, apellido_empleado, telefono_empleado, email_empleado, "password", idrole, idcargo_empleado)
VALUES('Luis', 'Cano', '1234567', 'test@test.com', 'password6', 1, 5);

--Modulo clientes
--cuentacontable
INSERT INTO public.cuentacontable
(nombrecuenta, tipocuenta)
VALUES('cuenta1', 'entrada');
INSERT INTO public.cuentacontable
(nombrecuenta, tipocuenta)
VALUES('cuenta2', 'entrada');
INSERT INTO public.cuentacontable
(nombrecuenta, tipocuenta)
VALUES('cuenta3', 'entrada');
INSERT INTO public.cuentacontable
(nombrecuenta, tipocuenta)
VALUES('cuenta4', 'entrada');
INSERT INTO public.cuentacontable
(nombrecuenta, tipocuenta)
VALUES('cuenta5', 'entrada');
--proveedor
INSERT INTO public.proveedor
(nombre_proveedor, direccion, telefono, regimen_proveedor, email_proveedor, idcuentacontable)
VALUES('porveedor1', 'direccion1', '1234567', 'regimen1', 'test@test.com', 1);
INSERT INTO public.proveedor
(nombre_proveedor, direccion, telefono, regimen_proveedor, email_proveedor, idcuentacontable)
VALUES('porveedor2', 'direccion2', '1234567', 'regimen2', 'test@test.com', 2);
INSERT INTO public.proveedor
(nombre_proveedor, direccion, telefono, regimen_proveedor, email_proveedor, idcuentacontable)
VALUES('porveedor3', 'direccion3', '1234567', 'regimen3', 'test@test.com', 3);
INSERT INTO public.proveedor
(nombre_proveedor, direccion, telefono, regimen_proveedor, email_proveedor, idcuentacontable)
VALUES('porveedor4', 'direccion4', '1234567', 'regimen4', 'test@test.com', 4);
INSERT INTO public.proveedor
(nombre_proveedor, direccion, telefono, regimen_proveedor, email_proveedor, idcuentacontable)
VALUES('porveedor5', 'direccion5', '1234567', 'regimen5', 'test@test.com', 5);
--cliente
INSERT INTO public.cliente
(nombre_cliente, telefono_cliente, email_cliente, nit, direccion_cliente, dpi, idcuentacontable)
VALUES('cliente1', 'tel1', 'test@test.com', 'nit1', 'direccion1', 'cedula',1);
INSERT INTO public.cliente
(nombre_cliente, telefono_cliente, email_cliente, nit, direccion_cliente, dpi, idcuentacontable)
VALUES('cliente2', 'tel2', 'test@test.com', 'nit2', 'direccion2', 'cedula',2);
INSERT INTO public.cliente
(nombre_cliente, telefono_cliente, email_cliente, nit, direccion_cliente, dpi, idcuentacontable)
VALUES('cliente1', 'tel3', 'test@test.com', 'nit3', 'direccion3', 'cedula',3);
INSERT INTO public.cliente
(nombre_cliente, telefono_cliente, email_cliente, nit, direccion_cliente, dpi, idcuentacontable)
VALUES('cliente1', 'tel4', 'test@test.com', 'nit4', 'direccion4', 'cedula',4);
INSERT INTO public.cliente
(nombre_cliente, telefono_cliente, email_cliente, nit, direccion_cliente, dpi, idcuentacontable)
VALUES('cliente1', 'tel5', 'test@test.com', 'nit5', 'direccion5', 'cedula',5);


--Modulo productos
--grupoproducto
INSERT INTO public.grupoproducto
(descripcion, estado)
VALUES('Grupo1', 1);
INSERT INTO public.grupoproducto
(descripcion, estado)
VALUES('Grupo2', 1);
INSERT INTO public.grupoproducto
(descripcion, estado)
VALUES('Grupo3', 1);
INSERT INTO public.grupoproducto
(descripcion, estado)
VALUES('Grupo4', 0);
INSERT INTO public.grupoproducto
(descripcion, estado)
VALUES('Grupo5', 0);
--linea
INSERT INTO public.linea
(descripcion, estado)
VALUES('linea1', 1);
INSERT INTO public.linea
(descripcion, estado)
VALUES('linea2', 1);
INSERT INTO public.linea
(descripcion, estado)
VALUES('linea3', 1);
INSERT INTO public.linea
(descripcion, estado)
VALUES('linea4', 0);
INSERT INTO public.linea
(descripcion, estado)
VALUES('linea5', 0);
--marca
INSERT INTO public.marca
(descripcion, estado)
VALUES('marca1', 1);
INSERT INTO public.marca
(descripcion, estado)
VALUES('marca2', 1);
INSERT INTO public.marca
(descripcion, estado)
VALUES('marca3', 2);
INSERT INTO public.marca
(descripcion, estado)
VALUES('marca4', 0);
INSERT INTO public.marca
(descripcion, estado)
VALUES('marca5', 0);
--Inventario
INSERT INTO public.inventario
(nombre, cantidad, tipo_comercializacion, modelo, unidades, precioventa, coste, margenganancia, idmarca, idlinea, idgrupoproducto, idproveedor, estado, impuestoinventario, idcuentacontable)
VALUES('Producto1', 10, 'tipoCom1', 'model1', 'unidades1', 100, 10, 90, 1, 1, 1, 1, 1, 0.12, 1);
INSERT INTO public.inventario
(nombre, cantidad, tipo_comercializacion, modelo, unidades, precioventa, coste, margenganancia, idmarca, idlinea, idgrupoproducto, idproveedor, estado, impuestoinventario, idcuentacontable)
VALUES('Producto2', 20, 'tipoCom2', 'model2', 'unidades2', 200, 20, 180, 2, 2, 2, 2, 2, 0.12, 2);
INSERT INTO public.inventario
(nombre, cantidad, tipo_comercializacion, modelo, unidades, precioventa, coste, margenganancia, idmarca, idlinea, idgrupoproducto, idproveedor, estado, impuestoinventario, idcuentacontable)
VALUES('Producto3', 30, 'tipoCom3', 'model3', 'unidades3', 300, 30, 270, 3, 3, 3, 3, 3, 0.12, 3);
INSERT INTO public.inventario
(nombre, cantidad, tipo_comercializacion, modelo, unidades, precioventa, coste, margenganancia, idmarca, idlinea, idgrupoproducto, idproveedor, estado, impuestoinventario, idcuentacontable)
VALUES('Producto4', 40, 'tipoCom4', 'model4', 'unidades4', 400, 40, 360, 4, 4, 4, 4, 4, 0.12, 4);
INSERT INTO public.inventario
(nombre, cantidad, tipo_comercializacion, modelo, unidades, precioventa, coste, margenganancia, idmarca, idlinea, idgrupoproducto, idproveedor, estado, impuestoinventario, idcuentacontable)
VALUES('Producto5', 50, 'tipoCom5', 'model5', 'unidades5', 500, 50, 450, 5, 5, 5, 5, 5, 0.12, 5);

--Modulo Facturas
--factura cab
INSERT INTO public.facturacab
(fecha_registro, plazos_pago, idempleado, idtipocliente, estadofac, total, idtipopago, nit, idtipofactura)
VALUES(CURRENT_DATE - INTERVAL '1 days', 1, 1, 1, 1, 10000.00, 1, 'nit1', 1);
INSERT INTO public.facturacab
(fecha_registro, plazos_pago, idempleado, idtipocliente, estadofac, total, idtipopago, nit, idtipofactura)
VALUES(CURRENT_DATE - INTERVAL '2 days', 2, 2, 2, 2, 20000.00, 1, 'nit2', 1);
INSERT INTO public.facturacab
(fecha_registro, plazos_pago, idempleado, idtipocliente, estadofac, total, idtipopago, nit, idtipofactura)
VALUES(CURRENT_DATE - INTERVAL '3 days', 3, 3, 3, 3, 30000.00, 1, 'nit3', 1);
INSERT INTO public.facturacab
(fecha_registro, plazos_pago, idempleado, idtipocliente, estadofac, total, idtipopago, nit, idtipofactura)
VALUES(CURRENT_DATE - INTERVAL '4 days', 4, 4, 4, 4, 40000.00, 1, 'nit4', 1);
INSERT INTO public.facturacab
(fecha_registro, plazos_pago, idempleado, idtipocliente, estadofac, total, idtipopago, nit, idtipofactura)
VALUES(CURRENT_DATE - INTERVAL '5 days', 5, 5, 5, 5, 50000.00, 1, 'nit5', 1);
--factura det
INSERT INTO public.facturadet
(idfactura, cantidad, preciounitario, iva, idproducto)
VALUES(1, 1, 10000, 0.01, 1);
INSERT INTO public.facturadet
(idfactura, cantidad, preciounitario, iva, idproducto)
VALUES(2, 2, 20000, 0.02, 2);
INSERT INTO public.facturadet
(idfactura, cantidad, preciounitario, iva, idproducto)
VALUES(3, 3, 30000, 0.03, 3);
INSERT INTO public.facturadet
(idfactura, cantidad, preciounitario, iva, idproducto)
VALUES(4, 4, 40000, 0.04, 4);
INSERT INTO public.facturadet
(idfactura, cantidad, preciounitario, iva, idproducto)
VALUES(5, 5, 50000, 0.05, 5);
--pedido
INSERT INTO public.pedido
(fecha_pedido, nit, idempleado, idproducto, idcliente, estado)
VALUES(CURRENT_DATE - INTERVAL '5 days', 'nit1', 1, 1, 1, 'activo');
INSERT INTO public.pedido
(fecha_pedido, nit, idempleado, idproducto, idcliente, estado)
VALUES(CURRENT_DATE - INTERVAL '4 days', 'nit2', 2, 2, 2, 'activo');
INSERT INTO public.pedido
(fecha_pedido, nit, idempleado, idproducto, idcliente, estado)
VALUES(CURRENT_DATE - INTERVAL '3 days', 'nit1', 3, 3, 3, 'activo');
INSERT INTO public.pedido
(fecha_pedido, nit, idempleado, idproducto, idcliente, estado)
VALUES(CURRENT_DATE - INTERVAL '2 days', 'nit1', 4, 4, 4, 'activo');
INSERT INTO public.pedido
(fecha_pedido, nit, idempleado, idproducto, idcliente, estado)
VALUES(CURRENT_DATE - INTERVAL '1 days', 'nit1', 5, 5, 5, 'activo');
