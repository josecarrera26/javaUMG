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
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.faces.model.SelectItem;

/**
 *
 * @author Miguel Coloma
 */
@Named("dtFilterView")
@ManagedBean
@ViewScoped
public class RolesUI implements  Serializable{

    /**
     * @return the rolesItems
     */
    public List<SelectItem> getRolesItems() {
        return rolesItems;
    }

    /**
     * @param rolesItems the rolesItems to set
     */
    public void setRolesItems(List<SelectItem> rolesItems) {
        this.rolesItems = rolesItems;
    }

    /**
     * @return the resultados
     */
    public List<Roles> getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(List<Roles> resultados) {
        this.resultados = resultados;
    }

    /**
     * @return the filteredRoles
     */
    public List<Roles> getFilteredRoles() {
        return filteredRoles;
    }

    /**
     * @param filteredRoles the filteredRoles to set
     */
    public void setFilteredRoles(List<Roles> filteredRoles) {
        this.filteredRoles = filteredRoles;
    }

    /**
     * @return the accesos
     */
    public String getAccesos() {
        return accesos;
    }

    /**
     * @param accesos the accesos to set
     */
    public void setAccesos(String accesos) {
        this.accesos = accesos;
    }

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

    public RolesUI(Integer idRole, String nombreRole, String descripcion, String accesos) {
        this.idRole = idRole;
        this.nombreRole = nombreRole;
        this.descripcion = descripcion;
        this.accesos = accesos;
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
    private String accesos;
    private List<Roles> resultados;
    private List<Roles> filteredRoles;
    private List<SelectItem> rolesItems;
    
    public RolesUI(List<Roles> roles) {
        this.roles = roles;
    }
    private List<Roles> roles;
    
        RolesServicio servicio = new RolesServicio();

    public void saveRole() {
        try {

            RolesServicio nuevoRole = new RolesServicio();
            nuevoRole.saveRole(this.nombreRole, this.descripcion, this.accesos);
            setRoles(nuevoRole.findAllRoles());
        } catch (Exception e) {
            System.out.println(e + "Error en save ClienteUI");
        }
    }
     
    public void updateRole() {
        try {
        RolesServicio newRole = new RolesServicio();
        newRole.updateRole(this.nombreRole, this.descripcion, this.accesos);
        
        } catch (Exception e) {
            System.out.println(e + "Error en updateRole RolesUI");
        }
    }   
            
    @PostConstruct
        public void init() {
        MenuPrincipalUI login = new MenuPrincipalUI();
        login.validarUsuario();
        findAllRolesUi();
    }            
 
    public void consultaRoles() {
        try {
            resultados = new ArrayList<>();
            System.out.println("idEmpleado buscado" + this.idRole);
            resultados = servicio.finderRoleById(idRole);
        } catch (Exception e) {
            System.err.println("Error al consultar");
        }
    } 
    
    public void findAllRolesUi() {
        try {
            RolesServicio rolServ = new RolesServicio();
            roles = rolServ.findAllRoles();
            rolesItems = new ArrayList<>();
            for (Roles role : roles) {
                rolesItems.add(new SelectItem(role.getIdrole(), role.getNombreRole(), role.getDescripcion()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta empleados clase RolesUI");
        }
    }     
}
