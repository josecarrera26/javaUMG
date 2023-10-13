/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Facturacab;
import com.umgprogra.erp.DAO.Facturadet;
//import static com.umgprogra.erp.DAO.Facturadet_.idfactura;
//import static com.umgprogra.erp.DAO.Facturadet_.idproducto;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author ferna
 */
public class FacturaDetServicio {

//    public boolean registroFacturaDet(Integer idFactura, Integer cantidad, double precioUnitario, Integer idProducto) {
//
//        boolean exito = false;
//
//        double iva = precioUnitario * 0.12;
//
//        // Iniciar la persistencia
//        EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();
//
//        // Crear una instancia de Proveedor y configurar sus propiedades
//        Facturadet facDet = new Facturadet();
//        Inventario inventario = entity.find(Inventario.class, 1);
//        Facturacab facturaCab = entity.find(Facturacab.class, 1);
//
//        facDet.setIdfactura(facturaCab);
//        facDet.setCantidad(cantidad);
//        facDet.setPreciounitario(precioUnitario);
//        facDet.setIva(iva);
//        facDet.setIdproducto(inventario);
//        // Iniciar la transacción
//        entity.getTransaction().begin();
//
//        try {
//            // Persistir la entidad
//            entity.persist(facDet);
//
//            // Commit de la transacción
//            entity.getTransaction().commit();
//             actualizarInventario(idProducto, cantidad);
//            exito = true;  // Si llegamos aquí, la operación fue exitosa
//        } catch (Exception e) {
//            // En caso de excepción, marcamos la operación como fallida
//            entity.getTransaction().rollback();
//            exito = false;
//        } finally {
//            entity.close();
//        }
//
//        return exito;  // Devuelve true si la operación fue exitosa, de lo contrario, false
//    }
    public boolean registroFacturaDet(Integer idFactura, Integer cantidad, double precioUnitario, int idProducto) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            double iva = precioUnitario * 0.12;

            // Crear una instancia de Facturadet y configurar sus propiedades
            Facturadet facDet = new Facturadet();
            Inventario inventario = entityManager.find(Inventario.class, idProducto);
            Facturacab facturaCab = entityManager.find(Facturacab.class, 1);

            facDet.setIdfactura(facturaCab);
            facDet.setCantidad(cantidad);
            facDet.setPreciounitario(precioUnitario);
            facDet.setIva(iva);
            facDet.setIdproducto(inventario);

            // Persistir el detalle de factura
            entityManager.persist(facDet);

            // Actualizar el inventario
            actualizarInventario(entityManager, idProducto, cantidad);
            transaction.commit();
            return true; // La operación fue exitosa
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
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
