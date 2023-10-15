/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Facturacab;
import com.umgprogra.erp.DAO.Facturadet;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
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

    public boolean registroFacturaDet(Integer cantidad, Integer idProducto) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
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

                facDet.setIdfactura(facturaCab);
                facDet.setCantidad(cantidad);
                facDet.setPreciounitario(preciounitario);
                facDet.setIva(iva);

                facDet.setIdproducto(inventario);
                // Actualizar el inventario
                inventario.setCantidad(cantidadActual - cantidad);

                // Persistir el detalle de factura
                entityManager.persist(facDet);
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
