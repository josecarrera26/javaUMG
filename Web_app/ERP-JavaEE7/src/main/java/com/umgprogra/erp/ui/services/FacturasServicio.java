/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Cliente;
import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Facturacab;
import com.umgprogra.erp.DAO.Facturadet;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.DAO.Kardex;
import com.umgprogra.erp.DAO.Proveedor;
import com.umgprogra.erp.javaee7UI.FacturasCVUI;
import com.umgprogra.erp.util.JpaUtil;
import com.umgprogra.erp.util.SessionUser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author josel
 */
@ManagedBean
@SessionScoped
public class FacturasServicio {

    @PostConstruct
    public void init() {
        listadoClientes();
        getLastFactura();
    }

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();
    @Inject
    private SessionUser sessionUser = (SessionUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionU");

    public int getLastFactura() {
        // Object[] ultimaFactura;
        int idFac = 0;
        try {
            Query query = entity.createNamedQuery("Facturacab.findUltimaFactura");
            idFac = (int) query.getSingleResult();
            System.out.println("Esta es la utlima factura: " + idFac);
        } catch (Exception e) {
            System.err.println("Error en getAllFacturas " + e.getMessage());
        }
        return idFac;
    }

    public int insertarFacturacab(Integer pPlazoPagos, Integer pTipoCliente, double pTotal, Integer pTipoPago, String nit, int tipoFac) {
        int idFactura = 0;

        try {

            //preparacion de ingreso de fecha
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime ahora = LocalDateTime.now();
            String fechaString = dtf.format(ahora);
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);

            //Empleado empleado = entity.find(Empleado.class, pIDEmpleado);
            Facturacab facturacabecera = new Facturacab();

            facturacabecera.setFechaRegistro(fecha);
            facturacabecera.setPlazosPago(pPlazoPagos);
            facturacabecera.setIdempleado(sessionUser.getUser().getIdempleado());
            facturacabecera.setIdtipocliente(pTipoCliente);
            facturacabecera.setEstadofac(1);
            facturacabecera.setTotal(pTotal);
            facturacabecera.setIdtipopago(pTipoPago);
            facturacabecera.setNit(nit);
            facturacabecera.setIdtipofactura(tipoFac);

            entity.getTransaction().begin();
            entity.persist(facturacabecera);
            idFactura = facturacabecera.getIdfactura();
            System.out.println("IDULTIMAFACTURA EN CONSULTA" + facturacabecera.getIdfactura());
            entity.getTransaction().commit();

            // return "FacturaCab Guardada Numero de factura";
        } catch (Exception e) {
            idFactura = 0;
            entity.getTransaction().rollback();
            // return "Error Mensaje: " + e.toString();

        }
        return idFactura;
    }

