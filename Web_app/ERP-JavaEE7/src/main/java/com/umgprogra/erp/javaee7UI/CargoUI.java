/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;


import com.umgprogra.erp.DAO.Cargoempleado;
import com.umgprogra.erp.ui.services.CargosServicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author josel
 */

@ManagedBean
@ViewScoped
@SessionScoped
public class CargoUI {

    /**
     * @return the cargos
     */
    public List<Cargoempleado> getCargos() {
        return cargos;
    }

    /**
     * @param cargos the cargos to set
     */
    public void setCargos(List<Cargoempleado> cargos) {
        this.cargos = cargos;
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

    /**
     * @return the nombre_cargo
     */
    public String getNombre_cargo() {
        return nombre_cargo;
    }

    /**
     * @param nombre_cargo the nombre_cargo to set
     */
    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    private Integer idCargo;
    private String nombre_cargo;
    private Double salario;
    
    private List<Cargoempleado> cargos;

    
    @PostConstruct
    public void init() {
    MenuPrincipalUI login = new MenuPrincipalUI();
    login.validarUsuario();
    listaCargos();
    }
    
    public void crearCargo(){
    
        CargosServicio nuevoCargo = new CargosServicio();
        
       nuevoCargo.InsertarCargo(this.nombre_cargo, this.salario);
    }
    
    public void updateCargo(){
    
        CargosServicio nuevoCargo = new CargosServicio();
        
       nuevoCargo.updateCargo(this.nombre_cargo, this.salario);
    }
    
    public void listaCargos(){
        cargos = new ArrayList<>();
        CargosServicio cargosServicio = new CargosServicio();
        cargos = cargosServicio.getAllCargos();
    }
}
