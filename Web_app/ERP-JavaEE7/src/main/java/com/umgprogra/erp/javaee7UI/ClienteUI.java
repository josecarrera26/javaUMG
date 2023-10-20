/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Cliente;
import com.umgprogra.erp.DAO.Cuentacontable;
import com.umgprogra.erp.ui.services.ClienteServicio;
import com.umgprogra.erp.ui.services.CuentacontableServicio;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Miguel Coloma
 */
@Named("dtFilterView")
@ManagedBean
@ViewScoped
public class ClienteUI implements Serializable {

    /**
     * @return the filteredCliente
     */
    public List<Cliente> getFilteredCliente() {
        return filteredCliente;
    }

    /**
     * @param filteredCliente the filteredCliente to set
     */
    public void setFilteredCliente(List<Cliente> filteredCliente) {
        this.filteredCliente = filteredCliente;
    }

    /**
     * @return the clienteItem
     */
    public List<SelectItem> getClienteItem() {
        return clienteItem;
    }

    /**
     * @param clienteItem the clienteItem to set
     */
    public void setClienteItem(List<SelectItem> clienteItem) {
        this.clienteItem = clienteItem;
    }

    /**
     * @return the clientes
     */
    public List<Cliente> getClientes() {
        return cliente;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Cliente> clientes) {
        this.cliente = clientes;
    }

    private Integer idCliente;
    private String nombreCliente;
    private String telefonoCliente;
    private String emailCliente;
    private String nitCliente;
    private String direccionCliente;
    private String dpiCliente;
    private List<Cliente> resultados;
    private List<SelectItem> clienteItem;
    private List<Cliente> cliente;
    private List<Cliente> filteredCliente;
    private Cuentacontable idCuenta;

    ClienteServicio servicio = new ClienteServicio();
//Constructor de Cliente

    public ClienteUI(Integer idCliente, String nombreCliente, String telefonoCliente, String emailCliente, String nitCliente, String direccionCliente, String dpiCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.nitCliente = nitCliente;
        this.direccionCliente = direccionCliente;
        this.dpiCliente = dpiCliente;

    }

    public ClienteUI() {

    }

//Getters y Setters de Cliente
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(String dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public List<Cliente> getResultados() {
        return resultados;
    }

    public Cuentacontable getCuentac() {
        CuentacontableServicio cuentaServicio = new CuentacontableServicio();
        idCuenta = cuentaServicio.getCuentacontableId(3);
        if (idCuenta != null) {
            if (!idCuenta.getNombrecuenta().equals("Iva por cobrar")) {
                System.out.println("ERROR AL AGREGAR CUENTA");
                idCuenta = null;
            }
        }
        return idCuenta;
    }

    public void saveCliente() {
        try {

            ClienteServicio nuevoCliente = new ClienteServicio();
            nuevoCliente.saveCliente(this.nombreCliente, this.telefonoCliente, this.emailCliente, this.nitCliente, this.direccionCliente, this.dpiCliente, getCuentac());
            cliente = nuevoCliente.findAllCliente();
        } catch (Exception e) {
            System.out.println(e + "Error en save ClienteUI");
        }
    }

    @PostConstruct
    public void init() {
        findAllClienteUi();
    }

    public void consultaCliente() {
        try {
            resultados = new ArrayList<>();
            System.out.println("idCliente buscado" + this.idCliente);
            resultados = servicio.finderClienteById(idCliente);
        } catch (Exception e) {
            System.err.println("Error al consultar");
        }
    }

    public void findAllClienteUi() {
        try {
            ClienteServicio clienteServ = new ClienteServicio();
            cliente = clienteServ.findAllCliente();
            clienteItem = new ArrayList<>();
            for (Cliente clientes : cliente) {
                clienteItem.add(new SelectItem(clientes.getIdcliente(), clientes.getNombreCliente(), clientes.getTelefonoCliente()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta marcas clase ClienteUI");
        }
    }

}
