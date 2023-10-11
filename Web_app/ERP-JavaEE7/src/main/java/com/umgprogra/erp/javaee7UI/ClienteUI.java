/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.ui.services.ClienteServicio;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Miguel Coloma
 */
@ManagedBean
@SessionScoped
public class ClienteUI  implements  Serializable {
    
    private Integer idCliente;
    private String nombreCliente;
    private String telefonoCliente;
    private String emailCliente;
    private String nitCliente;
    private String direccioncliente;
    private String dpiCliente;
    
//Constructor de Cliente
    public ClienteUI(Integer idCliente, String nombreCliente, String telefonoCliente, String emailCliente, String nitCliente, String direccioncliente, String dpiCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.nitCliente = nitCliente;
        this.direccioncliente = direccioncliente;
        this.dpiCliente = dpiCliente;
    }
    
    public ClienteUI(){
        
    }
    
//Getters y Setters de Cliente
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getDireccioncliente() {
        return direccioncliente;
    }

    public void setDireccioncliente(String direccioncliente) {
        this.direccioncliente = direccioncliente;
    }

    public String getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(String dpiCliente) {
        this.dpiCliente = dpiCliente;
    }
    
        public void saveCliente(){
        try{
            ClienteUI cliente = new ClienteUI();
            cliente.setNombreCliente(this.nombreCliente);
            System.out.println("error aqui");
            System.out.println(cliente.getNombreCliente());
            ClienteServicio clienteServ = new ClienteServicio();
        //if (
            System.out.println("error aqui2");
                clienteServ.saveCliente(cliente.getNombreCliente());
                //) {
            System.err.println( "Estoy en MarcaUITRUE");            
            
        }
        catch(Exception e){
            System.out.println(e + "Error en save MarcaUI");
        }
    }
    
}
