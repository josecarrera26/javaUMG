/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Cliente;
import com.umgprogra.erp.DAO.Cuentacontable;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Miguel Coloma
 */
public class ClienteServicio {
    
    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

  public Boolean saveCliente(String pnombre, String ptelefono, String pemail, String pnit, String pdireccion, String pdpi, Cuentacontable idCuenta) {
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
            client.setIdcuentacontable(idCuenta);
            entity.getTransaction().begin();
            entity.persist(client);
            entity.getTransaction().commit();            

            System.out.println( "Estoy en ClienteServicio");
            g = true;            
        }catch (Exception e){
            System.err.println("Error al guardar Cliente " + e.getMessage());           
        }
        return g;
    }
  
      public void actualizarCliente(String pnombre, String ptelefono, String pemail, String pnit, String pdireccion, String pdpi, Cuentacontable idCuentacont) {
            Cliente queryCliente = new Cliente();
            Cliente updateCliente = new Cliente();
            Query query2 = entity.createNamedQuery("Cliente.findByNombreCliente", Cliente.class)
                    .setParameter("Nombre", pnombre);
            
            queryCliente = (Cliente) query2.getSingleResult();
            
            Integer idCliente = queryCliente.getIdcliente();
            System.out.println("nombre del cliente" + pnombre);
            System.out.println("Telefono" + ptelefono);
            System.out.println("Email" + pemail);
            System.out.println("Nit" + pnit);
            System.out.println("Direccion" + pdireccion);
            System.out.println("DPI" + pdpi);
            System.out.println("Cuenta" + idCuentacont);
            updateCliente.setIdcliente(idCliente);
            updateCliente.setNombreCliente(pnombre);
            updateCliente.setTelefonoCliente(ptelefono); 
            updateCliente.setEmailCliente(pemail);
            updateCliente.setNit(pnit);                       
            updateCliente.setDireccionCliente(pdireccion);
            updateCliente.setDpi(pdpi);
            updateCliente.setIdcuentacontable(idCuentacont);
            entity.getTransaction().begin();
            entity.merge(updateCliente);
            entity.getTransaction().commit();
            System.out.println("Cliente actualizado");
      }
  
      public void getCliente() {
        Cliente cliente = new Cliente();
        Query query2 = entity.createNamedQuery("Cliente.findAll", Cliente.class);

        cliente = (Cliente) query2.getSingleResult();

        System.out.println(cliente.getNombreCliente() + cliente.getTelefonoCliente() + cliente.getEmailCliente() + cliente.getNit() + cliente.getDireccionCliente() + cliente.getDpi() + cliente.getIdcuentacontable());
    }

    public List<Cliente> finderClienteById(Integer idCliente) {
        List<Cliente> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findbyIdCliente");
            System.out.println("idCliente" + idCliente);
            Query query = entity.createNamedQuery("Cliente.findByIdcliente", Cliente.class)
                .setParameter("idcliente", idCliente);
            //resultado
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Cliente");
            }
        } catch (Exception e) {
            System.err.println("Error en findbyIdCliente " + e.getMessage());
        }
    
        return resultList;

    }
    
    public List<Cliente> findAllCliente() {
        List<Cliente> resultList = new ArrayList<>();
        try {
            Query query = entity.createNamedQuery("Cliente.findAll", Cliente.class);
            List<Object[]> result = query.getResultList();
            //resultado
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Cliente");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllCliente " + e.getMessage());
        }
    
        return resultList;

    }
    
}
