/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Grupoproducto;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author madis
 */
public class GrupoProductoServicio {
        EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public Boolean saveGrupoProducto(String descrip) {
        boolean g = false;
        try {
           Grupoproducto grupoProd = new Grupoproducto();
            System.out.println("descripcion" + descrip);
            grupoProd.setDescripcion(descrip);
            grupoProd.setEstado(1);
            entity.getTransaction().begin();
            entity.persist(grupoProd);
            entity.getTransaction().commit();
            g = true;
        } catch (Exception e){
            System.out.println(e + "Error en save GrupoProducto");
        }
        return g;
    }
    
        public List<Grupoproducto> findAllGrupo() {
        List<Grupoproducto> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findAllGrupo");
            Query query = entity.createNamedQuery("Grupoproducto.findAll", Grupoproducto.class);
            //resultado de lista GRUPOS
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Grupos");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllGrupos " + e.getMessage());
        }
    
        return resultList;

    }
        
         public List<Grupoproducto> getGrupoId(int idGrupo) {
        List<Grupoproducto> resultList = new ArrayList<>();
        try {
            Query query2 = entity.createNamedQuery("Grupoproducto.findByIdgrupoproducto", Grupoproducto.class).setParameter("idgrupoproducto", idGrupo);
            resultList = query2.getResultList();
            if (resultList == null && resultList.isEmpty()) {
                System.out.println("No se encontraron grupos con el ID");
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta getGrupoId" + e);
        }

        return resultList;
    }
}
