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
     
  public Boolean saveCuenta(String pnombre, String ptipocuenta) {
        boolean g = false;
        
        System.out.println( "Estoy en CuentacontableServicio");        

        try{
            Cuentacontable ncuenta = new Cuentacontable();
            System.out.println("nombre de Cuenta Contable" + pnombre);
            System.out.println("Tipo de Cuenta" + ptipocuenta);
            ncuenta.setNombrecuenta(pnombre);
            ncuenta.setTipocuenta(ptipocuenta);
            entity.getTransaction().begin();
            entity.persist(ncuenta);
            entity.getTransaction().commit();            

            System.out.println( "Estoy en CuentacontableServicio");
            g = true;            
        }catch (Exception e){
            System.err.println("Error al guardar Cuenta " + e.getMessage());           
        }
        return g;
    }
  
      public List<Cuentacontable> findAllCuenta() {
        List<Cuentacontable> resultList = new ArrayList<>();
        try {
            Query query = entity.createNamedQuery("Cuentacontable.findAll", Cuentacontable.class);
            //resultado
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron CuentasContables");
            }
        } catch (Exception e) {
            System.err.println("Error en findbyIdCuentacontable " + e.getMessage());
        }
    
        return resultList;

    }
      
public void getCuenta() {
        Cuentacontable cuenta = new Cuentacontable();
        Query query2 = entity.createNamedQuery("Cuentacontable.findAll", Cuentacontable.class);

        cuenta = (Cuentacontable) query2.getSingleResult();

        System.out.println(cuenta.getNombrecuenta() + cuenta.getTipocuenta());
    }
      
    public List<Cuentacontable> finderCuentaById(Integer idCuenta) {
        List<Cuentacontable> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findbyIdCuenta");
            System.out.println("idCuenta" + idCuenta);
            Query query = entity.createNamedQuery("Cuentacontable.findByIdcuentacontable", Cuentacontable.class)
                .setParameter("idcuenta", idCuenta);
            //resultado
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Cuentas Contables");
            }
        } catch (Exception e) {
            System.err.println("Error en findbyIdCuenta " + e.getMessage());
        }
    
        return resultList;

    }
}
