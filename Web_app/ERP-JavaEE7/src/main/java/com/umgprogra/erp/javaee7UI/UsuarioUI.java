/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Roles;
import com.umgprogra.erp.ui.services.EmpleadoServicio;
import com.umgprogra.erp.ui.services.RolesServicio;
import com.umgprogra.erp.ui.services.UsuarioServicio;
import com.umgprogra.erp.util.JpaUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;

/**
 *
 * @author hccon
 */
@ManagedBean
@ViewScoped
@SessionScoped
public class UsuarioUI implements Serializable {

    /**
     * @return the estadoEmpleado
     */
    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    /**
     * @param estadoEmpleado the estadoEmpleado to set
     */
    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    /**
     * @return the todosRolesItems
     */
    public List<SelectItem> getTodosRolesItems() {
        return todosRolesItems;
    }

    /**
     * @param todosRolesItems the todosRolesItems to set
     */
    public void setTodosRolesItems(List<SelectItem> todosRolesItems) {
        this.todosRolesItems = todosRolesItems;
    }

    /**
     * @return the empleados
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * @return the empleadosItems
     */
    public List<SelectItem> getEmpleadosItems() {
        return empleadosItems;
    }

    /**
     * @param empleadosItems the empleadosItems to set
     */
    public void setEmpleadosItems(List<SelectItem> empleadosItems) {
        this.empleadosItems = empleadosItems;
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
     * @return the role
     */
    public Integer getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * @return the idEmpleado
     */
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    private String username;
    private String password;
    private Integer role;
    private Integer idEmpleado;
    private String estadoEmpleado;

    private List<Roles> roles;
    private List<SelectItem> todosRolesItems;

    private List<Empleado> empleados;
    private List<SelectItem> empleadosItems;

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

            registro = servicioreg.registrarUsuario(this.password, this.username, this.role, this.idEmpleado);

            if (registro == true) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Registro Exitoso!",
                        "Para iniciar sesion por favor regrese a Iniciar Sesion!"));

                System.out.println("Registro Exitoso");
                PrimeFaces.current().dialog().closeDynamic("registrarUsuario");
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

    public void registrarseFRM() {
        DialogFrameworkOptions options = DialogFrameworkOptions.builder()
                 .modal(true)
                .fitViewport(true)
                .responsive(true)
                .width("900px")
                .contentWidth("100%")
                .resizeObserver(true)
                .resizeObserverCenter(true)
                .resizable(true)
                .styleClass("max-w-screen")
                .iframeStyleClass("max-w-screen")
                .build();
        
        System.out.println("Se crean las opciones del dialog");
        PrimeFaces.current().dialog().openDynamic("registrarUsuario", options, null);
        System.out.println("Se crean las el dialog");
    }

    public void reinicioContrasenaFRM() {
        DialogFrameworkOptions options = DialogFrameworkOptions.builder()
                .resizable(true)
                .build();
        System.out.println("Se crean las opciones del dialog");
        PrimeFaces.current().dialog().openDynamic("UsuarioUpdateContrasena", options, null);
        System.out.println("Se crean las el dialog");
    }

    @PostConstruct
    public void init() {
        findAllRoles();
        findAllEmpleados();
    }

    public void findAllRoles() {
        try {
            RolesServicio listadoRoles = new RolesServicio();
            roles = listadoRoles.findAllRoles();
            todosRolesItems = new ArrayList<>();
            for (Roles rolesObj : roles) {
                todosRolesItems.add(new SelectItem(rolesObj.getIdrole(), rolesObj.getDescripcion()));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void findAllEmpleados() {
        try {
            EmpleadoServicio listadoEmpleados = new EmpleadoServicio();
            empleados=listadoEmpleados.findAllEmpleados();
            empleadosItems = new ArrayList<>();
            for (Empleado empleadosObj : empleados) {
                empleadosItems.add(new SelectItem(empleadosObj.getIdempleado(), empleadosObj.getNombreEmpleado()+ " - " + empleadosObj.getIdempleado()));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void actualizarUsuario(){
    UsuarioServicio actualizar = new UsuarioServicio();
    actualizar.actualizarUsuario(this.password, this.username, this.role, this.idEmpleado, this.estadoEmpleado);
    PrimeFaces.current().dialog().closeDynamic("registrarUsuario");
    }
}
