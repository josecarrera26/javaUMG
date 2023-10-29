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
                "SELECT k.idproducto.idproducto, SUM(k.unidadesVendidas) "
                + "FROM Kardex k "
                + "WHERE k.intOut = 'compra' "
                + "GROUP BY k.idproducto.idproducto "
                + "ORDER BY SUM(k.unidadesVendidas) DESC", // Ordena por la suma en orden descendente
                Object[].class
        );

        query.setMaxResults(8); // Limita los resultados a los 8 primeros productos más vendidos

        return query.getResultList();
    }

    public List<Object[]> sumUnidadesVendidasPorIdProducto() {
        TypedQuery<Object[]> query = entityManager.createQuery(
                "SELECT k.idproducto.idproducto, SUM(k.unidadesVendidas) "
                + "FROM Kardex k "
                + "WHERE k.intOut = 'venta' "
                + "GROUP BY k.idproducto.idproducto "
                + "ORDER BY SUM(k.unidadesVendidas) DESC", // Ordena por la suma en orden descendente
                Object[].class
        );

        query.setMaxResults(8); // Limita los resultados a los 8 productos más vendidos

        return query.getResultList();
    }

    //para grafico cirular 
    public Long sumUnidadesCompradas() {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT SUM(k.unidadesVendidas) "
                + "FROM Kardex k "
                + "WHERE k.intOut = 'compra'",
                Long.class
        );

        Long totalUnidadesCompradas = query.getSingleResult();
        return totalUnidadesCompradas != null ? totalUnidadesCompradas : 0;
    }

    public Long sumTotalUnidadesVendidas() {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT SUM(k.unidadesVendidas) "
                + "FROM Kardex k "
                + "WHERE k.intOut = 'venta'",
                Long.class
        );

        Long totalUnidadesVendidas = query.getSingleResult();
        return totalUnidadesVendidas != null ? totalUnidadesVendidas : 0;
    }

    public List<Object[]> sumUnidadesVendidasPorfecha() {
        TypedQuery<Object[]> query = entityManager.createQuery(
                "SELECT k.fecha, SUM(k.unidadesVendidas) "
                + "FROM Kardex k "
                + "WHERE k.intOut = 'venta' "
                + "GROUP BY k.fecha",
                Object[].class
        );

        List<Object[]> resultados = query.getResultList();

        return resultados;
    }
    
        public List<Object[]> sumUnidadesCompradasPorfecha() {
        TypedQuery<Object[]> query = entityManager.createQuery(
                "SELECT k.fecha, SUM(k.unidadesVendidas) "
                + "FROM Kardex k "
                + "WHERE k.intOut = 'compra' "
                + "GROUP BY k.fecha",
                Object[].class
        );

        List<Object[]> resultados = query.getResultList();

        return resultados;
    }


}
