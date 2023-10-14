/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Facturacab;
import com.umgprogra.erp.DAO.Facturadet;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.util.JpaUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
                actualizarInventario(entityManager, idProducto, cantidad);
                // Persistir el detalle de factura
                entityManager.persist(facDet);
                transaction.commit();
                return true; // La operación fue exitosa

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

    //funcion para actualizar la cantidad del inventario
    private void actualizarInventario(EntityManager entityManager, Integer idProducto, Integer cantidad) {
        Inventario inventario = entityManager.find(Inventario.class, idProducto);
        if (inventario != null) {
            int cantidadActual = inventario.getCantidad();
            if (cantidadActual >= cantidad) {
                inventario.setCantidad(cantidadActual - cantidad);
                entityManager.merge(inventario);
            } else {
                // Manejo de error
            }
        }
    }

}
