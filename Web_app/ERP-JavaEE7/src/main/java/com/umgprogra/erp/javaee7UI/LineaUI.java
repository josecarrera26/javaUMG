/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Linea;
import com.umgprogra.erp.ui.services.LineaServicio;
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
public class LineaUI implements Serializable {

    private String descripcion;
    private int idLinea = 0;
  

   


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

    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }


    public void saveLinea() {
        try {

            LineaServicio lineaServ = new LineaServicio();
            if (lineaServ.saveLinea(descripcion)) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro guardado");
                //Agrega el mensaje al componente <p:growl>
                FacesContext.getCurrentInstance().addMessage("messages", mensaje);
            } else {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Registro no guardado");
                // Agrega el mensaje al componente <p:growl>
                FacesContext.getCurrentInstance().addMessage("messages", mensaje);
            }

        } catch (Exception e) {
            System.out.println(e + "Error en save LineaUI");
        }
    }

  
}
