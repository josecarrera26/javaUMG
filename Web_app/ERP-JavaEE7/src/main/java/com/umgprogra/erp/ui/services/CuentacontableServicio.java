/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Cuentacontable;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author madis
 */
public class CuentacontableServicio {
     EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();
     
     public Cuentacontable getCuentacontableId(int idcuenta) {
        Cuentacontable cuenta = new Cuentacontable();
        try {
            Query query2 = entity.createNamedQuery("Cuentacontable.findByIdcuentacontable", Cuentacontable.class).setParameter("idcuentacontable", idcuenta);
            cuenta = (Cuentacontable)query2.getSingleResult();
            if (cuenta == null) {
                System.out.println("No se encontro la cuenta con el ID");
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta getCuentacontableId" + e);
        }

        return cuenta;
    }
}
