/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author josel
 */

@ManagedBean
@SessionScoped
public class FacturaCabUI {

    /**
     * @return the idFacturaCab
     */
    public Integer getIdFacturaCab() {
        return idFacturaCab;
    }

    /**
     * @param idFacturaCab the idFacturaCab to set
     */
    public void setIdFacturaCab(Integer idFacturaCab) {
        this.idFacturaCab = idFacturaCab;
    }

    /**
     * @return the fecha_factura
     */
    public Date getFecha_factura() {
        return fecha_factura;
    }

    /**
     * @param fecha_factura the fecha_factura to set
     */
    public void setFecha_factura(Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    /**
     * @return the fecha_contable
     */
    public Date getFecha_contable() {
        return fecha_contable;
    }

    /**
     * @param fecha_contable the fecha_contable to set
     */
    public void setFecha_contable(Date fecha_contable) {
        this.fecha_contable = fecha_contable;
    }

    /**
     * @return the fecha_vencimiento
     */
    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    /**
     * @param fecha_vencimiento the fecha_vencimiento to set
     */
    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idProveedor
     */
    public Integer getIdProveedor() {
        return idProveedor;
    }

    /**
     * @param idProveedor the idProveedor to set
     */
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * @return the estado_factura
     */
    public String getEstado_factura() {
        return estado_factura;
    }

    /**
     * @param estado_factura the estado_factura to set
     */
    public void setEstado_factura(String estado_factura) {
        this.estado_factura = estado_factura;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the tipoFactura
     */
    public Integer getTipoFactura() {
        return tipoFactura;
    }

    /**
     * @param tipoFactura the tipoFactura to set
     */
    public void setTipoFactura(Integer tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    /**
     * @return the referenciaFactura
     */
    public String getReferenciaFactura() {
        return referenciaFactura;
    }

    /**
     * @param referenciaFactura the referenciaFactura to set
     */
    public void setReferenciaFactura(String referenciaFactura) {
        this.referenciaFactura = referenciaFactura;
    }

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    /**
     * @return the plazos_pago
     */
    public Integer getPlazos_pago() {
        return plazos_pago;
    }

    /**
     * @param plazos_pago the plazos_pago to set
     */
    public void setPlazos_pago(Integer plazos_pago) {
        this.plazos_pago = plazos_pago;
    }

    public FacturaCabUI(Integer idFacturaCab, Date fecha_factura, Date fecha_contable, Date fecha_vencimiento, String nit, String nombre, Integer idProveedor, String estado_factura, Double total, Integer tipoFactura, String referenciaFactura, Integer idCliente, Integer idEmpleado, Integer plazos_pago) {
        this.idFacturaCab = idFacturaCab;
        this.fecha_factura = fecha_factura;
        this.fecha_contable = fecha_contable;
        this.fecha_vencimiento = fecha_vencimiento;
        this.nit = nit;
        this.nombre = nombre;
        this.idProveedor = idProveedor;
        this.estado_factura = estado_factura;
        this.total = total;
        this.tipoFactura = tipoFactura;
        this.referenciaFactura = referenciaFactura;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.plazos_pago = plazos_pago;
    }

    private Integer idFacturaCab;
    private Date fecha_factura;
    private Date fecha_contable;
    private Date fecha_vencimiento;
    private String nit;
    private String nombre;
    private Integer idProveedor;
    private String estado_factura;
    private Double total;
    private Integer tipoFactura;
    private String referenciaFactura;
    private Integer idCliente;
    private Integer idEmpleado;
    private Integer plazos_pago;
}

