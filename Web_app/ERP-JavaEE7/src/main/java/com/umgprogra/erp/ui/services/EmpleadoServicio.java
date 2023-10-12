/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author hccon
 */
public class EmpleadoServicio {

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public List<Empleado> GetEmpleado() {
        List<Empleado> resultList = new ArrayList<>();
        try {
            Query query = entity.createNamedQuery("Empleado.findByEmpleadoPassword");
            List<Object[]> result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
                for (Object[] results : result) {
                    String nombreEmpleado = (String) results[0];
                    String password = (String) results[1];
                    Empleado empleado = new Empleado(nombreEmpleado, password);
                    
                    resultList.add(empleado);
                }
            } else {
                System.out.println("No se encontraron Empleados");
            }
        } catch (Exception e) {
            System.err.println("Error en GetEmpleado " + e.getMessage());
        }

        return resultList;

    }

}
