/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.umgprogra.erp.ui.services.CuentacontableServicio;
import com.umgprogra.erp.DAO.Cuentacontable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Miguel Coloma
 */
@Named("dtFilterView")
@ManagedBean
@ViewScoped
public class CuentasContablesUI implements Serializable {

    /**
     * @return the resultados
     */
    public List<Cuentacontable> getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(List<Cuentacontable> resultados) {
        this.resultados = resultados;
    }

    /**
     * @return the cuentaItem
     */
    public List<SelectItem> getCuentaItem() {
        return cuentaItem;
    }

    /**
     * @param cuentaItem the cuentaItem to set
     */
    public void setCuentaItem(List<SelectItem> cuentaItem) {
        this.cuentaItem = cuentaItem;
    }

    /**
     * @return the cuentacontable
     */
    public List<Cuentacontable> getCuentacontable() {
        return cuentacontable;
    }

    /**
     * @param cuentacontable the cuentacontable to set
     */
    public void setCuentacontable(List<Cuentacontable> cuentacontable) {
        this.cuentacontable = cuentacontable;
    }

    /**
     * @return the filteredCuenta
     */
    public List<Cuentacontable> getFilteredCuenta() {
        return filteredCuenta;
    }

    /**
     * @param filteredCuenta the filteredCuenta to set
     */
    public void setFilteredCuenta(List<Cuentacontable> filteredCuenta) {
        this.filteredCuenta = filteredCuenta;
    }

    public CuentasContablesUI(Integer idCuenta, String nombreCuenta, String tipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreCuenta = nombreCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    CuentacontableServicio servicio = new CuentacontableServicio();

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    private Integer idCuenta;
    private String nombreCuenta;
    private String tipoCuenta;
    private List<Cuentacontable> resultados;
    private List<SelectItem> cuentaItem;
    private List<Cuentacontable> cuentacontable;
    private List<Cuentacontable> filteredCuenta;

    public CuentasContablesUI() {
    }

    public void saveCuenta() {
        try {

            CuentacontableServicio nuevaCuenta = new CuentacontableServicio();
            nuevaCuenta.saveCuenta(this.nombreCuenta, this.tipoCuenta);
            cuentacontable = nuevaCuenta.findAllCuenta();
        } catch (Exception e) {
            System.out.println(e + "Error en save CuentasContablesUI");
        }
    }

    @PostConstruct
    public void init() {
        MenuPrincipalUI login = new MenuPrincipalUI();
        login.validarUsuario();
        findAllCuentasContablesUi();
    }

    public void consultaCuentas() {
        try {
            resultados = new ArrayList<>();
            System.out.println("idCuenta buscado" + this.idCuenta);
            resultados = servicio.finderCuentaById(idCuenta);
        } catch (Exception e) {
            System.err.println("Error al consultar");
        }
    }

    public void findAllCuentasContablesUi() {
        try {
            CuentacontableServicio cuentaServ = new CuentacontableServicio();
            cuentacontable = cuentaServ.findAllCuenta();
            cuentaItem = new ArrayList<>();
            for (Cuentacontable cuentas : cuentacontable) {
                cuentaItem.add(new SelectItem(cuentas.getIdcuentacontable(), cuentas.getNombrecuenta(), cuentas.getTipocuenta()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta marcas clase CuentasContablesUI");
        }
    }
}
