/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Usuario;
import com.umgprogra.erp.ui.services.EmpleadoServicio;
import com.umgprogra.erp.ui.services.UsuarioServicio;
import com.umgprogra.erp.util.JpaUtil;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static javax.ws.rs.client.Entity.entity;

/**
 *
 * @author hccon
 */
@ManagedBean
@SessionScoped
public class UsuarioUI implements Serializable {
    
    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void GetUsuario() {
        try {

            UsuarioServicio servicioemp = new UsuarioServicio();

            // System.out.println("parametros enviados = " + this.idEmpleado + " " + this.password_empleado);
            servicioemp.findByUsername(this.username, this.password);

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Error en Servicio",
                    "Por Favor intente mas tarde!"));
        }
    }

    public void registroUsuario() {

        try {
            
            UsuarioServicio servicioreg = new UsuarioServicio();

            servicioreg.registrarUsuario(this.password, this.username);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Registro Exitoso!",
                        "Para iniciar sesion por favor regrese a Iniciar Sesion!"));

                System.out.println("El registro fue Exitoso");

        } catch (Exception e) {
            System.out.println("Error en metodo Registro Empleado = " + e.getMessage());
        }
    }

}
