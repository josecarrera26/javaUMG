/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Roles;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Miguel Coloma
 */
public class RolesServicio {
    
    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();
    
    public Boolean saveRole (String pnombrerole, String pdescripcion){
        boolean g = false;
        
            System.out.println( "Estoy en RolesServicio");
        try{
            Roles role = new Roles();
            System.out.println("nombre del role" + pnombrerole);
            System.out.println("Descripcion" + pdescripcion); 
            role.setNombreRole(pnombrerole);
            role.setDescripcion(pdescripcion);
            entity.getTransaction().begin();
            entity.persist(role);
            entity.getTransaction().commit();
            
            System.out.println( "Estoy en RoleServicio");
            g = true;
        }catch(Exception e){
            System.err.println("Error al guardar Role " + e.getMessage());            
        }
        return g; 
    }
    
        public List<Roles> findAllRoles() {
        List<Roles> resultList = new ArrayList<>();
        try {
            Query query = entity.createNamedQuery("Roles.findAll", Roles.class);
            //resultado
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Cliente");
            }
        } catch (Exception e) {
            System.err.println("Error en findbyIdRole " + e.getMessage());
        }
    
        return resultList;

    }
}
