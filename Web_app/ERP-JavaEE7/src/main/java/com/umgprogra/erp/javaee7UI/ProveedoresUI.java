/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Cuentacontable;
import com.umgprogra.erp.DAO.Proveedor;
import com.umgprogra.erp.ui.services.CuentacontableServicio;
import com.umgprogra.erp.ui.services.ProveedoreServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ferna
 */
@Named("dtFilterView")
@ManagedBean
@ViewScoped
public class ProveedoresUI implements Serializable {

    /**
     * @return the resultados
     */
    public List<Proveedor> getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(List<Proveedor> resultados) {
        this.resultados = resultados;
    }

    /**
     * @return the proveedor
     */
    public List<Proveedor> getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(List<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the filteredCliente
     */
    public List<Proveedor> getFilteredCliente() {
        return filteredProveedor;
    }

    /**
     * @param filteredCliente the filteredCliente to set
     */
    public void setFilteredCliente(List<Proveedor> filteredCliente) {
        this.filteredProveedor = filteredCliente;
    }

    /**
     * @return the idCuenta
     */
    public Cuentacontable getIdCuenta() {
        return idCuenta;
    }

    /**
     * @param idCuenta the idCuenta to set
     */
    public void setIdCuenta(Cuentacontable idCuenta) {
        this.idCuenta = idCuenta;
    }

    private Integer idProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private Integer telefonoProveedor;
    private String regimenProvedor;
    private String emailProveedor;
    private Cuentacontable idCuenta;

    private List<Proveedor> filteredProveedor;
    private List<Proveedor> proveedor;
    private List<Proveedor> resultados;
    ProveedoreServicio servicio = new ProveedoreServicio();

    public ProveedoresUI(Integer idProveedor, String nombreProveedor, String direccionProveedor, Integer telefonoProveedor, String regimenProvedor, String emailProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.regimenProvedor = regimenProvedor;

        this.emailProveedor = emailProveedor;
    }

    //constructor vacio
    public ProveedoresUI() {
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public Integer getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(Integer telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getRegimenProvedor() {
        return regimenProvedor;
    }

    public void setRegimenProvedor(String regimenProvedor) {
        this.regimenProvedor = regimenProvedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public void registroProveedor() {

        try {
            ProveedoreServicio reg = new ProveedoreServicio();
            boolean exito = reg.registrarProveedor(this.nombreProveedor, this.direccionProveedor, this.telefonoProveedor, this.regimenProvedor, this.emailProveedor, getCuenta());

            if (exito) {
                // Éxito: muestra un mensaje de éxito
                System.out.println("save proveedor   ui  ");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Proveedor registrado con éxito");
                FacesContext.getCurrentInstance().addMessage(null, message);
                this.nombreProveedor = " ";
                this.direccionProveedor = "";
                this.emailProveedor = "";
                this.regimenProvedor = "";
                this.telefonoProveedor = 0;
            } else {
                // Error: muestra un mensaje de error
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo registrar el proveedor");
                FacesContext.getCurrentInstance().addMessage(null, message);
                System.out.println("ERROR SAVE proveedor   ui  ");
            }

        } catch (Exception e) {
            System.out.println(e + "Error en save PROVEEDORUI");
        }

    }

    public Cuentacontable getCuenta() {
        CuentacontableServicio cuentaServicio = new CuentacontableServicio();
        idCuenta = cuentaServicio.getCuentacontableId(1);
        if (idCuenta != null) {
            if (!idCuenta.getNombrecuenta().equals("Cuentas por pagar")) {
                System.out.println("ERROR AL AGREGAR CUENTA");
                idCuenta = null;
            }
        }
        return idCuenta;
    }

    @PostConstruct
    public void init() {
        MenuPrincipalUI login = new MenuPrincipalUI();
        login.validarUsuario();
    }

    public void consultaCliente() {
//        try {
//            setResultados(new ArrayList<>());
//            System.out.println("idCliente buscado" + this.idProveedor);
//            setResultados(servicio.finderidProveedorById(idProveedor));
//        } catch (Exception e) {
//            System.err.println("Error al consultar");
//        }
    }
}
