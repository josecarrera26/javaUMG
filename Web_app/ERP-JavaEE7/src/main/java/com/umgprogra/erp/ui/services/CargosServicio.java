/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.CargoEmpleado;
import com.umgprogra.erp.util.JpaUtil;
import java.math.BigInteger;
import javax.persistence.EntityManager;

/**
 *
 * @author josel
 */
public class CargosServicio {
    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();
    
    public String InsertarCargo(String pNombreCargo, BigInteger pSueldo) {
    try 
    {
        CargoEmpleado cargo = new CargoEmpleado();
        cargo.setNombreCargo(pNombreCargo);
        cargo.setSalario(pSueldo);
        
         entity.getTransaction().begin();
         entity.persist(cargo);
         entity.getTransaction().commit();
         return "Cargo creado Exitosamente";
    }
    catch (Exception e)
    {
        return e.getMessage();
    }
    }
}
