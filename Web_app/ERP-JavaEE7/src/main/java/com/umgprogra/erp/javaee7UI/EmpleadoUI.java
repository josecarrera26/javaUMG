/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.ui.services.EmpleadoServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author josel
 */
@ManagedBean
@SessionScoped
public class EmpleadoUI implements Serializable {

    private Integer idEmpleado;
    private String nombre_empleado;
    private String apellido_empleado;
    private String telefono_empleado;
    private String email_empleado;
    private String password_empleado;
    private Integer idRole;
    private Integer idCargo;
    private List<Empleado> empleados;
    private List<SelectItem> empleadoItems;

    /*public EmpleadoUI(Integer idEmpleado, String nombre_empleado, String apellido_empleado, String telefono_empleado, String email_empleado, String password_empleado, Integer idRole, Integer idCargo) {
        this.idEmpleado = idEmpleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.telefono_empleado = telefono_empleado;
        this.email_empleado = email_empleado;
        this.password_empleado = password_empleado;
        this.idRole = idRole;
        this.idCargo = idCargo;
    }*/
    public EmpleadoUI() {

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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<SelectItem> getEmpleadoItems() {
        return empleadoItems;
    }

    public void setEmpleadoItems(List<SelectItem> empleadoItems) {
        this.empleadoItems = empleadoItems;
    }
    
    @PostConstruct
    public void init() {
        mostrarURLactual();
    }
    
//    public void GetEmpleado() {
//        try {
//
//            EmpleadoServicio servicioemp = new EmpleadoServicio();
//
//            // System.out.println("parametros enviados = " + this.idEmpleado + " " + this.password_empleado);
//            servicioemp.findByEmpleadoPassword(this.idEmpleado, this.password_empleado);
//
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
//                    "Error en Servicio",
//                    "Por Favor intente mas tarde!"));
//        }
//    }

    public void registroEmpleado() {

        try {
            EmpleadoServicio servicioreg = new EmpleadoServicio();

            boolean registro = servicioreg.registrarEmpleado(this.nombre_empleado, this.apellido_empleado, this.telefono_empleado, this.email_empleado);

            if (registro == true) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Registro Exitoso!",
                        "Para iniciar sesion por favor regrese a Iniciar Sesion!"));

                System.out.println("El registro fue Exitoso");
            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Error en registro Empleado!",
                        "Por favor contacte al administrador"));
            }
        } catch (Exception e) {
            System.out.println("Error en metodo Registro Empleado = " + e.getMessage());
        }
    }
    
    public void mostrarURLactual(){
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

    String currentURL = request.getRequestURL().toString();
   
        System.out.println(currentURL);
    }
}
