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
   private Integer idEmpleado;
   private String nombre_empleado;
   private String apellido_empleado;
   private String telefono_empleado;
   private String email_empleado;
   private String password_empleado;
   private Integer idRole;
   private Integer idCargo;

    public EmpleadoUI(Integer idEmpleado, String nombre_empleado, String apellido_empleado, String telefono_empleado, String email_empleado, String password_empleado, Integer idRole, Integer idCargo) {
        this.idEmpleado = idEmpleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.telefono_empleado = telefono_empleado;
        this.email_empleado = email_empleado;
        this.password_empleado = password_empleado;
        this.idRole = idRole;
        this.idCargo = idCargo;
    }
   
   
   public EmpleadoUI(){
       
   }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public String getTelefono_empleado() {
        return telefono_empleado;
    }

    public void setTelefono_empleado(String telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    public String getEmail_empleado() {
        return email_empleado;
    }

    public void setEmail_empleado(String email_empleado) {
        this.email_empleado = email_empleado;
    }

    public String getPassword_empleado() {
        return password_empleado;
    }

    public void setPassword_empleado(String password_empleado) {
        this.password_empleado = password_empleado;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
   
}
