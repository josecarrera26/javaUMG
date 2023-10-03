/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erpUI;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author ferna
 */
@ManagedBean
@RequestScoped

public class Proveedores {
    private Integer idProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private Integer telefonoProveedor;
    private String regimenProvedor;
    private String referenciaProveedor;
    private String emailProveedor;

    public Proveedores(Integer idProveedor, String nombreProveedor, String direccionProveedor, Integer telefonoProveedor, String regimenProvedor, String referenciaProveedor, String emailProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.regimenProvedor = regimenProvedor;
        this.referenciaProveedor = referenciaProveedor;
        this.emailProveedor = emailProveedor;
    }
    //constructor vacio
    public Proveedores() {
    }

    
    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public Integer getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(Integer telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getRegimenProvedor() {
        return regimenProvedor;
    }

    public void setRegimenProvedor(String regimenProvedor) {
        this.regimenProvedor = regimenProvedor;
    }

    public String getReferenciaProveedor() {
        return referenciaProveedor;
    }

    public void setReferenciaProveedor(String referenciaProveedor) {
        this.referenciaProveedor = referenciaProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
      
    public void prueba(){
        System.out.println("hollaaa");
    }
   
}
