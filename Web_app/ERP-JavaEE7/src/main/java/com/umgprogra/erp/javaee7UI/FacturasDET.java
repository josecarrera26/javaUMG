/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.ui.services.FacturaDetServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ferna
 */
@ManagedBean
@SessionScoped
public class FacturasDET implements Serializable {

    private Integer idFacturaDet;
    private Integer cantidad;
    private double precioUnitario;
    private double iva;
    private Integer idProducto;

    //constructores
    public FacturasDET(Integer idFacturaDet, Integer cantidad, double precioUnitario, double iva, Integer idProducto) {
        this.idFacturaDet = idFacturaDet;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
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

//    public void listaProducto() {
//        // Creación de lista
//        List<FacturasDET> ListProd = new ArrayList<>();
//
//        if (this.idProducto == 0 || this.precioUnitario == 0 || this.cantidad == 0 || this.iva == 0) {
//            // Algunos campos no se han completado correctamente, muestra un mensaje de error.
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor, complete todos los campos correctamente.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        } else {
//            // Los campos se completaron correctamente, crea un nuevo producto y agrégalo a la lista.
//            FacturasDET producto = new FacturasDET();
//            // Asigna los valores de los campos a la instancia del producto
//            producto.setIdProducto(this.idProducto);
//            producto.setPrecioUnitario(this.precioUnitario);
//            producto.setCantidad(this.cantidad);
//            producto.setIva(this.iva);
//
//            // Agregar el producto a la lista
//            ListProd.add(producto);
//
//            // Reinicia los valores de los campos
////            this.idProducto = 0;
////            this.precioUnitario = 0;
////            this.cantidad = 0;
////            this.iva = 0;
//        }
//    }

    public void registroFacturaDet() {

        FacturaDetServicio registroFac = new FacturaDetServicio();

        boolean exito = registroFac.registroFacturaDet(idFacturaDet, cantidad, precioUnitario, idProducto);
        if (exito) {
            // Éxito: muestra un mensaje de éxito
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Proveedor registrado con éxito");
            FacesContext.getCurrentInstance().addMessage(null, message);
            this.idProducto = null;
            this.cantidad = null;
            this.precioUnitario = 0;

        } else {
            // Error: muestra un mensaje de error
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo registrar el proveedor");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

}
