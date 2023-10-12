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

  public Boolean saveCliente(String pnombre, String ptelefono, String pemail, String pnit, String pdireccion, String pdpi) {
        boolean g = false;   
        
        System.out.println( "Estoy en ClienteServicio");        

        try{
            Cliente client = new Cliente();
            System.out.println("nombre del cliente" + pnombre);
            System.out.println("Telefono" + ptelefono);
            System.out.println("Email" + pemail);
            System.out.println("Nit" + pnit);
            System.out.println("Direccion" + pdireccion);
            System.out.println("DPI" + pdpi);
            client.setNombreCliente(pnombre);
            client.setTelefonoCliente(ptelefono);
            client.setEmailCliente(pemail);
            client.setNit(pnit);
            client.setDireccionCliente(pdireccion);
            client.setDpi(pdpi);
            entity.getTransaction().begin();
            entity.persist(client);
            entity.getTransaction().commit();            

            System.out.println( "Estoy en MarcaServicio");
            g = true;            
        }catch (Exception e){
            System.err.println("Error al guardar Cliente " + e.getMessage());           
        }
        return g;
    }
    
}
