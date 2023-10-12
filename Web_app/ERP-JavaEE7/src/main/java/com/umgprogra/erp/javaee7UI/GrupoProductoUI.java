/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.ui.services.GrupoProductoServicio;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author madis
 */
@ManagedBean
@SessionScoped

public class GrupoProductoUI implements Serializable {


    /**
     * @return the idGrupoProducto
     */
    public int getIdGrupoProducto() {
        return idGrupoProducto;
    }

    /**
     * @param idGrupoProducto the idGrupoProducto to set
     */
    public void setIdGrupoProducto(int idGrupoProducto) {
        this.idGrupoProducto = idGrupoProducto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    private int idGrupoProducto;
    private String descripcion;
 
    
    public void saveGrupo() {
        try{
          
             GrupoProductoServicio grupoServ = new GrupoProductoServicio();
        if (grupoServ .saveGrupoProducto(descripcion)) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro guardado");
             //Agrega el mensaje al componente <p:growl>
            FacesContext.getCurrentInstance().addMessage("messages", mensaje);
        }else {
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error","Registro no guardado");
            // Agrega el mensaje al componente <p:growl>
           FacesContext.getCurrentInstance().addMessage("messages", mensaje);
        
    }

    }catch(Exception e){
               System.out.println(e + "Error en save GrupoUI");
    }
}
    

}
