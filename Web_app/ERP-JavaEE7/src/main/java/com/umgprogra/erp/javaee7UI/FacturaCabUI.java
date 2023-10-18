/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.ui.services.FacturasServicio;
import com.umgprogra.erp.util.SessionUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author josel
 */
@ManagedBean
@SessionScoped
public class FacturaCabUI {

     /**
     * @return the sessionUser
     */
    public SessionUser getSessionUser() {
        return sessionUser;
    }

    /**
     * @param sessionUser the sessionUser to set
     */
    public void setSessionUser(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }

    /**
     * @return the lastFactura
     */
    public Integer getLastFactura() {
        return lastFactura;
    }


    /**
     * @return the tipoPago
     */
    public List<SelectItem> getTipoPago() {
        return tipoPago;
    }

    /**
     * @param tipoPago the tipoPago to set
     */
    public void setTipoPago(List<SelectItem> tipoPago) {
        this.tipoPago = tipoPago;
    }

    /**
     * @return the tipoFacturaList
     */
    public List<SelectItem> getTipoFacturaList() {
        return tipoFacturaList;
    }

    /**
     * @param tipoFacturaList the tipoFacturaList to set
     */
    public void setTipoFacturaList(List<SelectItem> tipoFacturaList) {
        this.tipoFacturaList = tipoFacturaList;
    }

    /**
     * @return the plazosPago
     */
    public List<SelectItem> getPlazosPago() {
        return plazosPago;
    }

    /**
     * @param plazosPago the plazosPago to set
     */
    public void setPlazosPago(List<SelectItem> plazosPago) {
        this.plazosPago = plazosPago;
    }

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
     * @return the empleadoItems
     */
    public List<SelectItem> getEmpleadoItems() {
        return empleadoItems;
    }

    /**
     * @param empleadoItems the empleadoItems to set
     */
    public void setEmpleadoItems(List<SelectItem> empleadoItems) {
        this.empleadoItems = empleadoItems;
    }

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
    private Integer idEmpleado;
    private Integer idTipoCliente;
    private String estado_factura;
    private Double total;
    private Integer tipo_pago;
    private String nit;
    private Integer tipoFactura;
    private List<Empleado> empleados;
    private List<SelectItem> empleadoItems;
    private List<SelectItem> plazosPago;
    private List<SelectItem> tipoPago;
    private List<SelectItem> tipoFacturaList;
    private Integer lastFactura;
    
        @PostConstruct
    public void init() {
        plazosPago();
        pagos();
        tipoFactura();
        getUltimaFactura();
    }

     @Inject
    private SessionUser sessionUser = (SessionUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session");
    
    public void plazosPago(){
        plazosPago = new ArrayList();
        plazosPago.add(new SelectItem(1,"Pago unico"));
        plazosPago.add(new SelectItem(2,"2 pagos"));
        plazosPago.add(new SelectItem(3,"3 pagos"));
    }
    
    public void pagos(){
        tipoPago = new ArrayList();
        tipoPago.add(new SelectItem(1,"Efectivo"));
        tipoPago.add(new SelectItem(2,"Tarjeta"));
    }
    
    public void tipoFactura(){
        tipoFacturaList = new ArrayList();
        tipoFacturaList.add(new SelectItem(1,"Compra"));
        tipoFacturaList.add(new SelectItem(2,"Venta"));
    }
    
    public void getUltimaFactura(){
        try{
            FacturasServicio factura = new FacturasServicio();
            //Facturacab utimaFactura = new Facturacab();
            
            lastFactura = factura.getLastFactura();
            System.out.println("DATO IDFAC VISTA UI"+lastFactura);
        }
        catch (Exception e) {
            System.out.println("Error al consultar ultimo numero de factura");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
    
    public void insertFacturaCab() {
        try{
        FacturasServicio nuevaFactura = new FacturasServicio();
        System.out.println("Username: " + sessionUser.getIdUser());
        nuevaFactura.insertarFacturacab(this.plazos_pago,  sessionUser.getIdUser(), this.idTipoCliente, 0.00, this.tipo_pago, this.nit, this.tipoFactura);
        }
        catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }

}
