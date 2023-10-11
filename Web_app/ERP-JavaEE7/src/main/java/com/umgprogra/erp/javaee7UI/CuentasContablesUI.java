/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Miguel Coloma
 */
@ManagedBean
@SessionScoped
public class CuentasContablesUI {

    public CuentasContablesUI(Integer idCuenta, String nombreCuenta, String tipoCuenta, String codigoCuenta, String idCliente, String idProveedores) {
        this.idCuenta = idCuenta;
        this.nombreCuenta = nombreCuenta;
        this.tipoCuenta = tipoCuenta;
        this.codigoCuenta = codigoCuenta;
        this.idCliente = idCliente;
        this.idProveedores = idProveedores;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(String idProveedores) {
        this.idProveedores = idProveedores;
    }
    private Integer idCuenta;
    private String nombreCuenta;
    private String tipoCuenta;
    private String codigoCuenta;
    private String idCliente;
    private String idProveedores;
    
    
}
