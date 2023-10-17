/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author josel
 */
public class Pedidos {
    
    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();
    
    public int  getLastPedido() {
       // Object[] ultimaFactura;
        int  idPedido =0;
        try {
            Query query = entity.createNamedQuery("Pedido.findUltimoPedido");
            idPedido = (int) query.getSingleResult();
            
            System.out.println("Esta es la utlimo pedido: " + idPedido);
        } catch (Exception e) {
            System.err.println("Error en getAllFacturas " + e.getMessage());
        }
        return idPedido;
    }
}
