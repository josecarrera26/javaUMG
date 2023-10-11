/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Marca;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author madis
 */
public class MarcaServicio {

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public Boolean saveMarca(String descrip) {
        boolean g = false;
        try {
            Marca marca = new Marca();
            System.out.println("descripcion" + descrip);
            marca.setDescripcion(descrip);
            marca.setEstado(1);
            entity.getTransaction().begin();
            entity.persist(marca);
            entity.getTransaction().commit();
            g = true;
        } catch (Exception e) {
            System.out.println(e + "Error en save Marca");
            System.out.println("Error en Hibernate: " + e.getMessage());
        }
        return g;
    }

    public void getMarca() {
        Marca marca = new Marca();
        Query query2 = entity.createNamedQuery("Marca.findAll", Marca.class);

        marca = (Marca) query2.getSingleResult();

        System.out.println(marca.getDescripcion() + marca.getEstado());
    }

    public List<Marca> findAllMarca() {
        List<Marca> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findAllMarca");
            Query query = entity.createNamedQuery("Marca.findAll", Marca.class);
            //resultado de lista MARCAS
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Marcas");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllMarca " + e.getMessage());
        }
    
        return resultList;

    }
}
