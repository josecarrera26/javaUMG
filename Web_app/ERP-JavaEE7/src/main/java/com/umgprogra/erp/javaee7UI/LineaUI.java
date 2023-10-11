/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Linea;
import com.umgprogra.erp.ui.services.LineaServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author madis
 */
@ManagedBean
@SessionScoped
public class LineaUI implements Serializable {

    private String descripcion;
    private String option;
    private List<String> options;
    private int idLinea = 0;
    private List<Linea> lineas;
    private List<SelectItem> lineaItems;

    /**
     * @return the marcas
     */
    public List<Linea> getLineas() {
        return lineas;
    }

    /**
     * @param lineas the marcas to set
     */
    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    /**
     * @return the lineaItems
     */
    public List<SelectItem> getLineaItems() {
        return lineaItems;
    }

    /**
     * @param lineaItems the marcaItems to set
     */
    public void setMarcaItems(List<SelectItem> lineaItems) {
        this.lineaItems = lineaItems;
    }

      @PostConstruct
    public void init() {
        findAllLineaUi();
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

    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
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

    public void findAllLineaUi() {
        try {
            LineaServicio lineaServ = new LineaServicio();
            lineas =lineaServ.findAllLinea();
            lineaItems=new ArrayList<>();
            for (Linea linea : lineas) {
                lineaItems.add(new SelectItem(linea.getIdlinea(), linea.getDescripcion()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta linea clase LineaUI");
        }
    }
}
