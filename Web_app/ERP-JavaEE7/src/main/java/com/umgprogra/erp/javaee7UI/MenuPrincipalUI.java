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

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;


/**
 *
 * @author josel
 */
@ManagedBean
@ViewScoped
public class MenuPrincipalUI implements Serializable {

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
    public void cuentaContable (){
    validaVista("CuentasContables.xhtml");
            }
    
    public void empleados (){
    validaVista("Empleado.xhtml");
            }
    
    public void cargo (){
    validaVista("Cargo.xhtml");
            }
    
    public void roles(){
    validaVista("Role.xhtml");
    }
    
    public void cliente(){
    validaVista("Cliente.xhtml");
    }
    
    public void facturas(){
    validaVista("Facturas.xhtml");
    }
    
    public void proveedores(){
    validaVista("Proveedores.xhtml");
    }
    
    public void pedidos(){
    validaVista("Pedidos.xhtml");
    }
    
    public void inventario(){
    validaVista("Inventario.xhtml");
    }
    
    public void marca(){
    validaVista("marca.xhtml");
    }
    
    public void linea(){
    validaVista("Linea.xhtml");
    }
    
    public void grupoProducto(){
    validaVista("GrupoProducto.xhtml");
    }
    

    
}
