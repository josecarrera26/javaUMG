/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author ferna
 */
public class KardexServicio {
    EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
    
     public List<Object[]> sumUnidadesCompradasPorIdProducto() {
        TypedQuery<Object[]> query = entityManager.createQuery(
            "SELECT k.idproducto.idproducto, SUM(k.unidadesVendidas) " +
            "FROM Kardex k " +
            "WHERE k.intOut = 'compra' " +
            "GROUP BY k.idproducto.idproducto",
            Object[].class
        );

        return query.getResultList();
    }
     
    public List<Object[]> sumUnidadesVendidasPorIdProducto() {
        TypedQuery<Object[]> query = entityManager.createQuery(
                "SELECT k.idproducto.idproducto, SUM(k.unidadesVendidas) "
                + "FROM Kardex k "
                + "WHERE k.intOut = 'venta' "
                + "GROUP BY k.idproducto.idproducto",
                Object[].class
        );

        return query.getResultList();
    }

}
