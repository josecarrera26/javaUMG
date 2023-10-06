/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erpUI;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author madis
 */
@ManagedBean
@RequestScoped
public class MarcaUI {

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
    
}
