/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Grupoproducto;
import com.umgprogra.erp.ui.services.GrupoProductoServicio;
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

public class GrupoProductoUI implements Serializable {

    /**
     * @return the grupos
     */
    public List<Grupoproducto> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(List<Grupoproducto> grupos) {
        this.grupos = grupos;
    }

    /**
     * @return the grupoItems
     */
    public List<SelectItem> getGrupoItems() {
        return grupoItems;
    }

    /**
     * @param grupoItems the grupoItems to set
     */
    public void setGrupoItems(List<SelectItem> grupoItems) {
        this.grupoItems = grupoItems;
    }

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
    private List<Grupoproducto> grupos;
    private List<SelectItem> grupoItems;
    
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
    
     @PostConstruct
    public void init() {
        findAllGrupoUi();
    }
    
    public void findAllGrupoUi() {
        try {
            GrupoProductoServicio grupoServ = new GrupoProductoServicio();
            grupos = grupoServ.findAllGrupo();
            grupoItems = new ArrayList<>();
            for (Grupoproducto grupo : grupos) {
                grupoItems.add(new SelectItem(grupo, grupo.getDescripcion()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta marcas clase GrupoUI");
        }
    }

}
