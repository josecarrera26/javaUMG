/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.ui.services.FacturaDetServicio;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ferna
 */
@ManagedBean
@SessionScoped
public class FacturasDET {

    private Integer idFacturaDet;
    private Integer cantidad;
    private double precioUnitario;
    private double subtotal;
    private double iva;
    private Integer idProducto;

    //constructores
    public FacturasDET(Integer idFacturaDet, Integer cantidad, double precioUnitario, double subtotal, double iva, Integer idProducto) {
        this.idFacturaDet = idFacturaDet;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.iva = iva;
        this.idProducto = idProducto;
    }

    public FacturasDET() {
    }

    //getter y setter
    public Integer getIdFacturaDet() {
        return idFacturaDet;
    }

    public void setIdFacturaDet(Integer idFacturaDet) {
        this.idFacturaDet = idFacturaDet;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void eliminarLineaFactura() {

    }

    // FacturaCabUI idFac = new FacturaCabUI(); 
    public void RegistroFacturaDetalle() {
        Proveedores id = new Proveedores();
        FacturaDetServicio registroFac = new FacturaDetServicio();
        
        Integer idFacturaCab = id.getIdProveedor();
        
        registroFac.registroFacturaDet( idFacturaCab , this.cantidad, this.cantidad, this.cantidad, this.idProducto);
        
        

    }

}
