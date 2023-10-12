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
import com.umgprogra.erp.javaee7UI.FacturasDET;
import com.umgprogra.erp.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ferna
 */
public class FacturaDetServicio {

    public boolean registroFacturaDet(Integer idFactura, Integer cantidad, double precioUnitario, Integer idProducto) {

        boolean exito = false; 

        double iva = precioUnitario * 0.12;

        // Iniciar la persistencia
        EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

        // Crear una instancia de Proveedor y configurar sus propiedades
        Facturadet facDet = new Facturadet();

        //facDet.setIdfactura((Facturacab) idfactura);
        facDet.setCantidad(cantidad);
        facDet.setPreciounitario(precioUnitario);
        facDet.setIva(iva);
        //facDet.setIdproducto((Inventario) idproducto);
        // Iniciar la transacción
        entity.getTransaction().begin();

        try {
            // Persistir la entidad
            entity.persist(facDet);

            // Commit de la transacción
            entity.getTransaction().commit();
            exito = true;  // Si llegamos aquí, la operación fue exitosa
        } catch (Exception e) {
            // En caso de excepción, marcamos la operación como fallida
            entity.getTransaction().rollback();
            exito = false;
        } finally {
            entity.close();
        }

        return exito;  // Devuelve true si la operación fue exitosa, de lo contrario, false
    }
}
