/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Marca;
import com.umgprogra.erp.util.JpaUtil;
import javax.persistence.EntityManager;
import org.hibernate.HibernateException;



/**
 *
 * @author madis
 */
public class MarcaServicio {

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public Boolean saveMarca(String descrip) {
        boolean g = false;
         
        System.out.println( "Estoy en MarcaServicioA");
         
        try {
           Marca marca = new Marca();
            System.out.println("descripcion" + descrip);
            marca.setDescripcion(descrip);
            marca.setEstado(1);
            System.out.println("Antes de persistir " + marca.toString());
            System.out.println("conexion Inicial base de datos " + entity.getEntityManagerFactory().toString());
            entity.getTransaction().begin();
            entity.persist(marca);
            entity.getTransaction().commit();
            
            System.out.println( "Estoy en MarcaServicio");
            g = true;
        } catch (Exception e){
            System.out.println(e + "Error en save Marca");
            System.out.println("Error en Hibernate: " + e.getMessage());
        }
        return g;
    }
}
