/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Roles;
import com.umgprogra.erp.ui.services.RolesServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Miguel Coloma
 */
@ManagedBean
@ViewScoped
public class RolesUI implements  Serializable{

    /**
     * @return the roles
     */
    public List<Roles> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    /**
     * @return the idRole
     */
    public Integer getIdRole() {
        return idRole;
    }

    /**
     * @param idRole the idRole to set
     */
    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    /**
     * @return the nombreRole
     */
    public String getNombreRole() {
        return nombreRole;
    }

    /**
     * @param nombreRole the nombreRole to set
     */
    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
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

    public RolesUI(Integer idRole, String nombreRole, String descripcion) {
        this.idRole = idRole;
        this.nombreRole = nombreRole;
        this.descripcion = descripcion;
    }
    
        public RolesUI(){
        
    }

    public RolesServicio getServicio() {
        return servicio;
    }

    public void setServicio(RolesServicio servicio) {
        this.servicio = servicio;
    }
    
    private Integer idRole;
    private String nombreRole;
    private String descripcion;

    public RolesUI(List<Roles> roles) {
        this.roles = roles;
    }
    private List<Roles> roles;
    
        RolesServicio servicio = new RolesServicio();
    
            public void saveRole(){
        try{
         
            RolesServicio nuevoRole = new RolesServicio();
            nuevoRole.saveRole(this.nombreRole, this.descripcion);
            setRoles(nuevoRole.findAllRoles());
        }
        catch(Exception e){
            System.out.println(e + "Error en save ClienteUI");
        }
    }
    
}
