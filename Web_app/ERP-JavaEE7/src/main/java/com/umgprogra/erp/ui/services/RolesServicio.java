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
    
    public Boolean saveRole (String pnombrerole, String pdescripcion, String paccesos){
        boolean g = false;
        
            System.out.println( "Estoy en RolesServicio");
        try{
            Roles role = new Roles();
            System.out.println("nombre del role" + pnombrerole);
            System.out.println("Descripcion" + pdescripcion); 
            System.out.println("Accesos" + paccesos); 
            role.setNombreRole(pnombrerole);
            role.setDescripcion(pdescripcion);
            role.setAccesos(paccesos);
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
    
        public String updateRole(String pnombrerole, String pdescripcion, String paccesos) {
        try {
            
            Roles roleQuery = new Roles();
            Roles role = new Roles();
             Query query2 = entity.createNamedQuery("Roles.findByNombreRole", Roles.class)
                    .setParameter("nombreRole", pnombrerole);

            roleQuery = (Roles) query2.getSingleResult();
            
            Integer idRole = roleQuery.getIdrole();                      
            
            role.setIdrole(idRole);
            role.setNombreRole(pnombrerole);
            role.setDescripcion(pdescripcion);
            role.setAccesos(paccesos);

            entity.getTransaction().begin();
            entity.merge(role);
            entity.getTransaction().commit();
            return "Role actualizado Exitosamente";
        } catch (Exception e) {
            return e.getMessage();
        }   
    }
    
    public void getRole() {
        Roles rol = new Roles();
        Query query2 = entity.createNamedQuery("Roles.findAll", Roles.class);

        rol = (Roles) query2.getSingleResult();

        System.out.println(rol.getNombreRole()+ rol.getDescripcion()+ rol.getAccesos());
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
                System.out.println("No se encontraron Roles");
            }
        } catch (Exception e) {
            System.err.println("Error en findbyIdRole " + e.getMessage());
        }    
        return resultList;
    }
        
        public List<Roles> finderRoleById(Integer idRole) {
        List<Roles> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findByIdrole");
            System.out.println("idRole" + idRole);
            Query query = entity.createNamedQuery("Empleado.findByIdempleado", Roles.class)
                .setParameter("idrole", idRole);
            //resultado
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Role");
            }
        } catch (Exception e) {
            System.err.println("Error en findbyIdRole " + e.getMessage());
        }   
        return resultList;
    }
}
