/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.ui.services.FacturaDetServicio;
import com.umgprogra.erp.util.JpaUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ferna
 */
@ManagedBean
@SessionScoped
public class FacturasDET implements Serializable {

    List<FacturasDET> listadoproductos = new ArrayList<>();

    private Integer cantidad;
    private double precioUnitario;
    private double iva;
    private Integer idProducto;
    private double subTotal;
    private String nombreProducto;

    //constructores
    public FacturasDET(Integer cantidad, double precioUnitario, double iva, Integer idProducto, double subTotal, String nombreProducto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.iva = iva;
        this.idProducto = idProducto;
        this.subTotal = subTotal;
        this.nombreProducto = nombreProducto;
    }

    public FacturasDET() {
    }

    //getter y setter
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    //funciones 
    public void registroFacturaDet() {
        FacturaDetServicio registroFac = new FacturaDetServicio();
        try {
            for (FacturasDET lista : listadoproductos) {
                Integer idProd = lista.getIdProducto();
                Integer cantidadprod = lista.getCantidad();

                boolean exito = registroFac.registroFacturaDet(cantidadprod, idProd);

            }
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Todos los productos registrados con éxito");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo registrar el producto");
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

        // Limpia la lista después de procesar los productos
        listadoproductos.clear();
    }

    public void agregarProducto() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        FacturasDET facDET = new FacturasDET();

        try {
            //para validacion de existacia en las tablas
            Inventario inventario = entityManager.find(Inventario.class, this.idProducto);
            int cantidadInventario = inventario.getCantidad();
            if (cantidadInventario > this.cantidad) {

                //obtenenemos el precio unitario del producto
                double preciounitario = inventario.getPrecioventa();
                String nombreProd = inventario.getNombre();
                //calculo del iva
                double iva = (preciounitario * this.cantidad) * 0.12;
                //calculo del subtotal
                double subTotal = preciounitario * this.cantidad;

                //seteamos los datos a la clase de facturaDET para agregarlo a una lista
                facDET.setCantidad(this.cantidad);
                facDET.setIdProducto(this.idProducto);
                facDET.setIva(iva);
                facDET.setNombreProducto(nombreProd);
                facDET.setPrecioUnitario(preciounitario);
                facDET.setSubTotal(subTotal);
                //agregamos el objeto a la lista
                listadoproductos.add(facDET);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Producto insertado con éxito."));

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "valor nulo o falta de inventario", "No se pudo insertar el producto."));

            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "valor nulo o falta de inventario", "No se pudo insertar el producto."));

        } finally {
            entityManager.close();
        }
        this.idProducto = 0;
        this.cantidad = 0;

    }

    public List<FacturasDET> mostrarListProd() {
        List<FacturasDET> mostrar = new ArrayList<>();
        for (FacturasDET lista : listadoproductos) {
            mostrar.add(lista);
        }

        return mostrar;

    }

}
