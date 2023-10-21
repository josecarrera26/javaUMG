/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.CargoEmpleado;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author josel
 */
public class CargosServicio {

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public String InsertarCargo(String pNombreCargo, Double pSueldo) {
        try {
            CargoEmpleado cargo = new CargoEmpleado();
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

    public List<CargoEmpleado> getAllCargos() {

        List<CargoEmpleado> cargos = new ArrayList<>();

        Query query = entity.createQuery("SELECT c FROM cargo_empleado c");
        cargos = query.getResultList();
        return cargos;
    }
    
    public List<CargoEmpleado> getCargoId(int idCargo) {
        List<CargoEmpleado> resultList = new ArrayList<>();
        try {
            Query query2 = entity.createNamedQuery("CargoEmpleado.findByIdcargo", CargoEmpleado.class).setParameter("idcargo", idCargo);
            resultList = query2.getResultList();
            if (resultList == null && resultList.isEmpty()) {
                System.out.println("No se encontraron Cargos con el ID");
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta getCargoId" + e);
        }

        return resultList;
    }
    
    public List<CargoEmpleado> findAllCargo() {
        List<CargoEmpleado> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findAllCargo");
            Query query = entity.createNamedQuery("CargoEmpleado.findAll", CargoEmpleado.class);
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
