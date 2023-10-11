/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Cliente;
import com.umgprogra.erp.util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Miguel Coloma
 */
public class ClienteServicio {
    
    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

  public Boolean saveCliente(String nomb) {
        boolean g = false;   
        
        System.out.println( "Estoy en ClienteServicio");        

        try{
            Cliente cliente = new Cliente();
            System.out.println("nombre del cliente" + nomb);
            cliente.setNombreCliente(nomb);
            System.out.println("Antes de persistir " + cliente.toString());
            System.out.println("conexion Inicial base de datos " + entity.getEntityManagerFactory().toString());
            entity.getTransaction().begin();
            entity.persist(cliente);
            entity.getTransaction().commit();            

            System.out.println( "Estoy en MarcaServicio");
            g = true;            
        }catch (Exception e){
            System.out.println(e + "Error en save Cliente");
            System.out.println("Error en Hibernate: " + e.getMessage());            
        }
        return g;
    }
    
}
