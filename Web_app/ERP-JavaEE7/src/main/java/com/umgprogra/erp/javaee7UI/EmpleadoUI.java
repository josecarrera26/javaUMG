/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.CargoEmpleado;
import com.umgprogra.erp.ui.services.EmpleadoServicio;
import com.umgprogra.erp.ui.services.CargosServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.inject.Named;

/**
 *
 * @author josel
 */
@Named("dtFilterView")
@ManagedBean
@ViewScoped
public class EmpleadoUI implements Serializable {

    /**
     * @return the filteredEmpleados
     */
    public List<Empleado> getFilteredEmpleados() {
        return filteredEmpleados;
    }

    /**
     * @param filteredEmpleados the filteredEmpleados to set
     */
    public void setFilteredEmpleados(List<Empleado> filteredEmpleados) {
        this.filteredEmpleados = filteredEmpleados;
    }

    private Integer idEmpleado;
    private String nombreEmpleado;
    private String apellido_empleado;
    private String telefono_empleado;
    private String email_empleado;
    private String password_empleado;
    private CargoEmpleado idCargo;
    private List<Empleado> empleados;
    private List<Empleado> filteredEmpleados;
    private List<SelectItem> empleadoItems;

    public EmpleadoUI(Integer idEmpleado, String nombre_empleado, String apellido_empleado, String telefono_empleado, String email_empleado, String password_empleado, CargoEmpleado idCargo) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.telefono_empleado = telefono_empleado;
        this.email_empleado = email_empleado;
        this.password_empleado = password_empleado;
        this.idCargo = idCargo;
    }
    public EmpleadoUI() {

    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
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

    /**
     * @return the idCargo
     */
    public CargoEmpleado getIdCargo() {
        return idCargo;
    }

    /**
     * @param idCargo the idCargo to set
     */
    public void setIdCargo(CargoEmpleado idCargo) {
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

    public void saveEmpleado() {
        try {

            EmpleadoServicio nuevoEmpleado = new EmpleadoServicio();
            nuevoEmpleado.saveEmpleado(this.nombreEmpleado, this.apellido_empleado, this.telefono_empleado, this.email_empleado, this.idCargo);
            empleados = nuevoEmpleado.findAllEmpleados();
        } catch (Exception e) {
            System.out.println(e + "Error en save EmpleadoUI");
        }
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
    
    public void mostrarURLactual(){
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

    String currentURL = request.getRequestURL().toString();
   
        System.out.println(currentURL);
    }
}
