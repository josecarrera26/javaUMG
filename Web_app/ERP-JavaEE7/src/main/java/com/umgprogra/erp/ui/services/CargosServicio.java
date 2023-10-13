/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.CargoEmpleado;
import com.umgprogra.erp.javaee7UI.CargoUI;
import com.umgprogra.erp.util.JpaUtil;
import java.math.BigInteger;
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
}
