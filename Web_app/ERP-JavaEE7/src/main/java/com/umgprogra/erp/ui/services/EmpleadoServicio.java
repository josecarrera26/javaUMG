/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Marca;
import com.umgprogra.erp.util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author hccon
 */
public class EmpleadoServicio {
    
    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();
    
     public void getEmpleado(String nombreEmpleado, String passwordEmpleado ){
        Empleado marca = new Empleado();
    Query query2 = entity.createNamedQuery("Empleado.findByEmpeadoPassword", Empleado.class)
                            .setParameter("nombreEmpleado", nombreEmpleado)
                            .setParameter("password", passwordEmpleado);
    
        Empleado empleado = (Empleado) query2.getSingleResult();
    
        System.out.println(empleado.getNombreEmpleado()+ empleado.getPassword());
    }
    
}
