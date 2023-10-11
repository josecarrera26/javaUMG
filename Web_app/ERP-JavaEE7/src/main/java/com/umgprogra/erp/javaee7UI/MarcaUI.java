/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Marca;
import com.umgprogra.erp.ui.services.MarcaServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author madis
 */
@ManagedBean
@ViewScoped
public class MarcaUI implements Serializable {

    /**
     * @return the marcaItems
     */
    public List<SelectItem> getMarcaItems() {
        return marcaItems;
    }

    /**
     * @param marcaItems the marcaItems to set
     */
    public void setMarcaItems(List<SelectItem> marcaItems) {
        this.marcaItems = marcaItems;
    }

    /**
     * @return the marcas
     */
    public List<Marca> getMarcas() {
        return marcas;
    }

    /**
     * @param marcas the marcas to set
     */
    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

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
    private List<Marca> marcas;
    private List<SelectItem> marcaItems;

    public void saveMarca() {
        try {

            MarcaServicio marcaServ = new MarcaServicio();
            if (marcaServ.saveMarca(descripcionM)) {
                System.err.println("Estoy en MarcaUITRUE");
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro guardado");
                //Agrega el mensaje al componente <p:growl>
                FacesContext.getCurrentInstance().addMessage("messages", mensaje);
            } else {
                System.err.println("Estoy en MarcaUIFALSE");
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Registro no guardado");
                // Agrega el mensaje al componente <p:growl>
                FacesContext.getCurrentInstance().addMessage("messages", mensaje);

            }

        } catch (Exception e) {
            System.out.println(e + "Error en save MarcaUI");
        }
    }

    @PostConstruct
    public void init() {
        findAllMarcaUi();
    }

    public void findAllMarcaUi() {
        try {
            MarcaServicio marcaServ = new MarcaServicio();
            marcas = marcaServ.findAllMarca();
            marcaItems = new ArrayList<>();
            for (Marca marca : marcas) {
                marcaItems.add(new SelectItem(marca.getIdmarca(), marca.getDescripcion()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta marcas clase MarcaUI");
        }
    }

}
