/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.ui.services.MarcaServicio;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author madis
 */
@ManagedBean
@ViewScoped
public class MarcaUI implements Serializable {

    /**
     * @return the idMarca
     */
    public int getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the descripcionM
     */
    public String getDescripcionM() {
        return descripcionM;
    }

    /**
     * @param descripcionM the descripcionM to set
     */
    public void setDescripcionM(String descripcionM) {
        this.descripcionM = descripcionM;
    }

    private int idMarca;
    private String descripcionM;
   

    public void SaveMarca() {
        try{
            MarcaUI marca = new MarcaUI();
            marca.setDescripcionM(this.descripcionM);
            System.out.println("error aqui");
            System.out.println(marca.getDescripcionM());
             MarcaServicio marcaServ = new MarcaServicio();
        //if (
            System.out.println("error aqui2");
                marcaServ.saveMarca(marca.getDescripcionM());
                //) {
            System.err.println( "Estoy en MarcaUITRUE");
          //  FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro guardado");
            // Agrega el mensaje al componente <p:growl>
         //   FacesContext.getCurrentInstance().addMessage("messages", mensaje);
       // }else {
       //     System.err.println( "Estoy en MarcaUIFALSE");
       //      FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error","Registro no guardado");
            // Agrega el mensaje al componente <p:growl>
      //     FacesContext.getCurrentInstance().addMessage("messages", mensaje);
        
   // }

    }catch(Exception e){
               System.out.println(e + "Error en save MarcaUI");
    }
}

}
