/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Cargoempleado;
import com.umgprogra.erp.ui.services.EmpleadoServicio;
import com.umgprogra.erp.ui.services.CargosServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.inject.Named;

/**
 *
 * @author Miguel Coloma
 */
@Named("dtFilterView")
@ManagedBean
@ViewScoped
public class EmpleadoUI implements Serializable {

    /**
     * @return the cargoItems
     */
    public List<SelectItem> getCargoItems() {
        return cargoItems;
    }

    /**
     * @param cargoItems the cargoItems to set
     */
    public void setCargoItems(List<SelectItem> cargoItems) {
        this.cargoItems = cargoItems;
    }

    /**
     * @return the cargoT
     */
    public String getCargoT() {
        return cargoT;
    }

    /**
     * @param cargoT the cargoT to set
     */
    public void setCargoT(String cargoT) {
        this.cargoT = cargoT;
    }

    /**
     * @return the idCargo
     */
    public int getIdCargo() {
        return idCargo;
    }

    /**
     * @param idCargo the idCargo to set
     */
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    /**
     * @return the cargo
     */
    public Cargoempleado getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargoempleado cargo) {
        this.cargo = cargo;
    }

    private int idEmpleado;
    private String nombreEmpleado;
    private String apellido_empleado;
    private String telefono_empleado;
    private String email_empleado;
    private String password_empleado;
    private String cargoT;
    private int idCargo;
    private List<Empleado> resultados;
    private List<Empleado> empleados;
    private List<Empleado> filteredEmpleados;
    private List<SelectItem> empleadoItems;    
    private List<Cargoempleado> cargos;
    private List<SelectItem> cargoItems;
    private Cargoempleado cargo;
    
    EmpleadoServicio servicio = new EmpleadoServicio();    

    //Constructor de Empleado
    public EmpleadoUI(Integer idEmpleado, String nombre_empleado, String apellido_empleado, String telefono_empleado, String email_empleado, String password_empleado, String idcargo) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.telefono_empleado = telefono_empleado;
        this.email_empleado = email_empleado;
        this.password_empleado = password_empleado;
        this.cargoT = idcargo;
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
     * @return the resultados
     */
    public List<Empleado> getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(List<Empleado> resultados) {
        this.resultados = resultados;
    }

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
            
            if (nuevoEmpleado.saveEmpleado(nombreEmpleado, apellido_empleado, telefono_empleado, email_empleado, getCargoSeleccionado())) {
                System.err.println("Estoy en CargoUITRUE");
            } else {
                System.err.println("Estoy en EmpleadoUIFalse");
            }   
        } catch (Exception e) {
            System.out.println(e + "Error en save EmpleadoUI");
        }
    }
    
    @PostConstruct
        public void init() {
        findAllEmpleadoUi();
        findAllCargoUi();
    }
        
    //public void init() {
    //    mostrarURLactual();
    //}
    
    public void consultaEmpelado() {
        try {
            resultados = new ArrayList<>();
            System.out.println("idEmpleado buscado" + this.idEmpleado);
            resultados = servicio.finderEmpleadoById(idEmpleado);
        } catch (Exception e) {
            System.err.println("Error al consultar");
        }
    }
    
    public void findAllEmpleadoUi() {
        try {
            EmpleadoServicio empleadoServ = new EmpleadoServicio();
            empleados = empleadoServ.findAllEmpleados();
            empleadoItems = new ArrayList<>();
            for (Empleado empleado : empleados) {
                empleadoItems.add(new SelectItem(empleado.getIdempleado(), empleado.getNombreEmpleado(), empleado.getApellidoEmpleado()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta empleados clase EmpleadoUI");
        }
    }    
    
        public void findAllCargoUi() {
        try {
            CargosServicio cargoServ = new CargosServicio();
            cargos = cargoServ.findAllCargo();
            cargoItems = new ArrayList<>();
            for (Cargoempleado cargoObj : cargos) {
                cargoItems.add(new SelectItem(cargoObj.getIdcargo(), cargoObj.getNombreCargo()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta cargos clase CargoUI");
        }
    }

    public Cargoempleado getCargoSeleccionado() {
        try {
            CargosServicio cargoServ = new CargosServicio();
            cargo = cargoServ.getCargoId(idCargo).get(0);
        } catch (Exception e) {
            System.err.println("Error al consultar");
        }
        return cargo;
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
