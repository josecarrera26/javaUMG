/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erpUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author madis
 */
@ManagedBean
@SessionScoped

public class GrupoProducto implements Serializable {

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

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the grupos
     */
    public List<String> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(List<String> grupos) {
        this.grupos = grupos;
    }
    private int idGrupoProducto;
    private String descripcion;
    private String grupo;
    private List<String> grupos;
    
    @PostConstruct
     public void init() {
        grupos = new ArrayList<>();
       
            grupos.add("AutoMotriz");
            grupos.add("Deportes y Aire Libre");
            grupos.add("Electrodomesticos");
            grupos.add("Herramientas");
            grupos.add("Hogar");
            grupos.add("Infantil");
            grupos.add("Linea blanca");
            grupos.add("Muebles");
            grupos.add("Optica");
            grupos.add("Salud y Belleza");
            grupos.add("Tecnologia");
            grupos.add("Telefonia");
          
        
    }

}