    public boolean registroFacturaDet(int idFactura, List<FacturasCVUI> producto) throws ParseException {
        //preparacion de ingreso de fecha
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime ahora = LocalDateTime.now();
        String fechaString = dtf.format(ahora);

        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);
        boolean flag = false;
        try {
            Facturacab facturaCab = entity.find(Facturacab.class, idFactura);
            for (FacturasCVUI lista : producto) {
                Inventario inventario = entity.find(Inventario.class, lista.getIdProducto());
                //obtenenemos el precio unitario del producto

                int cantidadActual = inventario.getCantidad();

                if (cantidadActual >= lista.getCantidad()) {

                    // Crear una instancia de Facturadet
                    Facturadet facDet = new Facturadet();
                    //facturaCab.setTotal(totalfac);
                    //insertamos los datos al detalle de la factura
                    facDet.setIdfactura(facturaCab);
                    facDet.setCantidad(lista.getCantidad());
                    facDet.setPreciounitario(lista.getPrecioUnitario());
                    facDet.setIva(lista.getIva());
                    facDet.setIdproducto(inventario);

                    // instanciamos el dao kardex
                    Kardex insertarkardex = new Kardex();
                    //insertamos los datos al kardex
                    insertarkardex.setIdproducto(inventario);
                    insertarkardex.setUnidadesOriginales(cantidadActual);
                    insertarkardex.setUnidadesVendidas(lista.getCantidad());
                    insertarkardex.setVentaCompra(idFactura);
                    insertarkardex.setIntOut("venta");
                    insertarkardex.setFecha(fecha);

                    // Actualizar el inventario
                    inventario.setCantidad(cantidadActual - lista.getCantidad());

                    // Persistir el detalle de factura
                    entity.getTransaction().begin();
                    entity.persist(facDet);
                    entity.persist(insertarkardex);
                    entity.getTransaction().commit();

                }
                flag = true;
            }

        } catch (Exception e) {
            //para validar si la trasaccion esta en linea
            entity.getTransaction().rollback();
            //imprimir errores
            e.printStackTrace();
            flag = false;
        }
        return flag;

    }

    //metodo para registrar la factura compra
    public boolean registroDBDetalleCompra(int idFactura, List<FacturasCVUI> producto) throws ParseException {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        //preparacion de ingreso de fecha
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime ahora = LocalDateTime.now();
        String fechaString = dtf.format(ahora);

        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);
        boolean flag = false;

        try {

            TypedQuery<Integer> queryIdFac = entityManager.createQuery(
                    "SELECT MAX(f.idfactura) FROM Facturacab f", Integer.class);

            // Ejecutar la consulta y obtener el resultado
            Integer maxIdFactura = queryIdFac.getSingleResult();

            Facturacab facturaCab = entity.find(Facturacab.class, idFactura);
            for (FacturasCVUI lista : producto) {
                Inventario inventario = entity.find(Inventario.class, lista.getIdProducto());

                Integer nuevaCantidad = 0;
                Integer cantidadactual = inventario.getCantidad();

                //calculamos el precio de venta
                double margen = inventario.getMargenganancia();

                nuevaCantidad = lista.getCantidad() + inventario.getCantidad();
                double calculoPrecio = margen / 100;

                //cantidad original
                int cantidadActual = inventario.getCantidad();

                entity.getTransaction().begin();

                //inciamos el insert a las tablas
                //tabla facturas det
                Facturadet facDet = new Facturadet();
                facDet.setIdfactura(facturaCab);
                facDet.setIdproducto(inventario);
                facDet.setIva(lista.getIva());
                facDet.setCantidad(lista.getCantidad());
                facDet.setPreciounitario(lista.getCostoproducto());

                entity.persist(facDet);

                //Inset al kardex
                Kardex insertKardex = new Kardex();
                insertKardex.setFecha(fecha);
                insertKardex.setIdproducto(inventario);
                insertKardex.setIntOut("compra");
                insertKardex.setVentaCompra(maxIdFactura);
                insertKardex.setUnidadesOriginales(cantidadActual);
                insertKardex.setUnidadesVendidas(lista.getCantidad());
                // calcular el precio de venta
                //obtener el la suma del precio de compra
                String queryString = "SELECT SUM(fd.preciounitario) FROM Facturadet fd "
                        + "WHERE fd.idproducto.idproducto = :idproducto AND "
                        + "EXISTS (SELECT fc FROM Facturacab fc WHERE fc.idtipofactura = 1 AND fc.idfactura = fd.idfactura.idfactura)";

                TypedQuery<Double> query = entity.createQuery(queryString, Double.class);

                query.setParameter("idproducto", lista.getIdProducto());
                Double sumaSubtotal = query.getSingleResult();

                // conteo de la cantidad de veces que se ha comprado el producto
                String queryStringKardex = "SELECT COUNT(fd) FROM Facturadet fd WHERE fd.idproducto.idproducto = :idproducto AND "
                        + "EXISTS (SELECT fc FROM Facturacab fc WHERE fc.idtipofactura = 1 AND fc.idfactura = fd.idfactura.idfactura)";
                TypedQuery<Long> queryKardex = entity.createQuery(queryStringKardex, Long.class);

                queryKardex.setParameter("idproducto", lista.getIdProducto());
                Long conteo = queryKardex.getSingleResult();

                //insertar al inventario
                inventario.setCantidad(nuevaCantidad);

                //calculo de precio y costo
                double costopromedio = sumaSubtotal / conteo;
                double ventaprecio = (sumaSubtotal / conteo) / (1 - calculoPrecio);
                //iva inventario
                double ivaInventario = (nuevaCantidad * costopromedio) * 0.12;

                inventario.setImpuestoinventario(ivaInventario);
                inventario.setCoste(costopromedio);
                inventario.setPrecioventa(ventaprecio);

                entity.persist(insertKardex);
                entity.persist(inventario);
                entity.getTransaction().commit();

                System.out.println("Registrado con exito con exito");
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
    //mostrar id del cliete

    public List<Cliente> listadoClientes() {
        //EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

        List<Cliente> resultado = new ArrayList<>();
        //query para obtener el resutado
        Query query = entity.createNamedQuery("Cliente.findAll", Cliente.class);

        //obtenemos el resultado de la lista
        resultado = query.getResultList();

        return resultado;

    }

    //consulta de productos
    public List<Inventario> listadoProductos() {
        InventarioServicio inventarioServ = new InventarioServicio();
        List<Inventario> productos = inventarioServ.findAllProducto();
        return productos;
    }

    //agregar productos a la lista venta
    public FacturasCVUI agregarProducto(int idProducto, int cantidad, double totalFac, List<FacturasCVUI> listaProdVenta) {
        // List<FacturasCVUI> actualizarListYTotal = listaProdVenta;
        System.out.println("ESTOY EN agregarProducto COn ID " + idProducto);
        System.out.println("el tama;o de la lista es " + listaProdVenta.size());
        FacturasCVUI actualizarListYTotal = null;
        try {

            //para validacion de existacia en las tablas
            Inventario inventario = entity.find(Inventario.class, idProducto);
            int cantidadInventario = inventario.getCantidad();

            if (cantidadInventario > cantidad && cantidad != 0) {
                //obtenenemos el precio unitario del producto
                double preciounitario = inventario.getPrecioventa();
                String nombreProd = inventario.getNombre();
                //calculo del iva
                double iva = (preciounitario * cantidad) * 0.12;
                //calculo del subtotal
                double subTotal = (preciounitario * cantidad) + iva;

                FacturasCVUI existenciaprod = ProductoExistenteTablaLocal(idProducto, listaProdVenta);

                //si ya existe el producto en la tabla local ingresa a este if
                if (existenciaprod != null && cantidadInventario > existenciaprod.getCantidad() + cantidad) {
                    System.out.println("ESTOY EN el if si existe el prdd en tabla ");
                    System.out.println("el tama;o de la lista es " + listaProdVenta.size());
                    totalFac = totalFac + subTotal;

                    // si existe entonces remplazamos el valor existente en la lista
                    int x = indexListTabla(idProducto, listaProdVenta);

                    existenciaprod.setCantidad(existenciaprod.getCantidad() + cantidad);
                    existenciaprod.setIva((existenciaprod.getCantidad() * existenciaprod.getPrecioUnitario()) * 0.12);
                    existenciaprod.setSubTotalD((existenciaprod.getCantidad() * existenciaprod.getPrecioUnitario()) + existenciaprod.getIva());

                    listaProdVenta.set(x, existenciaprod);
                    actualizarListYTotal = new FacturasCVUI(totalFac, listaProdVenta);
                    System.out.println("Suma de producto Exito");
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "suma de producto", "exito."));
                }
                if (existenciaprod != null && cantidadInventario <= existenciaprod.getCantidad() + cantidad) {
                    System.out.println("Falta de inventario ERROR");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "falta de inventario", "error."));
                }

                //si el producto no esta en la lista lo insertamos como un nuevo registro
                if (existenciaprod == null) {
                    System.out.println("ESTOY en el if donde no existe el idProd en tabla ");
                    System.out.println("el tama;o de la lista es " + listaProdVenta.size());
                    totalFac = totalFac + subTotal;
                    listaProdVenta.add(new FacturasCVUI(cantidad, preciounitario, iva, idProducto, subTotal, nombreProd));
                    actualizarListYTotal = new FacturasCVUI(totalFac, listaProdVenta);
                    System.out.println("Agregado producto nuevo a la lista");
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "agregado a la lista", "Producto insertado con éxito."));
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "valor invalido o falta de inventario", "No se pudo insertar el producto."));

            }

        } catch (Exception e) {
            System.out.println("ERROR EN facturasServ agregar a tablaLocal " + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "No se pudo insertar el producto."));

        }
        return actualizarListYTotal;

    }

    //agregar productos a la lista venta
    public FacturasCVUI agregarProductoCompra(int idProducto, int cantidad, double totalFac, double costo, List<FacturasCVUI> listaProdCompra) {
        // List<FacturasCVUI> actualizarListYTotal = listaProdVenta;
        System.out.println("ESTOY EN agregarProducto COn ID " + idProducto);
        System.out.println("el tama;o de la lista es " + listaProdCompra.size());
        FacturasCVUI actualizarListYTotal = null;
        try {

            //para validacion de existacia en las tablas
            Inventario inventario = entity.find(Inventario.class, idProducto);

            if (costo > 0 && cantidad != 0) {
                //obtenenemos el precio unitario del producto
                String nombreProd = inventario.getNombre();
                //calculo del iva
                double iva = (costo * cantidad) * 0.12;
                //calculo del subtotal
                double subTotal = (costo * cantidad) + iva;

                FacturasCVUI existenciaprod = ProductoExistenteTablaLocal(idProducto, listaProdCompra);

                //si ya existe el producto en la tabla local ingresa a este if
                if (existenciaprod != null) {
                    System.out.println("ESTOY EN el if si existe el prdd en tabla ");
                    System.out.println("el tama;o de la lista es " + listaProdCompra.size());
                    totalFac = totalFac + subTotal;

                    // si existe entonces remplazamos el valor existente en la lista
                    int x = indexListTabla(idProducto, listaProdCompra);

                    existenciaprod.setCantidad(existenciaprod.getCantidad() + cantidad);
                    existenciaprod.setIva((existenciaprod.getCantidad() * existenciaprod.getCostoproducto()) * 0.12);
                    existenciaprod.setSubTotalD((existenciaprod.getCantidad() * existenciaprod.getCostoproducto()) + existenciaprod.getIva());

                    listaProdCompra.set(x, existenciaprod);
                    actualizarListYTotal = new FacturasCVUI(totalFac, listaProdCompra);
                    System.out.println("Suma de producto Exito");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "suma de producto", "exito."));
                }
                //si el producto no esta en la lista lo insertamos como un nuevo registro
                if (existenciaprod == null) {
                    System.out.println("ESTOY en el if donde no existe el idProd en tabla ");
                    System.out.println("el tama;o de la lista es " + listaProdCompra.size());
                    totalFac = totalFac + subTotal;
                    listaProdCompra.add(new FacturasCVUI(cantidad, iva, idProducto, subTotal, nombreProd, costo));
                    actualizarListYTotal = new FacturasCVUI(totalFac, listaProdCompra);
                    System.out.println("Agregado producto nuevo a la lista");
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "agregado a la lista", "Producto insertado con éxito."));
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "valor invalido o falta de inventario", "No se pudo insertar el producto."));

            }

        } catch (Exception e) {
            System.out.println("ERROR EN facturasServ agregar a tablaLocal " + e.getMessage());
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "No se pudo insertar el producto."));

        }
        return actualizarListYTotal;

    }

    FacturasCVUI ProductoExistenteTablaLocal(int idProducto, List<FacturasCVUI> listaProdVenta) {
        //buscamos si el producto ya se encuentra en la lista
        FacturasCVUI productosV = null;
        int index = 0;
        System.out.println("ESTOY EN PRODUCTOExistente COn ID " + idProducto);
        System.out.println("el tama;o de la lista es " + listaProdVenta.size());
        for (FacturasCVUI producto : listaProdVenta) {
            if (producto.getIdProducto() == idProducto) {

                productosV = producto;
                break;
            }
        }
        return productosV;
    }

    int indexListTabla(int idProducto, List<FacturasCVUI> listaProdVenta) {
        int index = 0;
        for (FacturasCVUI producto : listaProdVenta) {
            if (producto.getIdProducto() == idProducto) {

                break;
            }
            index++;
        }
        System.out.println("El producto se encuentra en el indice: " + index);
        return index;
    }

    //lista de proveedores
    public List<Proveedor> findIdAndName() {
        List<Proveedor> resultList = new ArrayList<>();
        try {
            Query query = entity.createNamedQuery("Proveedor.findIdAndName");
            List<Object[]> result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
                for (Object[] results : result) {
                    int idProveedor = (int) results[0];
                    String nombreProveedor = (String) results[1];
                    Proveedor proveedor = new Proveedor(idProveedor, nombreProveedor);
                    resultList.add(proveedor);
                }
            } else {
                System.out.println("No se encontraron Proveedores");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllPro " + e.getMessage());
        }

        return resultList;

    }
    //lista de productos
    public List<Inventario> findIdAndNameProd() {
        List<Inventario> resultList = new ArrayList<>();
        try {
            Query query = entity.createNamedQuery("Inventario.findIdAndNombre");
            List<Object[]> result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
                for (Object[] results : result) {
                    int idProducto = (int) results[0];
                    String nombreproducto = (String) results[1];
                    Inventario inventario = new Inventario(idProducto, nombreproducto);
                    resultList.add(inventario);
                }
            } else {
                System.out.println("No se encontraron Proveedores");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllPro " + e.getMessage());
        }

        return resultList;

    }
    
}
