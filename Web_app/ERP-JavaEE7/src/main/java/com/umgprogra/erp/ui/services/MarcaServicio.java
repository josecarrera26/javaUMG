/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Marca;
import com.umgprogra.erp.util.JpaUtil;
import javax.persistence.EntityManager;

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
            entity.getTransaction().begin();
            entity.persist(marca);
            entity.getTransaction().commit();
            System.err.println( "Estoy en MarcaServicio");
            g = true;
        } catch (Exception e){
            System.err.println(e + "Error en save Marca");
        }
        return g;
    }
}
