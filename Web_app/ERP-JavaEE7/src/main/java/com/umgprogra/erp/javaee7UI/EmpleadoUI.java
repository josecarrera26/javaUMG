/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author josel
 */
@ManagedBean
@SessionScoped
public class EmpleadoUI {

    /**
     * @return the idEmpleado
     */
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * @return the nombre_empleado
     */
    public String getNombre_empleado() {
        return nombre_empleado;
    }

    /**
     * @param nombre_empleado the nombre_empleado to set
     */
    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    /**
     * @return the apellido_empleado
     */
    public String getApellido_empleado() {
        return apellido_empleado;
    }

    /**
     * @param apellido_empleado the apellido_empleado to set
     */
    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    /**
     * @return the telefono_empleado
     */
    public String getTelefono_empleado() {
        return telefono_empleado;
    }

    /**
     * @param telefono_empleado the telefono_empleado to set
     */
    public void setTelefono_empleado(String telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    /**
     * @return the idCargo
     */
    public Integer getIdCargo() {
        return idCargo;
    }

    /**
     * @param idCargo the idCargo to set
     */
    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public EmpleadoUI(Integer idEmpleado, String nombre_empleado, String apellido_empleado, String telefono_empleado, Integer idCargo) {
        this.idEmpleado = idEmpleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.telefono_empleado = telefono_empleado;
        this.idCargo = idCargo;
    }
   private Integer idEmpleado;
   private String nombre_empleado;
   private String apellido_empleado;
   private String telefono_empleado;
   private Integer idCargo;
}
