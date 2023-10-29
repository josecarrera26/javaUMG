/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Cargoempleado;
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
    
  public Boolean saveEmpleado(String pnombre, String papellido, String ptelefono, String pemail, Cargoempleado pidCargo) {
        boolean g = false;
        
        System.out.println( "Estoy en EmpleadoServicio");        

        try{
            Empleado emplea = new Empleado();
            System.out.println("Nombre del empleadod" + pnombre);
            System.out.println("Apellido del empleado" + papellido);
            System.out.println("Telefono" + ptelefono);
            System.out.println("Email" + pemail);
            System.out.println("ID Cargo" + pidCargo);
            emplea.setNombreEmpleado(pnombre);
            emplea.setApellidoEmpleado(papellido);
            emplea.setTelefonoEmpleado(ptelefono);
            emplea.setEmailEmpleado(pemail);
            emplea.setIdcargoEmpleado(pidCargo);
            emplea.setEstado("Activo");
            entity.getTransaction().begin();
            entity.persist(emplea);
            entity.getTransaction().commit();            

            System.out.println( "Estoy en EmpleadoServicio");
            g = true;            
        }catch (Exception e){
            System.err.println("Error al guardar Empleado " + e.getMessage());           
        }
        return g;
    }    

      public void getEmpleado() {
        Empleado empleado = new Empleado();
        Query query2 = entity.createNamedQuery("Empleado.findAll", Empleado.class);

        empleado = (Empleado) query2.getSingleResult();

        System.out.println(empleado.getNombreEmpleado() + empleado.getApellidoEmpleado() + empleado.getTelefonoEmpleado()+ empleado.getEmailEmpleado() + empleado.getIdcargoEmpleado());
    }
    
    public List<Empleado> finderEmpleadoById(Integer idEmpleado) {
        List<Empleado> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findByIdempleado");
            System.out.println("idEmpleado" + idEmpleado);
            Query query = entity.createNamedQuery("Empleado.findByIdempleado", Empleado.class)
                .setParameter("idemplado", idEmpleado);
            //resultado
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Empleado");
            }
        } catch (Exception e) {
            System.err.println("Error en findbyIdEmpleado " + e.getMessage());
        }
    
        return resultList;

    }      
      
    public List<Empleado> findAllEmpleados() {
        List<Empleado> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findAllEmpleados");
            Query query = entity.createNamedQuery("Empleado.findAll", Empleado.class);
            //resultado de lista EMPLEADOS
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Empleados");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllEmpleados " + e.getMessage());
        }

        return resultList;

    }

//    public int findByEmpleadoPassword(Integer idEmpleado, String password) {
//
//        try {
//
//            Empleado empleado = new Empleado();
//
//            Query query2 = entity.createNamedQuery("Empleado.findByIdempleado", Empleado.class)
//                    .setParameter("idempleado", idEmpleado);
//
//            empleado = (Empleado) query2.getSingleResult();
//
//            System.out.println("Id Empleado = " + " " + empleado.getIdempleado() + "Nombre Empleado" + " " + empleado.getNombreEmpleado());
//
//            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//
//            if (Objects.equals(empleado.getIdempleado(), idEmpleado) && empleado.getPassword().equals(password)) {
//                
//                
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
//                        "Conexion Exitosa", 
//                        "Gracias!"));
//
//                externalContext.redirect("views/MenuPrincipal.xhtml");
//                return 1;
//
//            } else {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
//                        "Nombre o Contraseña Invalida!",
//                        "Por Favor intente Nuevamente!"));
//                return 0;
//            }
//        } catch (Exception e) {
//            System.out.println("Error registrado = " + e.getMessage());
//        }
//        return 0;
//    }

}
