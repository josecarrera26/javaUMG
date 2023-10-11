/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.ui.services.CargosServicio;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author josel
 */

@ManagedBean
@SessionScoped
public class CargoUI {
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

    public CargoUI(Integer idCargo, String nombre_cargo, Double salario) {
        this.idCargo = idCargo;
        this.nombre_cargo = nombre_cargo;
        this.salario = salario;
    }
    private Integer idCargo;
    private String nombre_cargo;
    private Double salario;  
    
    public CargoUI(){}
    
    public String crearCargo(){
    
        CargosServicio nuevoCargo = new CargosServicio();
        
       return nuevoCargo.InsertarCargo(this.nombre_cargo, BigDecimal.valueOf(this.salario).toBigInteger());
    }
}
