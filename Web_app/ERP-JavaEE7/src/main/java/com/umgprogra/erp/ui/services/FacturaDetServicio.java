/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Facturacab;
import com.umgprogra.erp.DAO.Facturadet;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.DAO.Kardex;
import com.umgprogra.erp.util.JpaUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author ferna
 */
@ManagedBean
@SessionScoped
public class FacturaDetServicio {

    public boolean registroFacturaDet(Integer cantidad, Integer idProducto) throws ParseException {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        //preparacion de ingreso de fecha
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime ahora = LocalDateTime.now();
        String fechaString = dtf.format(ahora);  // Formatear la fecha en el formato deseado

        // Parsear la fecha formateada de nuevo a un objeto Date
        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);



        try {
            //obtenemos el id de la factura
            FacturasServicio noFac = new FacturasServicio();
            Integer numfac = noFac.getLastFactura();
            
            transaction.begin();
            // Crear una instancia de Facturadet
            Facturadet facDet = new Facturadet();
            //para validacion de existacia en las tablas
            Inventario inventario = entityManager.find(Inventario.class, idProducto);
            Facturacab facturaCab = entityManager.find(Facturacab.class, 1);
            //obtenenemos el precio unitario del producto
            double preciounitario = inventario.getPrecioventa();
            //calculo del iva
            double iva = (preciounitario * cantidad) * 0.12;

            int cantidadActual = inventario.getCantidad();
            
            if (cantidadActual >= cantidad) {
                
                // instanciamos el dao kardex
                Kardex insertarkardex = new Kardex();
                //insertamos los datos al kardex
                insertarkardex.setIdproducto(inventario);
                insertarkardex.setUnidadesOriginales(cantidadActual);
                insertarkardex.setUnidadesVendidas(cantidad);
                insertarkardex.setVentaCompra(2);
                insertarkardex.setIntOut("venta");
                insertarkardex.setFecha(fecha);
                
                //insertamos los datos al detalle de la factura
                facDet.setIdfactura(facturaCab);
                facDet.setCantidad(cantidad);
                facDet.setPreciounitario(preciounitario);
                facDet.setIva(iva);

                facDet.setIdproducto(inventario);
                // Actualizar el inventario
                inventario.setCantidad(cantidadActual - cantidad);

                // Persistir el detalle de factura
                entityManager.persist(facDet);
                entityManager.persist(insertarkardex);
                transaction.commit();
                return true; 
            }
        } catch (Exception e) {
            //para validar si la trasaccion esta en linea
            if (transaction.isActive()) {
                // si esta en linea desace los cambios hechos
                transaction.rollback();
            }
            //imprimir errores
            e.printStackTrace();
            return false;
        } finally {
            //cerrar persistencia
            entityManager.close();
        }
        return false;

    }
    @PostConstruct
      public void init() {
      listadoProductos();
      }
      
    //obtener listado id producto
    //mostrar lista de id producto 
    public List<Inventario> listadoProductos() {
        EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Inventario> resultado = new ArrayList<>();
        //query para obtener el resutado
        Query query = entity.createNamedQuery("Inventario.findAll", Inventario.class);

        //obtenemos el resultado de la lista
        resultado = query.getResultList();

        return resultado;

    }

}
