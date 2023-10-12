/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.ui.services.ProveedoreServicio;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ferna
 */

@ManagedBean
@SessionScoped
public class Proveedores implements Serializable {

    private Integer idProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private Integer telefonoProveedor;
    private String regimenProvedor;
    private String emailProveedor;

    public Proveedores(Integer idProveedor, String nombreProveedor, String direccionProveedor, Integer telefonoProveedor, String regimenProvedor, String emailProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.regimenProvedor = regimenProvedor;
        
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

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
    
    
    public void registroProveedor() {
        ProveedoreServicio reg = new ProveedoreServicio();
        boolean exito = reg.registrarProveedor(this.nombreProveedor, this.direccionProveedor, this.telefonoProveedor, this.regimenProvedor, this.emailProveedor);

        if (exito) {
            // Éxito: muestra un mensaje de éxito
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Proveedor registrado con éxito");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            // Error: muestra un mensaje de error
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo registrar el proveedor");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        this.nombreProveedor = " ";
        this.direccionProveedor = "";
        this.emailProveedor = "";
        this.regimenProvedor = "";
        this.telefonoProveedor = 0;

    }

}
