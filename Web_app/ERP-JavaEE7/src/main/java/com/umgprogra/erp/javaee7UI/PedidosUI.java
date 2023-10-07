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
public class PedidosUI {

    /**
     * @return the idPedido
     */
    public Integer getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the fecha_pedido
     */
    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    /**
     * @param fecha_pedido the fecha_pedido to set
     */
    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
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
     * @return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    public PedidosUI(Integer idPedido, Date fecha_pedido, String nit, Integer idEmpleado, Integer idProducto, Integer idCliente) {
        this.idPedido = idPedido;
        this.fecha_pedido = fecha_pedido;
        this.nit = nit;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
    }
    private Integer idPedido;
    private Date fecha_pedido;
    private String nit;
    private Integer idEmpleado;
    private Integer idProducto;
    private Integer idCliente;
}
