/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Linea;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author madis
 */
public class LineaServicio {
      EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public Boolean saveLinea(String descrip) {
        boolean g = false;
        try {
           Linea linea = new Linea();
            System.out.println("descripcion" + descrip);
            linea.setDescripcion(descrip);
            linea.setEstado(1);
            entity.getTransaction().begin();
            entity.persist(linea);
            entity.getTransaction().commit();
            g = true;
        } catch (Exception e){
            System.out.println(e + "Error en save Linea");
            System.out.println("Error en Hibernate: " + e.getMessage());
        }
        return g;
    }
    
        public List<Linea> findAllLinea() {
        List<Linea> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findAllLinea");
            Query query = entity.createNamedQuery("Linea.findAll", Linea.class);
            //resultado de lista LINEA
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Lineas");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllLinea " + e.getMessage());
        }
    
        return resultList;

    }
        
         public List<Linea> getLineaId(int idLinea) {
        List<Linea> resultList = new ArrayList<>();
        try {
            Query query2 = entity.createNamedQuery("Linea.findByIdlinea", Linea.class).setParameter("idlinea", idLinea);
            resultList = query2.getResultList();
            if (resultList == null && resultList.isEmpty()) {
                System.out.println("No se encontraron Lineas con el ID");
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta getLineaId" + e);
        }

        return resultList;
    }
}
