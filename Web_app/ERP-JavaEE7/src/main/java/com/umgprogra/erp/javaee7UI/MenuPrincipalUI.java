/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Roles;
import com.umgprogra.erp.ui.services.Nit;
import com.umgprogra.erp.util.JpaUtil;
import com.umgprogra.erp.util.SessionUser;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josel
 */
@ManagedBean
@ViewScoped
public class MenuPrincipalUI implements Serializable {

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    private String username;
    /**
     * @return the sessionUser
     */
    public SessionUser getSessionUser() {
        return sessionUser;
    }

    /**
     * @param sessionUser the sessionUser to set
     */
    public void setSessionUser(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }

    public MenuPrincipalUI() {
    }

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    @Inject
    private SessionUser sessionUser = (SessionUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionU");

    public void validaVista(String pagina) {
        try {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Integer usuario = sessionUser.getUser().getIdrole().getIdrole();
            String role = sessionUser.getUser().getIdrole().getAccesos();
            String nuevaPagina = pagina;

            System.out.println("role: " + role);
            System.out.println("idRole: " + usuario);

            if (usuario == 1) {
                externalContext.redirect(nuevaPagina);
            } else {
                String[] arrayAccesos = role.split(",");
                UsuarioUI acceso = new UsuarioUI();
                Boolean accesosBoolean;

                accesosBoolean = acceso.acceso(arrayAccesos, nuevaPagina);
                if (accesosBoolean) {
                    externalContext.redirect(nuevaPagina);
                } else {
                    DialogFrameworkOptions options = DialogFrameworkOptions.builder()
                            .resizable(true)
                            .build();
                    System.out.println("Se crean las opciones del dialog");
                    PrimeFaces.current().dialog().openDynamic("sinacceso", options, null);
                    System.out.println("Se crean las el dialog");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cuentaContable() {
        validaVista("CuentasContables.xhtml");
    }

    public void empleados() {
        validaVista("Empleado.xhtml");
    }

    public void cargo() {
        validaVista("Cargo.xhtml");
    }

    public void roles() {
        validaVista("Role.xhtml");
    }

    public void cliente() {
        validaVista("Cliente.xhtml");
    }

    public void facturas() {
        validaVista("Facturas.xhtml");
    }

    public void proveedores() {
        validaVista("Proveedores.xhtml");
    }

    public void pedidos() {
        validaVista("Pedidos.xhtml");
    }

    public void inventarioR() {
        validaVista("Inventario.xhtml");
    }

    public void inventarioE() {
        validaVista("editarProducto.xhtml");
    }

    public void marca() {
        validaVista("marca.xhtml");
    }

    public void linea() {
        validaVista("Linea.xhtml");
    }

    public void grupoProducto() {
        validaVista("GrupoProducto.xhtml");
    }

    public void getNombreNit() {
        Nit nombreNit = new Nit();
        nombreNit.getNitApi("CF");
    }

    @PostConstruct
    public void init() {
        validarUsuario();
    }

    public void validarUsuario() {
        
        try {
            if (sessionUser.getUser() == null) {
                System.out.println("Usuario no incio sesion.");
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                externalContext.redirect("http://localhost:8080/ERP-JavaEE7");
            }
            else{
                this.username = sessionUser.getUser().getUsername();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
    
    public void logout(){
        
        try {
            System.out.println("El usuario " + this.username + " se deloggeo.");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("sessionU");
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("http://localhost:8080/ERP-JavaEE7");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    
    }
}
