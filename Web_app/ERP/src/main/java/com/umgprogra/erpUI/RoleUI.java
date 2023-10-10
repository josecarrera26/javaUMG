/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erpUI;

import javax.inject.Named;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Miguel
 */
@SessionScoped
@Named
public class RoleUI {

    public RoleUI(Integer idRole, String nombreRole, String descripcion) {
        this.idRole = idRole;
        this.nombreRole = nombreRole;
        this.descripcion = descripcion;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNombreRole() {
        return nombreRole;
    }

    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    private Integer idRole;
    private String nombreRole;
    private String descripcion;
}
