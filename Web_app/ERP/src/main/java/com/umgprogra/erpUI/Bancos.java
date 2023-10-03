/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erpUI;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ferna
 */
@ManagedBean
@SessionScoped
public class Bancos {
    
    private Integer idBanco;
    private String nombreBanco;
    private Integer tipoBanco;
    private Integer idProveedor;

    public Bancos(Integer idBanco, String nombreBanco, Integer tipoBanco, Integer idProveedor) {
        this.idBanco = idBanco;
        this.nombreBanco = nombreBanco;
        this.tipoBanco = tipoBanco;
        this.idProveedor = idProveedor;
    }
    //constructor vacio

    public Bancos() {
    }
    

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public Integer getTipoBanco() {
        return tipoBanco;
    }

    public void setTipoBanco(Integer tipoBanco) {
        this.tipoBanco = tipoBanco;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

}
