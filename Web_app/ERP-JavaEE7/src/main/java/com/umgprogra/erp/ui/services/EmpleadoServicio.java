/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author hccon
 */
public class EmpleadoServicio {

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    /* public List<Empleado> GetEmpleado() {
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
    
    public List<Empleado> findAllEmpleados() {
        List<Empleado> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findAllMarca");
            Query query = entity.createNamedQuery("Empleado.findAll", Empleado.class);
            //resultado de lista EMPLEADOS
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Marcas");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllMarca " + e.getMessage());
        }
    
        return resultList;

    }

     */
    public int  findByEmpleadoPassword(Integer idEmpleado, String password) {

        try {

            Empleado empleado = new Empleado();

            Query query2 = entity.createNamedQuery("Empleado.findAll", Empleado.class);

            empleado = (Empleado) query2.getSingleResult();

            if (Objects.equals(empleado.getIdempleado(), idEmpleado) && empleado.getPassword().equals(password)) {
                System.out.println("Empleado si Existe");
                return 1;
            } else {
                System.out.println("Empleado no existe");
            }
            /*
            if(empleado.getPassword().equals(password)){
                System.out.println("Password Empleado Correcto");
                return 1;
        }else{
                 System.out.println("Empleado no existe");
            }
             */

        } catch (Exception e) {
            System.out.println("Error registrado = " + e.getMessage());
        }
        return 0;
    }
    
    public List<Empleado> findAllEmpleados() {
        List<Empleado> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findAllMarca");
            Query query = entity.createNamedQuery("Empleado.findAll", Empleado.class);
            //resultado de lista Empleado
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Marcas");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllMarca " + e.getMessage());
        }
    
        return resultList;

    }

}
