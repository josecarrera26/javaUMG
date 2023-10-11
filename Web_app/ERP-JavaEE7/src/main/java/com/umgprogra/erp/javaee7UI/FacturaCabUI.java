/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erpUI;

import com.umgprogra.erp.ui.services.Facturas;
import java.util.Date;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author josel
 */

@SessionScoped
@Named
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
     * @return the fecha_registro
     */
    public Date getFecha_registro() {
        return fecha_registro;
    }

    /**
     * @param fecha_registro the fecha_registro to set
     */
    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
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
     * @return the idTipoCliente
     */
    public Integer getIdTipoCliente() {
        return idTipoCliente;
    }

    /**
     * @param idTipoCliente the idTipoCliente to set
     */
    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
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
     * @return the tipo_pago
     */
    public Integer getTipo_pago() {
        return tipo_pago;
    }

    /**
     * @param tipo_pago the tipo_pago to set
     */
    public void setTipo_pago(Integer tipo_pago) {
        this.tipo_pago = tipo_pago;
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

    private Integer idFacturaCab;
    private Date fecha_registro;
    private Integer plazos_pago;
    private String referenciaFactura;
    private Integer idEmpleado;
    private Integer idTipoCliente;
    private String estado_factura;
    private Double total;
    private Integer tipo_pago;
    private String nit;
    private Integer tipoFactura;

    public FacturaCabUI(Integer idFacturaCab, Date fecha_registro, Integer plazos_pago, String referenciaFactura, Integer idEmpleado, Integer idTipoCliente, String estado_factura, Double total, Integer tipo_pago, String nit, Integer tipoFactura) {
        this.idFacturaCab = idFacturaCab;
        this.fecha_registro = fecha_registro;
        this.plazos_pago = plazos_pago;
        this.referenciaFactura = referenciaFactura;
        this.idEmpleado = idEmpleado;
        this.idTipoCliente = idTipoCliente;
        this.estado_factura = estado_factura;
        this.total = total;
        this.tipo_pago = tipo_pago;
        this.nit = nit;
        this.tipoFactura = tipoFactura;
    }
    
    public FacturaCabUI(){}
    
    public void CrearFactura(){}
    
//    public Integer lastFactura(){
//    Facturas ultimaFactura = new Facturas();
//    
//    return ultimaFactura.lastFactura();
//    }
}
