/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erpUI;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author madis
 */
@ManagedBean
@SessionScoped
@RequestScoped

public class InventarioUI implements Serializable {

    /**
     * @return the codProducto
     */
    public String getCodProducto() {
        return codProducto;
    }

    /**
     * @param codProducto the codProducto to set
     */
    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
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
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the tipo_comercializacion
     */
    public String getTipo_comercializacion() {
        return tipo_comercializacion;
    }

    /**
     * @param tipo_comercializacion the tipo_comercializacion to set
     */
    public void setTipo_comercializacion(String tipo_comercializacion) {
        this.tipo_comercializacion = tipo_comercializacion;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the unidadMed
     */
    public String getUnidadMed() {
        return unidadMed;
    }

    /**
     * @param unidadMed the unidadMed to set
     */
    public void setUnidadMed(String unidadMed) {
        this.unidadMed = unidadMed;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the impuesto_Inventario
     */
    public double getImpuesto_Inventario() {
        return impuesto_Inventario;
    }

    /**
     * @param impuesto_Inventario the impuesto_Inventario to set
     */
    public void setImpuesto_Inventario(double impuesto_Inventario) {
        this.impuesto_Inventario = impuesto_Inventario;
    }

    /**
     * @return the coste
     */
    public double getCoste() {
        return coste;
    }

    /**
     * @param coste the coste to set
     */
    public void setCoste(double coste) {
        this.coste = coste;
    }

    /**
     * @return the margen_Ganancia
     */
    public int getMargen_Ganancia() {
        return margen_Ganancia;
    }

    /**
     * @param margen_Ganancia the margen_Ganancia to set
     */
    public void setMargen_Ganancia(int margen_Ganancia) {
        this.margen_Ganancia = margen_Ganancia;
    }

    /**
     * @return the marca
     */
    public MarcaUI getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(MarcaUI marca) {
        this.marca = marca;
    }

    /**
     * @return the linea
     */
    public LineaUI getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(LineaUI linea) {
        this.linea = linea;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the proveedor
     */
    public int getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
    private String codProducto;
    private String nombre;
    private int cantidad;
    private String tipo_comercializacion;
    private String modelo;
    private String unidadMed;
    private double precio;
    private double impuesto_Inventario;
    private double coste;
    private int margen_Ganancia;
    private MarcaUI marca;
    private LineaUI linea;
    private String grupo;
    private int proveedor;
    
    
}

