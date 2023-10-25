/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.ui.services.EmpleadoServicio;
import com.umgprogra.erp.ui.services.Pedidos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author josel
 */
@ManagedBean
@SessionScoped
public class PedidosUI {

    /**
     * @return the empleados
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * @return the empleadosItem
     */
    public List<SelectItem> getEmpleadosItem() {
        return empleadosItem;
    }

    /**
     * @param empleadosItem the empleadosItem to set
     */
    public void setEmpleadosItem(List<SelectItem> empleadosItem) {
        this.empleadosItem = empleadosItem;
    }

    /**
     * @return the ultimoPedido
     */
    public Integer getUltimoPedido() {
        return ultimoPedido;
    }

    /**
     * @param ultimoPedido the ultimoPedido to set
     */
    public void setUltimoPedido(Integer ultimoPedido) {
        this.ultimoPedido = ultimoPedido;
    }

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

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PedidosUI(Integer idPedido, Date fecha_pedido, String nit, Integer idEmpleado, Integer idProducto, Integer idCliente, String estado) {
        this.idPedido = idPedido;
        this.fecha_pedido = fecha_pedido;
        this.nit = nit;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.estado = estado;
    }
    private Integer idPedido;
    private Date fecha_pedido;
    private String nit;
    private Integer idEmpleado;
    private Integer idProducto;
    private Integer idCliente;
    private String estado;

    private Integer ultimoPedido;

    private List<Empleado> empleados;
    private List<SelectItem> empleadosItem;

    public PedidosUI() {
    }

    @PostConstruct
    public void init() {
        MenuPrincipalUI login = new MenuPrincipalUI();
        login.validarUsuario();
        obtenerUltimaFactura();
        findAllEmpleados();
    }

    public void obtenerUltimaFactura() {
        try {
            Pedidos pedido = new Pedidos();
            ultimoPedido = pedido.getLastPedido();
        } catch (Exception e) {
            System.out.println("Error al consultar ultimo numero de factura");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }

    public void findAllEmpleados() {

        try {
            EmpleadoServicio empleadoServicio = new EmpleadoServicio();
            empleados = empleadoServicio.findAllEmpleados();
            empleadosItem = new ArrayList<>();

            for (Empleado empleadoobj : getEmpleados()) {
                getEmpleadosItem().add(new SelectItem(empleadoobj.getIdempleado(), empleadoobj.getNombreEmpleado()));
            }
        } catch (Exception e) {
            System.out.println("Error al consultar clase Empleado " + e.getMessage());
        }

    }
}
