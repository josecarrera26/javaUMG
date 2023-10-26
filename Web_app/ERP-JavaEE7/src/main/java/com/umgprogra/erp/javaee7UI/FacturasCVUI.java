/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Cliente;
import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.ui.services.FacturasServicio;
import com.umgprogra.erp.util.SessionUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author madis
 */
@ManagedBean
@SessionScoped
public class FacturasCVUI implements Serializable {

    /**
     * @return the listaActualizada
     */
    public List<FacturasCVUI> getListaActualizada() {
        return listaActualizada;
    }

    /**
     * @param listaActualizada the listaActualizada to set
     */
    public void setListaActualizada(List<FacturasCVUI> listaActualizada) {
        this.listaActualizada = listaActualizada;
    }

    /**
     * @return the precioUnitario
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the totalFac
     */
    public double getTotalFac() {
        return totalFac;
    }

    /**
     * @param totalFac the totalFac to set
     */
    public void setTotalFac(double totalFac) {
        this.totalFac = totalFac;
    }

    /**
     * @return the productos
     */
    public List<Inventario> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Inventario> productos) {
        this.productos = productos;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotalD() {
        return subTotalD;
    }

    /**
     * @param subTotalD the subTotal to set
     */
    public void setSubTotalD(double subTotalD) {
        this.subTotalD = subTotalD;
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
     * @return the productosItems
     */
    public List<SelectItem> getProductosItems() {
        return productosItems;
    }

    /**
     * @param productosItems the productosItems to set
     */
    public void setProductosItems(List<SelectItem> productosItems) {
        this.productosItems = productosItems;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the plazos_pago
     */
    public int getPlazos_pago() {
        return plazos_pago;
    }

    /**
     * @param plazos_pago the plazos_pago to set
     */
    public void setPlazos_pago(int plazos_pago) {
        this.plazos_pago = plazos_pago;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the tipo_pago
     */
    public int getTipo_pago() {
        return tipo_pago;
    }

    /**
     * @param tipo_pago the tipo_pago to set
     */
    public void setTipo_pago(int tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    /**
     * @return the Clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param Clientes the Clientes to set
     */
    public void setClientes(List<Cliente> Clientes) {
        this.clientes = Clientes;
    }

    /**
     * @return the clienteItems
     */
    public List<SelectItem> getClienteItems() {
        return clienteItems;
    }

    /**
     * @param clienteItems the clienteItems to set
     */
    public void setClienteItems(List<SelectItem> clienteItems) {
        this.clienteItems = clienteItems;
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
     * @return the idFacturaCab
     */
    public int getIdFacturaCab() {
        return idFacturaCab;
    }

    /**
     * @param idFacturaCab the idFacturaCab to set
     */
    public void setIdFacturaCab(int idFacturaCab) {
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
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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
     * @return the lastFactura
     */
    public int getLastFactura() {
        return lastFactura;
    }

    /**
     * @param lastFactura the lastFactura to set
     */
    public void setLastFactura(int lastFactura) {
        this.lastFactura = lastFactura;
    }

    //FACTURACABVARIABLES
    //variables para llenarCBS
    private String nombreCliente;
    private int plazos_pago;
    private int idCliente;
    private int tipo_pago;
    private List<Cliente> clientes;
    private List<SelectItem> clienteItems;
    private List<SelectItem> plazosPago;
    private List<SelectItem> tipoPago;
    private List<Inventario> productos;
    private List<SelectItem> productosItems;

    private int idFacturaCab;
    private Date fecha_registro;

    private int idEmpleado;

    //VARIABLES DE TABLADETALLE LOCAL
    private Double total;

    //varibles para DB
    private String nit;
    private int idProducto;
    private int cantidad;
    //captura la ultima factura
    private int lastFactura;
    
    
    //variables de facturaDET
    private double precioUnitario;
    private double iva;
    private String nombreProducto;
    private double subTotalD;
    private double totalFac;
    private double subTotal;
    
    ///PRUEBAS
    
    private List<FacturasCVUI> listaActualizada;
    
    

    //constructor para TablaventaDetalle
   public FacturasCVUI(Integer cantidad, double precioUnitario, double iva, Integer idProducto, double subTotalD, String nombreProducto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.iva = iva;
        this.idProducto = idProducto;
        this.subTotalD = subTotalD;
        this.nombreProducto = nombreProducto;
    }
   
   public FacturasCVUI(double totalFac, List<FacturasCVUI> listaActualizada) {
        this.totalFac = totalFac;
        this.listaActualizada = listaActualizada;
    }
   
  

    //METODOS PARA LLEVAR LOS CBS
    public void plazosPago() {
        plazosPago = new ArrayList();
        plazosPago.add(new SelectItem(1, "Pago unico"));
        plazosPago.add(new SelectItem(2, "2 pagos"));
        plazosPago.add(new SelectItem(3, "3 pagos"));
    }

    public void tipopagos() {
        tipoPago = new ArrayList();
        tipoPago.add(new SelectItem(1, "Efectivo"));
        tipoPago.add(new SelectItem(2, "Tarjeta"));
    }
    
    public void getProductosAll() {

        FacturasServicio prod = new FacturasServicio();
        setProductos(prod.listadoProductos());
        try {

            for (Inventario inventario : getProductos()) {
                productosItems.add(new SelectItem(inventario.getIdproducto(), inventario.getNombre()));

            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta para llenar lista de productos FacturasCVUI");
        }

    }

    public void getClienteCB() {

        FacturasServicio facturaServ = new FacturasServicio();
        clientes = facturaServ.listadoClientes();
        try {

            for (Cliente cliente : clientes) {
                clienteItems.add(new SelectItem(cliente.getIdcliente(), cliente.getNombreCliente()));

            }
        } catch (Exception e) {
            System.out.println(e + "Error en llenar CB Cliente FacturaCab");
        }

    }

    //METODO PARA LLENAR EL IDFACTURA(SIRVE SOLO PARA LA VISTA)
    public void getUltimaFactura() {
        try {
            FacturasServicio factura = new FacturasServicio();
            //Facturacab utimaFactura = new Facturacab();

            lastFactura = factura.getLastFactura();
            System.out.println("DATO IDFAC VISTA UI" + lastFactura);
        } catch (Exception e) {
            System.out.println("Error al consultar ultimo numero de factura");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
    
    //METODOS PARA LA TABLALOCAL
    public void agregarProducto(){
        FacturasServicio fac = new FacturasServicio();
        FacturasCVUI prodTabla = fac.agregarProducto(this.idProducto, this.cantidad, this.totalFac, listaActualizada);
        listaActualizada = prodTabla.getListaActualizada();
        totalFac = prodTabla.getTotalFac();
    }
    
    
    
    
    //METODO PARA GUARDAR FACTURAS
     public void insertFacturaCab() {
        try {
            System.out.println("valor total " + subTotal);
            FacturasServicio nuevaFactura = new FacturasServicio();
            nuevaFactura.insertarFacturacab(this.plazos_pago, this.idCliente, 0.00, this.tipo_pago, this.nit);
                
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
     
      //registrar factura venta
//    public void registroFacturaDet() {
//        //FacturaDetServicio registroFac = new FacturaDetServicio();
//        boolean exito = false;
//        try {
//            if (listadoproductos.isEmpty()) {
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Listado vacio", "No se pudo registrar el producto");
//                FacesContext.getCurrentInstance().addMessage(null, message);
//            } else {
//                for (FacturasDET lista : listadoproductos) {
//                    Integer idProd = lista.getIdProducto();
//                    Integer cantidadprod = lista.getCantidad();
//                    exito = registroFac.registroFacturaDet(cantidadprod, idProd, getTotalFac());
//
//                }
//                if (exito == true) {
//                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Todos los productos registrados con éxito");
//                    FacesContext.getCurrentInstance().addMessage(null, message);
//                    this.setTotalFac(0);
//                }
//            }
//
//        } catch (Exception e) {
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo registrar el producto");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//
//        }
//
//        // Limpia la lista después de procesar los productos
//        this.cantidad = 0;
//        this.idProducto = 0;
//        this.cantidad = 0;
//        this.setTotalFac(0);
//        listadoproductos.clear();
//    }

}
