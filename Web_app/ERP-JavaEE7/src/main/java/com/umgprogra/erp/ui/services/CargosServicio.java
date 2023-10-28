/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Cargoempleado;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author josel
 */
@ViewScoped
public class CargosServicio {

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public String InsertarCargo(String pNombreCargo, Double pSueldo) {
        try {
            Cargoempleado cargo = new Cargoempleado();
            cargo.setNombreCargo(pNombreCargo);
            cargo.setSalario(pSueldo);

            entity.getTransaction().begin();
            entity.persist(cargo);
            entity.getTransaction().commit();
            return "Cargo creado Exitosamente";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updateCargo(String pNombreCargo, Double pSueldo) {
        try {
            
            Cargoempleado cargoQuery = new Cargoempleado();
            Cargoempleado cargo = new Cargoempleado();
             Query query2 = entity.createNamedQuery("Cargoempleado.findByNombreCargo", Cargoempleado.class)
                    .setParameter("nombreCargo", pNombreCargo);

            cargoQuery = (Cargoempleado) query2.getSingleResult();
            
            Integer idCargo = cargoQuery.getIdcargo();
                        
            cargo = entity.find(Cargoempleado.class, idCargo);
            
            cargo.setSalario(pSueldo);

            entity.getTransaction().begin();
            entity.merge(cargo);
            entity.getTransaction().commit();
            return "Cargo actualizado Exitosamente";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<Cargoempleado> getAllCargos() {

        List<Cargoempleado> cargos = new ArrayList<>();
        cargos = null;

        try {
            Query query = entity.createNamedQuery("Cargoempleado.findAll", Cargoempleado.class);
            cargos = query.getResultList();
            return cargos;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return cargos;
        }
    }

    public List<Cargoempleado> getCargoId(int idCargo) {
        List<Cargoempleado> resultList = new ArrayList<>();
        try {
            Query query2 = entity.createNamedQuery("Cargoempleado.findByIdcargo", Cargoempleado.class)
                    .setParameter("idcargo", idCargo);
            resultList = query2.getResultList();
            if (resultList == null && resultList.isEmpty()) {
                System.out.println("No se encontraron Cargos con el ID");
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta getCargoId" + e);
        }

        return resultList;
    }

    public List<Cargoempleado> findAllCargo() {
        List<Cargoempleado> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findAllCargo");
            Query query = entity.createNamedQuery("Cargoempleado.findAll", Cargoempleado.class);
            //resultado de lista Cargos
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Cargos");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllCargo " + e.getMessage());
        }

        return resultList;

    }
}
