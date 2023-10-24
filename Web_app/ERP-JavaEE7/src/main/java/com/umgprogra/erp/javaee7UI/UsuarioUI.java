/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.ui.services.UsuarioServicio;
import com.umgprogra.erp.util.JpaUtil;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;


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
        int existe = 0;
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {

            UsuarioServicio servicioemp = new UsuarioServicio();

            existe = servicioemp.findByUsername(this.username, this.password);

            if (existe == 1) {

              
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Conexion Exitosa",
                        "Gracias!"));

                externalContext.redirect("views/MenuPrincipal.xhtml");

            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Nombre o Contraseña Invalida!",
                        "Por Favor intente Nuevamente!"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Error en Servicio",
                    "Por Favor intente mas tarde!"));
        }
    }

    public int registroUsuario() {

        boolean registro;
        int existe;
        try {

            UsuarioServicio servicioreg = new UsuarioServicio();

            UsuarioServicio validacion = new UsuarioServicio();

            existe = validacion.findByUsername(this.username, this.password);

            if (existe == 1) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Username o Password ya existen!",
                        "Por favor ingrese un nuevo username o pongase en contacto con el administrador!"));

                System.out.println("Registro ya existe");
                return 1;
            }

            registro = servicioreg.registrarUsuario(this.password, this.username);

            if (registro == true) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Registro Exitoso!",
                        "Para iniciar sesion por favor regrese a Iniciar Sesion!"));

                System.out.println("Registro Exitoso");
                return 1;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Error en Registro!",
                        "Username ya existe!"));
                return 0;
            }

        } catch (Exception e) {
            System.out.println("Error en metodo Registro Empleado = " + e.getMessage());
        }
        return 0;
    }


    
    public Boolean acceso(String[] arregloAccesos, String ultimaParteURL) {
        Boolean tieneAccBoolean = null;
        for (String acceso : arregloAccesos) {
            if (acceso.equals(ultimaParteURL.trim())) {
                System.out.println("Acceso: " + acceso);
                System.out.println("tieneAcceso? Si");
                tieneAccBoolean = true;
                break;
            } else {
                tieneAccBoolean = false;
            }
        }
        return tieneAccBoolean;
    }
    
    public String ultimaParteURL() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String currentURL = request.getRequestURL().toString();
        String[] partes = currentURL.split("/");
        String ultimaParteURL = partes[partes.length - 1];
        return ultimaParteURL;
    }
}
